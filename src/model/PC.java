package model;

public class PC {
    
    public PC(){
        this.id = -1;
        this.address = "000.000.000.000";
        this.name = "NULL";
    }
    
    public PC(int id, String add, String name){
        this.id = id;
        this.address = add;
        this.name = name;
    }
    
    @Override
    public String toString(){
        return " intance of (PC) [id="+id+"] | [address="+address+"] | [name="+name+"]";
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    int id = -1;
    String address = "000.000.000.000";
    String name = "NULL";
}
