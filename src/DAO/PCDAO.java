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

    public void delete(int id) {
        String sql = "DELETE FROM pc WHERE(id=?);";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            System.out.println("Deleting item from pc: id=" + id);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Failed to Delete Item");
            JOptionPane.showMessageDialog(null, "Failed to Delete item.\nException thrown: " + e.getMessage());
        }
    }

    public ArrayList<PC> retrieve(String name, String ip) {
        boolean hasName = name != null && !name.equals("");
        boolean hasIP = ip != null && !ip.equals("");
        ArrayList<PC> result = new ArrayList<>();
        ResultSet rs;
        String sql = "SELECT * FROM pc";
        boolean failed = false;
        try {
            PreparedStatement ps;
            if (hasName && hasIP) {
                sql += " WHERE(address=?, name=?) ORDER BY id;";
                ps = conn.prepareStatement(sql);
                ps.setString(1, ip);
                ps.setString(2, name);
                rs = ps.executeQuery();
            } else if (hasName) {
                sql += " WHERE(name=?) ORDER BY id;";
                ps = conn.prepareStatement(sql);
                ps.setString(1, name);
                rs = ps.executeQuery();
            } else if (hasIP) {
                sql += " WHERE(address=?) ORDER BY id;";
                ps = conn.prepareStatement(sql);
                ps.setString(1, ip);
                rs = ps.executeQuery();
            } else {
                sql += " ORDER BY id;";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
            }
            while (rs.next()) {
                result.add(new PC(
                        rs.getInt("id"),
                        rs.getString("address"),
                        rs.getString("name")
                )
                );
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Failed to Query Table 'pc'\nException thrown:" + e.getMessage());
            failed = true;
        }
        if(!failed && result.size() < 1){
            JOptionPane.showMessageDialog(null, "Couldn't retrieve any compatible results.");
        }
        return result;
    }

    public void updateID() {
        String sql = "SELECT * FROM pc ORDER BY id DESC LIMIT 1;";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                PCDAO.id_count = rs.getInt("id") + 1;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed to retrieve Last Item\nException thrown: " + e.getMessage());
        }
    }

    public void insert() {
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
            if(JOptionPane.showConfirmDialog(null, "Table 'PC' doesn't exist.\nCreate new one?", "SQL ERROR", JOptionPane.YES_NO_OPTION) ==
                    JOptionPane.YES_OPTION){
                createTable();
            }else{
                System.exit(0);
            }
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
            JOptionPane.showMessageDialog(null, "Object was successifully inserted!\n" + item);
        } catch (SQLException e) {
            System.out.println("Failed to insert object ("+item+")\nException thrown: "+e.getMessage());
            JOptionPane.showMessageDialog(null, "Failed to insert object ("+item+")\nException thrown: "+e.getMessage());
        }
    }

    public void update(PC item) {
        String sql = "SELECT * FROM pc WHERE(id=?);";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, item.getID());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                boolean name = !item.getName().equals(rs.getString("name"));
                boolean address = !item.getAddress().equals(rs.getString("address"));
                sql = "UPDATE pc SET name=?,address=? WHERE id=?;";
                ps = conn.prepareStatement(sql);
                if (name && address) {
                    ps.setString(1, item.getName());
                    ps.setString(2, item.getAddress());
                } else if (name) {
                    ps.setString(1, item.getName());
                    ps.setString(2, rs.getString("address"));
                } else if (address) {
                    ps.setString(1, rs.getString("name"));
                    ps.setString(2, item.getAddress());
                } else {
                    return;
                }
                ps.setInt(3, item.getID());
                ps.execute();
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println("Failed to update table \"pc\". [item: " + item + ']');
            JOptionPane.showMessageDialog(null, "Failed to update table \"pc\". [item: " + item + "]\nException thrown: " + e.getMessage());
        }
    }

    public void createTable() {
        String sql
                = "CREATE TABLE pc\n"
                + "(\n"
                + "  id integer NOT NULL,\n"
                + "  address character varying(16),\n"
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
