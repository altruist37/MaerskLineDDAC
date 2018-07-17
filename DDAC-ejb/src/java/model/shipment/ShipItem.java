/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.shipment;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import model.Agent;
import model.Customer;

/**
 *
 * @author abspk
 */
@Entity
public class ShipItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = {CascadeType.REMOVE})
    private Customer cust;
    @OneToOne(cascade = {CascadeType.REMOVE})
    private Container vessel;
    @OneToOne(cascade = {CascadeType.REMOVE})
    private Agent agent;
    private double price;
    private int itemNo;
    private int regNo;

    public ShipItem() {
        
    }
    
    public ShipItem(Customer cust, Container vessel, double price, int regNo, int itemNo, Agent agent) {
        this.cust = cust;
        this.vessel = vessel;
        this.price = price;
        this.regNo = regNo;
        this.itemNo = itemNo;
        this.agent = agent;
    }

    public Container getVessel() {
        return vessel;
    }

    public void setVessel(Container vessel) {
        this.vessel = vessel;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }
    
    public Customer getCust() {
        return cust;
    }

    public void setCust(Customer cust) {
        this.cust = cust;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShipItem)) {
            return false;
        }
        ShipItem other = (ShipItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.shipment.ShipItem[ id=" + id + " ]";
    }
    
}
