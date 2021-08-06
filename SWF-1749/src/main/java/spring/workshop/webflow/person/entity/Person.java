package spring.workshop.webflow.person.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * A person entity.
 */
@Entity
public class Person extends AbstractPersistable<Long> {

    @NotNull
    @Size(min = 1, max = 50)
    private String firstName;

    @NotNull
    @Size(min = 1, max = 50)
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Address> addresses = new HashSet<> ();

    public Person () {
    }

    public Person ( String firstName, String lastName ) {
        this(firstName, lastName, new HashSet<Address> () );
    }

    public Person ( String firstName, String lastName, Set<Address> addresses ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.addresses = addresses;
    }

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

    public Set<Address> getAddresses () {
        return addresses;
    }

    public void setAddresses ( Set<Address> addresses ) {
        this.addresses = addresses;
    }

    @Override
    public String toString () {
        return new ToStringBuilder ( this, ToStringStyle.SIMPLE_STYLE )
                .append ( "firstName", firstName )
                .append ( "lastName", lastName )
                .append ( "addresses", addresses )
                .toString ();
    }
}
