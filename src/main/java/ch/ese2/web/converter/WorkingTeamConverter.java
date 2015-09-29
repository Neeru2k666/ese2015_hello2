package ch.ese2.web.converter;

import ch.ese2.model.WorkingTeam;
import ch.ese2.model.dao.WorkingTeamFacade;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * {Insert description here}
 * @author Marc Jost, 29.09.2015
 */
@Named
@ApplicationScoped
public class WorkingTeamConverter implements Converter{
    
    @Inject
    private WorkingTeamFacade workingTeamFacade;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
         if (value == null || value.isEmpty()) {
            return null;
        }

        try {
            Class<?> type = component.getValueExpression("value").getType(context.getELContext());
            return workingTeamFacade.find(Long.valueOf(value));
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(String.format("%s is not a valid ID of WorkingTeam", value)), e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       if (value == null) {
            return "";
        }

        if (value instanceof WorkingTeam) {
            Number id = ((WorkingTeam) value).getId();
            return (id != null) ? id.toString() : null;
        } else {
            throw new ConverterException(new FacesMessage(String.format("%s is not a valid WorkingTeam", value)));
        }
    }
}
