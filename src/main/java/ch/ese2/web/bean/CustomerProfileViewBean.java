package ch.ese2.web.bean;

import ch.ese2.model.Customer;
import ch.ese2.model.dao.CustomerFacade;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * {Insert description here}
 * @author Marc Jost, 29.09.2015
 */
@Named
@RequestScoped
public class CustomerProfileViewBean {

    private Customer selectedCustomer;
    
    @Inject
    private CustomerFacade customerFacade;
    
    private Long selectedID;
    
    public CustomerProfileViewBean(){
        
    }
    
    public void onLoad(){
        if(selectedID == null || selectedID <= 0){
            return;
        }
        selectedCustomer = customerFacade.find(selectedID);
    }

    public Customer getSelectedCustomer() {
        return selectedCustomer;
    }

    public void setSelectedCustomer(Customer selectedCustomer) {
        this.selectedCustomer = selectedCustomer;
    }

    public Long getSelectedID() {
        return selectedID;
    }

    public void setSelectedID(Long selectedID) {
        this.selectedID = selectedID;
    }
}
