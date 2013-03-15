package be.kdg.groeph.model;

import be.kdg.groeph.model.Null.NullAddress;
import be.kdg.groeph.model.Null.Nullable;

import java.io.Serializable;


public class Address implements Nullable, Serializable {

    private int id;

    private String street;

    private String streetNumber;

    private String zipcode;

    private String city;


    public Address() {
    }

    public Address(String street, String streetNumber, String zipcode, String city) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.zipcode = zipcode;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String number) {
        this.streetNumber = number;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zip) {
        this.zipcode = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean isNull() {
        return false;
    }

    public static Address INVALID_ADDRESS() {
        return new NullAddress();
    }
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getStreet());
        sb.append(" ");
        sb.append(getStreetNumber());
        sb.append(" ");
        sb.append(getZipcode());
        sb.append(" ");
        sb.append(getCity());
        return sb.toString();
    }
}


