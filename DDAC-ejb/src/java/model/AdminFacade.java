/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author abspk
 */
@Stateless
public class AdminFacade extends AbstractFacade<Admin> {

    @PersistenceContext(unitName = "DDAC-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdminFacade() {
        super(Admin.class);
    }
    
    public boolean getLogin(String email, String password) {
        Query q = em.createNamedQuery("Admin.validateLogin");
        Admin m = null;
        
        q.setParameter("email", email);
        try {
            m = (Admin) q.getSingleResult();
        } catch(NoResultException x) {
            return false;
        }
        
        if(m != null) {
            if(m.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
