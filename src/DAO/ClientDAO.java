package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Client;

public class ClientDAO {

    public static int reg_count;
    Connection conn;

    public ClientDAO() {
        try {
            conn = ConnectionFactory.getConnection();
        } catch (SQLException e) {
            if(e.getMessage().equals("A tentativa de conexão falhou.")){
                JOptionPane.showMessageDialog(null, "Falha de autenticação.\nUsuário ou Senha incorretos");
            } else {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ClientDAO SQLException",1);
            }
        }
        reg_count = 0;
    }

    public void delete(int reg) {
        String sql = "DELETE FROM client WHERE(registry=?);";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, reg);
            System.out.println("Deleting item from client: reg=" + reg);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Failed to Delete Item");
            JOptionPane.showMessageDialog(null, "Failed to Delete item.\nException thrown: " + e.getMessage());
        }
    }

    public ArrayList<Client> retrieve(int reg, String name, String course) {
        boolean hasName = name != null && !name.equals("");
        boolean hasReg = reg > -1;
        boolean hasCourse = course != null && !course.equals("");
        ArrayList<Client> result = new ArrayList<>();
        ResultSet rs;
        String sql = "SELECT * FROM client";
        boolean failed = false;
        try {
            PreparedStatement ps;
            if (hasReg && hasName && hasCourse) {
                sql += " WHERE(registry=?, name=?, course=?) ORDER BY registry;";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, reg);
                ps.setString(2, name);
                ps.setString(3, course);
                rs = ps.executeQuery();
            } else if (hasReg && hasName) {
                sql += " WHERE(registry=?, name=?) ORDER BY registry;";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, reg);
                ps.setString(2, name);
                rs = ps.executeQuery();
            } else if (hasName && hasCourse) {
                sql += " WHERE(name=?, course=?) ORDER BY registry;";
                ps = conn.prepareStatement(sql);
                ps.setString(1, name);
                ps.setString(2, course);
                rs = ps.executeQuery();
            } else if (hasReg && hasCourse) {
                sql += " WHERE(registry=?, course=?) ORDER BY registry;";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, reg);
                ps.setString(2, course);
                rs = ps.executeQuery();
            } else if (hasName) {
                sql += " WHERE(name=?) ORDER BY registry;";
                ps = conn.prepareStatement(sql);
                ps.setString(1, name);
                rs = ps.executeQuery();
            } else if (hasReg) {
                sql += " WHERE(registry=?) ORDER BY registry;";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, reg);
                rs = ps.executeQuery();
            } else if (hasCourse) {
                sql += " WHERE(course=?) ORDER BY registry;";
                ps = conn.prepareStatement(sql);
                ps.setString(1, course);
                rs = ps.executeQuery();
            } else {
                sql += " ORDER BY registry;";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
            }
            while (rs.next()) {
                result.add(new Client(
                        rs.getInt("registry"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getDate("birth"),
                        rs.getString("course")
                )
                );
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Failed to Query Table 'client'\nException thrown:" + e.getMessage());
            failed = true;
        }
        if (!failed && result.size() < 1) {
            JOptionPane.showMessageDialog(null, "Couldn't retrieve any compatible results.");
        }
        return result;
    }

    public void updateREG() {
        String sql = "SELECT * FROM client ORDER BY registry DESC LIMIT 1;";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ClientDAO.reg_count = rs.getInt("registry") + 1;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed to retrieve Last Item\nException thrown: " + e.getMessage());
        }
    }

    public void insert() {
        String sql = "INSERT INTO client VALUES(-1, '0', 'null');";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ps.close();
            sql = "DELETE FROM client WHERE(registry = -1);";
            ps = conn.prepareStatement(sql);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            if (JOptionPane.showConfirmDialog(null, "Table 'CLIENT' doesn't exist.\nCreate new one?", "SQL ERROR", JOptionPane.YES_NO_OPTION)
                    == JOptionPane.YES_OPTION) {
                createTable();
            } else {
                System.exit(0);
            }
        }
    }

    /*
    int reg = -1;
    String name = "NULL";
    String address = "none";
    Date birth = new Date(0,0,0);
    String course = "none";
     */

    public int insert(Client item) {
        updateREG();
        String sql = "INSERT INTO client VALUES(?,?,?,?,?);";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, reg_count++);
            ps.setString(2, item.getName());
            ps.setString(3, item.getAddress());
            ps.setDate(4, item.getBirth());
            ps.setString(5, item.getCourse());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Object was successifully inserted!\n" + item);
        } catch (SQLException e) {
            System.out.println("Failed to insert object (" + item + ")\nException thrown: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Failed to insert object (" + item + ")\nException thrown: " + e.getMessage());
        }
        return reg_count;
    }

    public void update(Client item) {
        String sql = "SELECT * FROM client WHERE(registry=?);";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, item.getReg());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                sql = "UPDATE client SET registry=?,name=?,course=?,address=?,birth=? WHERE registry=?;";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, item.getReg());
                ps.setString(2, item.getName());
                ps.setString(3, item.getCourse());
                ps.setString(4, item.getAddress());
                ps.setDate(5, item.getBirth());
                ps.setInt(6, item.getReg());
                ps.execute();
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println("Failed to update table \"client\". [item: " + item + ']');
            JOptionPane.showMessageDialog(null, "Failed to update table \"client\". [item: " + item + "]\nException thrown: " + e.getMessage());
        }
    }

    public void createTable() {
        String sql
                = "CREATE TABLE client\n"
                + "(\n"
                + "  registry integer NOT NULL,\n"
                + "  name character varying(256),\n"
                + "  address character varying(1024),\n"
                + "  birth date,\n"
                + "  course character varying(256),\n"
                + "  CONSTRAINT client_pkey PRIMARY KEY (registry)\n"
                + ")\n"
                + "WITH (\n"
                + "  OIDS=FALSE\n"
                + ");\n"
                + "ALTER TABLE client\n"
                + "  OWNER TO postgres;";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed to Create new Table 'client'.\nException:" + e.getMessage());
        }
    }
}
