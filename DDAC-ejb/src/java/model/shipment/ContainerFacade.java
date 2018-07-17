/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.shipment;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author abspk
 */
@Stateless
public class ContainerFacade extends AbstractFacade<Container> {

    @PersistenceContext(unitName = "DDAC-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContainerFacade() {
        super(Container.class);
    }

    public List<Container> getContainers() {
        List<Container> container = null;
        Query q = em.createNamedQuery("Container.getAll");
        try {
            container = q.getResultList();
            return container;

        } catch (Exception x) {
            return container;
        }
    }
    
    public Container getContainer(String vessel) {
        Container container = null;
        Query q = em.createNamedQuery("Container.getByVessel");
        q.setParameter("vessel", vessel);
        try {
            container = (Container) q.getSingleResult();
            return container;

        } catch (Exception x) {
            return container;
        }
    }
}
