package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Client;

public class ClientDAO {

    static int id_count;
    Connection conn;

    public ClientDAO() {
        conn = ConnectionFactory.getConnection();
        id_count = 0;
    }
    
    public void delete(int id){
        String sql = "DELETE FROM client WHERE(id=?);";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            System.out.println("Deleting item from client: id="+id);
            ps.execute();
            ps.close();
        }catch(SQLException e){
            System.out.println("Failed to Delete Item");
            JOptionPane.showMessageDialog(null, "Failed to Delete item.\nException thrown: "+e.getMessage());
        }
    }

    public ArrayList<Client> retrieve(String name, int reg) {
        boolean hasName = name != null && !name.equals("");
        boolean hasReg = reg > -1;
        ArrayList<Client> result = new ArrayList<>();
        ResultSet rs;
        String sql = "SELECT * FROM client";
        boolean failed = false;
        try {
            PreparedStatement ps;
            if (hasName && hasReg) {
                sql += " WHERE(name=?, registry=?) ORDER BY id;";
                ps = conn.prepareStatement(sql);
                ps.setString(1, name);
                ps.setInt(2, reg);
                rs = ps.executeQuery();
            } else if (hasName) {
                sql += " WHERE(name=?) ORDER BY id;";
                ps = conn.prepareStatement(sql);
                ps.setString(1, name);
                rs = ps.executeQuery();
            } else if (hasReg) {
                sql += " WHERE(registry=?) ORDER BY id;";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, reg);
                rs = ps.executeQuery();
            } else {
                sql += " ORDER BY id;";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
            }
            while(rs.next()) 
                result.add(new Client(
                                rs.getInt("id"),
                                rs.getInt("registry"),
                                rs.getString("name")
                        )
                );
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Failed to Query Table 'client'\nException thrown:" + e.getMessage());
            failed = true;
        }
        if(!failed && result.size() < 1){
            JOptionPane.showMessageDialog(null, "Couldn't retrieve any compatible results.");
        }
        return result;
    }

    public void updateID(){
        String sql = "SELECT * FROM client ORDER BY id DESC LIMIT 1;";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                ClientDAO.id_count = rs.getInt("id") + 1;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Failed to retrieve Last Item\nException thrown: "+e.getMessage());
        }
    }
    
    public void insert() {
        String sql = "INSERT INTO client VALUES(-1, '0', 'null');";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ps.close();
            sql = "DELETE FROM client WHERE(id = -1);";
            ps = conn.prepareStatement(sql);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            if(JOptionPane.showConfirmDialog(null, "Table 'CLIENT' doesn't exist.\nCreate new one?", "SQL ERROR", JOptionPane.YES_NO_OPTION) ==
                    JOptionPane.YES_OPTION){
                createTable();
            }else{
                System.exit(0);
            }
        }
    }

    public void insert(Client item) {
        updateID();
        String sql = "INSERT INTO client VALUES(?,?,?);";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id_count++);
            ps.setInt(2, item.getReg());
            ps.setString(3, item.getName());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Object was successifully inserted!\n"+item);
        } catch (SQLException e) {
            System.out.println("Failed to insert object ("+item+")\nException thrown: "+e.getMessage());
            JOptionPane.showMessageDialog(null, "Failed to insert object ("+item+")\nException thrown: "+e.getMessage());
        }
    }

    public void update(Client item){
        String sql = "SELECT * FROM client WHERE(id=?);";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, item.getID());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                boolean name = !item.getName().equals(rs.getString("name"));
                boolean registry = item.getReg() != rs.getInt("registry");
                sql = "UPDATE client SET name=?,registry=? WHERE id=?;";
                ps = conn.prepareStatement(sql);
                if(name && registry){
                    ps.setString(1, item.getName());
                    ps.setInt(2, item.getReg());
                } else if(name){
                    ps.setString(1, item.getName());
                    ps.setInt(2, rs.getInt("registry"));
                } else if(registry){
                    ps.setString(1, rs.getString("name"));
                    ps.setInt(2, item.getReg());
                } else {
                    return;
                }
                ps.setInt(3, item.getID());
                ps.execute();
                ps.close();
            }
        }catch(SQLException e){
            System.out.println("Failed to update table \"client\". [item: "+ item+']');
            JOptionPane.showMessageDialog(null, "Failed to update table \"client\". [item: "+ item+"]\nException thrown: "+e.getMessage());
        }
    }
    
    public void createTable() {
        String sql
                = "CREATE TABLE client\n"
                + "(\n"
                + "  id integer NOT NULL,\n"
                + "  registry integer NOT NULL,\n"
                + "  name character varying(256),\n"
                + "  CONSTRAINT client_pkey PRIMARY KEY (id)\n"
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
