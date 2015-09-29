/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ese2.web.bean;

import ch.ese2.model.WorkingTeam;
import ch.ese2.model.dao.WorkingTeamFacade;
import ch.ese2.web.util.RedirectValue;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author foxhound
 */
@Named
@RequestScoped
public class CreateNewWorkingTeamBean {
    
    private WorkingTeam newWorkingTeam;
    
    @Inject
    private WorkingTeamFacade workingTeamFacade;

    public CreateNewWorkingTeamBean() {
        newWorkingTeam = new WorkingTeam();
    }
    
    public String createNewWorkingTeam(){
        workingTeamFacade.create(newWorkingTeam);
        return RedirectValue.SHOWTEAM;
    }

    public WorkingTeam getNewWorkingTeam() {
        return newWorkingTeam;
    }

    public void setNewWorkingTeam(WorkingTeam newWorkingTeam) {
        this.newWorkingTeam = newWorkingTeam;
    }
}
