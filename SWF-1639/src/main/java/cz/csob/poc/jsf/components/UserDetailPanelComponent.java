package cz.csob.poc.jsf.components;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.component.NamingContainer;
import javax.faces.component.UIInput;
import javax.faces.component.UINamingContainer;
import javax.faces.context.FacesContext;

import cz.csob.poc.jsf.model.Client;

@FacesComponent("userDetailComponent")
public class UserDetailPanelComponent extends UIInput implements NamingContainer {

    // Fields -------------------------------------------------------------------------------------

    private UIInput firstName;
    private UIInput surName;

    // Actions ------------------------------------------------------------------------------------

    /**
     * Returns the component family of {@link UINamingContainer}.
     * (that's just required by composite component)
     */
    @Override
    public String getFamily() {
        return UINamingContainer.COMPONENT_FAMILY;
    }

    @Override
    public void encodeBegin(FacesContext context) throws IOException {
        Client client = (Client) getValue();
        
        if (client != null) {
	        firstName.setValue(client.getFirstName());
	        surName.setValue(client.getSurName());
        }
        
        super.encodeBegin(context);
    }

    @Override
    public Client getSubmittedValue() {
    	Client client = new Client();
    	client.setFirstName((String) firstName.getSubmittedValue()); 
    	client.setSurName((String) surName.getSubmittedValue()); 
    	return client;
    }

    @Override
    protected Client getConvertedValue(FacesContext context, Object submittedValue) {
    	Client submittedClient = (Client) submittedValue;
        Client client = Client.copy((Client) getValue());
        client.setFirstName(submittedClient.getFirstName());
        client.setSurName(submittedClient.getSurName());
        return client;
    }

//    /**
//     * Update the available days based on the selected month and year, if necessary.
//     */
//    public void updateDaysIfNecessary(AjaxBehaviorEvent event) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.MONTH, (Integer) month.getValue() - 1);
//        calendar.set(Calendar.YEAR, (Integer) year.getValue());
//        int maxDay = calendar.getActualMaximum(Calendar.DATE);
//
//        if (getDays().length != maxDay) {
//            setDays(createIntegerArray(1, maxDay));
//
//            if ((Integer) day.getValue() > maxDay) {
//                day.setValue(maxDay); // Fix the selected value if it exceeds new max value.
//            }
//
//            FacesContext context = FacesContext.getCurrentInstance(); // Update day field.
//            context.getPartialViewContext().getRenderIds().add(day.getClientId(context));
//        }
//    }

    // Helpers ------------------------------------------------------------------------------------

//    /**
//     * Return specified attribute value or otherwise the specified default if it's null.
//     */
//    @SuppressWarnings("unchecked")
//    private <T> T getAttributeValue(String key, T defaultValue) {
//        T value = (T) getAttributes().get(key);
//        return (value != null) ? value : defaultValue;
//    }
//
//    /**
//     * Create an integer array with values from specified begin to specified end, inclusive.
//     */
//    private static Integer[] createIntegerArray(int begin, int end) {
//        int direction = (begin < end) ? 1 : (begin > end) ? -1 : 0;
//        int size = Math.abs(end - begin) + 1;
//        Integer[] array = new Integer[size];
//
//        for (int i = 0; i < size; i++) {
//            array[i] = begin + (i * direction);
//        }
//
//        return array;
//    }

    // Getters/setters ----------------------------------------------------------------------------

	public UIInput getFirstName() {
		return firstName;
	}

	public void setFirstName(UIInput firstName) {
		this.firstName = firstName;
	}

	public UIInput getSurName() {
		return surName;
	}

	public void setSurName(UIInput surName) {
		this.surName = surName;
	}

//    public UIInput getDay() {
//        return day;
//    }
//
//    public void setDay(UIInput day) {
//        this.day = day;
//    }
//
//    public UIInput getMonth() {
//        return month;
//    }
//
//    public void setMonth(UIInput month) {
//        this.month = month;
//    }
//
//    public UIInput getYear() {
//        return year;
//    }
//
//    public void setYear(UIInput year) {
//        this.year = year;
//    }
//
//    public Integer[] getDays() {
//        return (Integer[]) getStateHelper().get("days");
//    }
//
//    public void setDays(Integer[] days) {
//        getStateHelper().put("days", days);
//    }
//
//    public Integer[] getMonths() {
//        return (Integer[]) getStateHelper().get("months");
//    }
//
//    public void setMonths(Integer[] months) {
//        getStateHelper().put("months", months);
//    }
//
//    public Integer[] getYears() {
//        return (Integer[]) getStateHelper().get("years");
//    }
//
//    public void setYears(Integer[] years) {
//        getStateHelper().put("years", years);
//    }

    
}