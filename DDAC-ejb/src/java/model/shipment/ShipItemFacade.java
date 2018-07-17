/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.shipment;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author abspk
 */
@Stateless
public class ShipItemFacade extends AbstractFacade<ShipItem> {

    @PersistenceContext(unitName = "DDAC-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ShipItemFacade() {
        super(ShipItem.class);
    }
    
}
