package domain.model;

public final class Address {

    private final String city;
    private final String state;
    private final long zip;
    private final String street;

    public Address(String street, String city, String state, long zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public long getZip() {
        return zip;
    }
}
