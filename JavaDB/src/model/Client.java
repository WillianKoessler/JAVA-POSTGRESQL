/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author willian
 */
public class Client {
    
    public Client(){
        this.id = -1;
        this.reg = -1;
        this.name = "NULL";
    }
    
    public Client(int id, int reg, String name){
        this.id = id;
        this.reg = reg;
        this.name = name;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getReg() {
        return reg;
    }

    public void setReg(int reg) {
        this.reg = reg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString(){
        return "instance of (Cliente) [id="+id+"] | [registry="+reg+"] | [name="+name+"]";
    }
    int id;
    int reg;
    String name;
}
