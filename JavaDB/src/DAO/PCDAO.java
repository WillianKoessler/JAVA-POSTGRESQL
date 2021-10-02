package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.PC;

public class PCDAO {

    static int id_count;
    Connection conn;

    public PCDAO() {
        conn = ConnectionFactory.getConnection();
        id_count = 0;
    }
    
    public void delete(int id){
        String sql = "DELETE FROM pc WHERE(id=?);";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            System.out.println("Deleting item from pc: id="+id);
            ps.execute();
            ps.close();
        }catch(SQLException e){
            System.out.println("Failed to Delete Item");
            JOptionPane.showMessageDialog(null, "Failed to Delete item.\nException thrown: "+e.getMessage());
        }
    }

    public ArrayList<PC> retrieve(String name, String ip) {
        boolean hasName = name != null && !name.equals("");
        boolean hasIP = ip != null && !ip.equals("");
        ArrayList<PC> result = new ArrayList<>();
        
        ResultSet rs = null;
        String sql = "SELECT * FROM pc";
        try {
            PreparedStatement ps;
            if (hasName && hasIP) {
                sql += " WHERE(address=?, name=?);";
                ps = conn.prepareStatement(sql);
                ps.setString(1, ip);
                ps.setString(2, name);
                rs = ps.executeQuery();
            } else if (hasName) {
                sql += " WHERE(name=?);";
                ps = conn.prepareStatement(sql);
                ps.setString(1, name);
                rs = ps.executeQuery();
            } else if (hasIP) {
                sql += " WHERE(address=?);";
                ps = conn.prepareStatement(sql);
                ps.setString(1, ip);
                rs = ps.executeQuery();
            } else {
                sql += ";";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
            }
            while(rs.next()) 
                result.add(new PC(
                                rs.getInt("id"),
                                rs.getString("address"),
                                rs.getString("name")
                        )
                );
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Failed to Query Table 'pc'\nException thrown:" + e.getMessage());
        }
        return result;
    }

    public void updateID(){
        String sql = "SELECT * FROM pc ORDER BY id DESC LIMIT 1;";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                this.id_count = rs.getInt("id") + 1;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Failed to retrieve Last Item\nException thrown: "+e.getMessage());
        }
    }
    
    public void insert() {
        updateID();
        String sql = "INSERT INTO pc(id, address, name) VALUES(-1, '0', 'null');";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ps.close();
            sql = "DELETE FROM pc WHERE(id = -1);";
            ps = conn.prepareStatement(sql);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed to find Table 'pc'. Creating new one...");
            createTable();
        }
    }

    public void insert(PC item) {
        updateID();
        String sql = "INSERT INTO pc(id, address, name) VALUES(?,?,?);";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id_count++);
            ps.setString(2, item.getAddress());
            ps.setString(3, item.getName());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.out.println("PC_DAO ERROR: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void createTable() {
        String sql
                = "CREATE TABLE pc\n"
                + "(\n"
                + "  id integer NOT NULL,\n"
                + "  address character varying(32),\n"
                + "  name character varying(256),\n"
                + "  CONSTRAINT pc_pkey PRIMARY KEY (id )\n"
                + ")\n"
                + "WITH (\n"
                + "  OIDS=FALSE\n"
                + ");\n"
                + "ALTER TABLE pc\n"
                + "  OWNER TO postgres;";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed to Create new Table 'pc'.\nException:" + e.getMessage());
        }
    }
}
