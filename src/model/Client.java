package model;

import java.sql.Date;

public class Client {

    public Client() {
    }

    public Client(int reg, String name, String address, Date birth, String course) {
        this.reg = reg;
        this.name = name;
        this.address = address;
        this.birth = birth;
        this.course = course;
    }
    
    @Override
    public String toString(){
        return " instance of (Client) Registry="+reg+"]";
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    int reg = -1;
    String name = "NULL";
    String address = "none";
    Date birth = new Date(0,0,0);
    String course = "none";
    
    /*
                + "  address character varying(256),\n"
                + "  birth date,\n"
                + "  course character varying(256)\n"
    */
}
