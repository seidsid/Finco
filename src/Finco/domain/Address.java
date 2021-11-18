package Finco.domain;

public class Address {
    private String city;
    private String state;
    private int zip;
    private String street;

    public Address(String city, String state, int zip, String street) {
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZip() {
        return zip;
    }

    public String getStreet() {
        return street;
    }
}
