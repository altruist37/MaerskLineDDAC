/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 *
 * @author abspk
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Customer.findByEmail", query = "SELECT e FROM Customer e WHERE e.email = :email"),
    @NamedQuery(name = "Customer.findByAgent", query = "SELECT e FROM Customer e WHERE e.agent = :agent"),
})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String email;
    private String fName;
    private String lName;
    private String address;
    private int tel;
    private String passport;
    @OneToOne(cascade = {CascadeType.REMOVE})
    private Agent agent;

    public Customer() {
        
    }
    
    public Customer(String fName,String lName,String address,String email,String passport,int tel,Agent agent) {
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.email = email;
        this.tel = tel;
        this.passport = passport;
        this.agent = agent;
    }
    
    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }
    
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
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

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
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
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Customer[ id=" + email + " ]";
    }
    
}
