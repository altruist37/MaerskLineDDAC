/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
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
public class AgentFacade extends AbstractFacade<Agent> {

    @PersistenceContext(unitName = "DDAC-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AgentFacade() {
        super(Agent.class);
    }
    
    public boolean getLogin(String email, String password) {
        Query q = em.createNamedQuery("Agent.validateLogin");
        Agent m = null;
        
        q.setParameter("email", email);
        try {
            m = (Agent) q.getSingleResult();
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
    
    public List<Agent> getAgents() {
        Query q = em.createNamedQuery("Agent.getAll");
        List<Agent> agent = null;
        
        try {
            agent = q.getResultList();
        } catch(NoResultException x) {
            return agent;
        }
        return agent;
    }
    
    public Agent getAgent(String email) {
        Agent agent = null;
        Query q = em.createNamedQuery("Agent.validateLogin");
        q.setParameter("email", email);
        
        try {
            agent = (Agent) q.getSingleResult();
        } catch(NoResultException x) {
            return agent;
        }
        return agent;
    }
    
    public void upAgent(String vessel, String email) {
        int i = 0;
        Query q = em.createNamedQuery("Agent.updateVessel");
        q.setParameter("vessel", vessel);
        q.setParameter("email", email);
        
        try {
            i = q.executeUpdate();
        } catch(NoResultException x) {
        }
    }
}
