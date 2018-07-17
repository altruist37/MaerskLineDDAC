/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.shipment;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;

/**
 *
 * @author abspk
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Container.getAll", query = "SELECT e FROM Container e"),
    @NamedQuery(name = "Container.getByVessel", query = "SELECT e FROM Container e WHERE e.vessel = :vessel"),
})
public class Container implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String vessel;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date departureDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date arrivalDate;

    public Container() {
        
    }
    
    public Container(String vessel, Date departure, Date arrival) {
        this.vessel = vessel;
        this.departureDate = departure;
        this.arrivalDate = arrival;
    }
    
    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
    
    
    public String getVessel() {
        return vessel;
    }

    public void setVessel(String vessel) {
        this.vessel = vessel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vessel != null ? vessel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the vessel fields are not set
        if (!(object instanceof Container)) {
            return false;
        }
        Container other = (Container) object;
        if ((this.vessel == null && other.vessel != null) || (this.vessel != null && !this.vessel.equals(other.vessel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.shipment.Container[ id=" + vessel + " ]";
    }
    
}
