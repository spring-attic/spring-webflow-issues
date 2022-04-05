package spring.workshop.webflow.beans;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Bean to handle html form data to create/edit {@link Person person entities}.
 */
@Component("personForm")
public class PersonFormBean implements Serializable {

    private String firstName;

    private String lastName;

    public String getFirstName () {
        return firstName;
    }

    public void setFirstName ( String firstName ) {
        this.firstName = firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public void setLastName ( String lastName ) {
        this.lastName = lastName;
    }
}
