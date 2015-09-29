/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ese2.web.bean;

import ch.ese2.model.Customer;
import ch.ese2.model.WorkingTeam;
import ch.ese2.model.dao.CustomerFacade;
import ch.ese2.model.dao.WorkingTeamFacade;
import ch.ese2.web.util.RedirectValue;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author foxhound
 */
@Named
@RequestScoped
public class RegistrationBean {
    
    @Inject
    private CustomerFacade customerFacade;
    
    @Inject
    private WorkingTeamFacade workingTeamFacade;
    
    private Customer newCustomer;
    
    private List<WorkingTeam> availableTeams;
    
    public RegistrationBean(){
        
    }
    
    @PostConstruct
    private void init(){
        newCustomer = new Customer();
        availableTeams = workingTeamFacade.findAll();
    }
    
    public String registerCustomer() {
        try {
            customerFacade.create(newCustomer);
            return RedirectValue.SHOW;
        } catch (Exception ex) {
            ex.printStackTrace();
            return RedirectValue.INDEX;
        }
    }

    public Customer getNewCustomer() {
        return newCustomer;
    }

    public void setNewCustomer(Customer newCustomer) {
        this.newCustomer = newCustomer;
    }

    public List<WorkingTeam> getAvailableTeams() {
        return availableTeams;
    }
}
