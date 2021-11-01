/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Utilities.Utils;

/**
 *
 * @author willian
 */
public class Entity {

    public Entity() {
        id = -1;
        myData = new java.util.Hashtable<>();
    }

    @Override
    public String toString() {
        String str = "";
        if (id > -1) {
            str += "\t[id = " + id + "]\n";
        }
        if (!myData.isEmpty()) {
            java.util.Enumeration<String> ks = myData.keys();
            for (int i = 0; i < myData.size(); i++) {
                if (ks.hasMoreElements()) {
                    String key = ks.nextElement();
                    str += "\t[" + key + " | " + myData.get(key) + "]\n";
                }
            }
        }
        return str;
    }

    public String getValues(String junction) {
        String str = (id > -1 ? "id='" + id + "'" : "");
        java.util.Enumeration<String> ks = myData.keys();
        for (int i = 0, added = 0; i < myData.size(); i++) {
            String key = ks.nextElement();
            String value = myData.get(key).toString();
            if (!Utils.isNull(value)) {
                str += (id > -1 || added > 0 ? " " + junction + " " : "") + key.replaceAll(" ", "_") + "='" + myData.get(key).toString() + '\'';
                added++;
            }
        }
        return str;
    }

    public String getValues() {
        String str = (id > -1 ? "" + id + "," : "");
        java.util.Enumeration<String> ks = myData.keys();
        for (int i = 0; i < myData.size(); i++) {
            if (ks.hasMoreElements()) {
                str += (i > 0 ? "," : "") + "'" + myData.get(ks.nextElement()).toString() + '\'';
            }
        }
        return str;
    }

    public String getKeys() {
        String str = (id > -1 ? "id," : "");
        java.util.Enumeration<String> ks = myData.keys();
        for (int i = 0; i < myData.size(); i++) {
            if (ks.hasMoreElements()) {
                str += (i > 0 ? ", " : "") + ks.nextElement().replaceAll(" ", "_");
            }
        }
        return str;
    }

    public void set(String key, Object value) {
        myData.put(key, value);
    }

    public Object get(String key) {
        return myData.get(key);
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int size() {
        return myData.size();
    }

    public boolean isEmpty() {
        if(id < 0 && myData.isEmpty()) return true;
        if(myData == null) return true;
        for(int i = 0; i < myData.size(); i++){
            Object val = myData.get(i);
            if(val == null || val.toString().equals("")){
                myData.remove(i);
            }
        }
        return id < 0 && myData.isEmpty();
    }

    private final java.util.Dictionary<String, Object> myData;
    private int id;
}
