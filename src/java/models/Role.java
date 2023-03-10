/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;

/**
 *
 * @author Xavier
 */
public class Role implements Serializable {
    int id;
    String name;

    public Role() {
    }

    public Role(int id) {
        this.id = id;
        
        if (id == 1) {
            this.name = "system admin";
        }
        else if (id == 2) {
            this.name = "regular user";
        }
    }
    
    public Role(String name) {
        this.name = name;
        
        if (name.equals("system admin")) {
            this.id = 1;
        }
        else if (name.equals("regular user")) {
            this.id = 2;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
