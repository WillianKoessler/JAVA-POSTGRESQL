/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.Entity;
import Utilities.Utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author willian
 */
public class Controller {

    private Connection conn;
    private int count;
    private String table;

    public Controller(String Table) {
        try {
            conn = ConnectionFactory.getConnection();
        } catch (SQLException e) {
            Utils.pop("Ocorreu um erro ao se conectar.\nMensagem:" + e.getMessage(), Utils.pop.ERRO);
        }
        count = 0;
        table = Table;
    }

    public int getLastID() {
        return count - 1;
    }

    private void updateID() {
        String sql = "SELECT * FROM " + table + " ORDER BY id DESC LIMIT 1;";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt("id") + 1;
            }
        } catch (SQLException e) {
            Utils.pop("Houve um erro ao buscar o último item do Banco de Dados\nErro: " + e.getMessage(), Utils.pop.ERRO);
        }
    }

    public boolean insert() {
        String sql = "INSERT INTO " + table + "(id) VALUES(-1);";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ps.close();
            sql = "DELETE FROM " + table + " WHERE(id = -1);";
            ps = conn.prepareStatement(sql);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            Utils.pop("DAO: tabela '" + table + "' não existe.\n" + e.getMessage(), Utils.pop.ERRO);
            return false;
        }
        return true;
    }

    public int insert(Entity item) {
        updateID();
        String sql = "INSERT INTO " + table + "(id" + ", " + item.getKeys() + ") VALUES(" + count + ", " + item.getValues() + ");";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            System.out.println(sql);
            ps.execute();
        } catch (SQLException e) {
            Utils.pop("Houve um erro ao inserir o objeto.\n" + item + "\nErro: " + e.getMessage(), Utils.pop.ERRO);
            return -1;
        }
        Utils.pop("PC inserido com Sucesso!", Utils.pop.INFO);
        return count + 1;
    }

    public java.util.ArrayList<Entity> retrieve(Entity mask) {
        String sql;
        if (mask.isEmpty()) {
            sql = "SELECT * FROM " + table + " ORDER BY id DESC;";
        } else {
            sql = "SELECT * FROM " + table + " WHERE(" + mask.getValues("AND") + ") ORDER BY id DESC;";
        }
        if (mask.getID() == -1) {
            sql = sql.replace("id=-1, ", "");
            sql = sql.replace("id,", "");
        }
        System.out.println(sql);
        ResultSet rs;
        java.util.ArrayList<Entity> result = new java.util.ArrayList<>();
        boolean failed = false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            rs = ps.executeQuery();
            int columns = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                Entity temp = new Entity();
                temp.setID(rs.getInt("id"));
                for (int i = 1; i < columns; i++) {
                    String columnName = rs.getMetaData().getColumnName(i + 1);
                    temp.set(columnName, rs.getString(columnName));
                }
                result.add(temp);
            }
            ps.close();
        } catch (SQLException e) {
            Utils.pop("Houve um erro ao buscar objetos onde ("
                    + (mask.getID() > 0 ? mask.getValues(",") : mask.getValues(",").replace("id=-1, ", ""))
                    + ")\nErro: " + e.getMessage(),
                    Utils.pop.ERRO
            );
            failed = true;
        }
        if (failed || result.isEmpty()) {
            Utils.pop("Não foi possível buscar qualquer resultado compatível.", Utils.pop.WARN);
        }
        return result;
    }

    public void update(Entity item) {
        String sql = "SELECT * FROM " + table + " WHERE(id=" + item.getID() + ");";
        System.out.println(sql);
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                sql = "UPDATE " + table + " SET " + item.getValues(",") + " WHERE(id=" + item.getID() + ");";
                ps = conn.prepareStatement(sql);
                ps.execute();
                ps.close();
            }
        } catch (SQLException e) {
            Utils.pop("Erro ao atualizar tabela '" + table + "'.\nitem: " + item + "\nErro: " + e.getMessage(), Utils.pop.ERRO);
            return;
        }
        Utils.pop("Objeto atualizado com sucesso!.\nID:" + item.getID(), Utils.pop.INFO);
    }

    public void delete(int id) {
        String sql = "DELETE FROM " + table + " WHERE(id=" + id + ");";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.execute();
            ps.close();
            Utils.pop("Objeto removido com sucesso!\nID:" + id, Utils.pop.INFO);
        } catch (SQLException e) {
            Utils.pop("Erro ao deletar registro da tabela" + table + "\nID: " + id + "\nErro:" + e.getMessage(), Utils.pop.ERRO);
        }
    }

    public boolean createTable(String name, java.util.List<String> variableNames, java.util.List<String> variableTypes) {
        if (JOptionPane.showConfirmDialog(null, "Deseja criar uma nova tabela?", "Nova Conexão", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
            return false;
        }
        if (variableNames.size() != variableTypes.size()) {
            Utils.pop("A lista de identificadores e de tipos são de tamanhos diferentes.", Utils.pop.ERRO);
            return false;
        }
        String sql = "CREATE TABLE " + name + "(\n";
        sql += " id serial NOT NULL PRIMARY KEY,\n";
        for (int i = 0; i < variableTypes.size(); i++) {
            sql += variableNames.get(i).replaceAll(" ", "_") + " " + variableTypes.get(i) + (i < variableTypes.size() - 1 ? ",\n" : "\n");
        }
        sql += ");";
        System.out.println(sql);
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            if (ps.execute()) {
                Utils.pop("Tabela " + name + "criada com sucesso.", Utils.pop.INFO);
            }
            ps.close();
        } catch (SQLException e) {
            Utils.pop("Não foi possível criar nova tabela " + name + "\nErro: " + e.getMessage(), Utils.pop.ERRO);
            return false;
        }
        return true;
    }
}
