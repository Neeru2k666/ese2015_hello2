package ch.ese2.model.dao;

import ch.ese2.model.WorkingTeam;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * {Insert description here}
 * @author Marc Jost, 29.09.2015
 */
@Stateless
public class WorkingTeamFacade extends AbstractFacade<WorkingTeam> {
    @PersistenceContext(unitName = "com.mycompany_HelloWorld_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WorkingTeamFacade() {
        super(WorkingTeam.class);
    }

}
