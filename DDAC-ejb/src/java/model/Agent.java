/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author abspk
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Agent.validateLogin", query = "SELECT e FROM Agent e WHERE e.email = :email"),
    @NamedQuery(name = "Agent.getAll", query = "SELECT e FROM Agent e"),
    @NamedQuery(name = "Agent.updateVessel", query = "UPDATE Agent e SET e.vessel = :vessel WHERE e.email = :email"),
})
public class Agent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String email;
    private String name;
    private String address;
    private int tel;
    private String password;
    private String vessel;
    
    public Agent() {
        
    }
    
    public Agent(String email, String name, String address, int tel, String password, String vessel) {
        this.email = email;
        this.tel = tel;
        this.password = password;
        this.address = address;
        this.name = name;
        this.vessel = vessel;
    }
    public String getName() {
        return name;
    }

    public String getVessel() {
        return vessel;
    }

    public void setVessel(String vessel) {
        this.vessel = vessel;
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

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the email fields are not set
        if (!(object instanceof Agent)) {
            return false;
        }
        Agent other = (Agent) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Agent[ id=" + email + " ]";
    }
    
}
