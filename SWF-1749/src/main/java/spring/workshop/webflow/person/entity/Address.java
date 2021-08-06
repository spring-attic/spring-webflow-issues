package spring.workshop.webflow.person.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * An address entity.
 */
@Entity
public class Address extends AbstractPersistable<Long> {

    @NotNull
    @Size(min = 1, max = 30)
    private String street;

    @NotNull
    @Size(min = 1, max = 7)
    private String zipCode;

    @NotNull
    @Size(min = 1, max = 30)
    private String city;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Country country;

    @Size(max = 30)
    private String phone;

    @Size(max = 30)
    @Pattern( regexp = "[a-zA-Z0-9]*@[a-zA-Z0-9]*\\.[a-zA-Z]{2,3}" )
    private String email;

    public Address () {
    }

    public Address ( String street, String zipCode, String city, Country country ) {
        this(street, zipCode, city, country, null, null );
    }

    public Address ( String street, String zipCode, String city, Country country, String phone, String email ) {
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
        this.phone = phone;
        this.email = email;
    }

    public String getStreet () {
        return street;
    }

    public String getZipCode () {
        return zipCode;
    }

    public String getCity () {
        return city;
    }

    public Country getCountry () {
        return country;
    }

    public String getPhone () {
        return phone;
    }

    public String getEmail () {
        return email;
    }

    public void setStreet ( String street ) {
        this.street = street;
    }

    public void setZipCode ( String zipCode ) {
        this.zipCode = zipCode;
    }

    public void setCity ( String city ) {
        this.city = city;
    }

    public void setCountry ( Country country ) {
        this.country = country;
    }

    public void setPhone ( String phone ) {
        this.phone = phone;
    }

    public void setEmail ( String email ) {
        this.email = email;
    }

    @Override
    public String toString () {
        return new ToStringBuilder ( this, ToStringStyle.SIMPLE_STYLE )
                .append ( "street", street )
                .append ( "zipCode", zipCode )
                .append ( "city", city )
                .append ( "country", country )
                .append ( "phone", phone )
                .append ( "email", email )
                .toString ();
    }
}
