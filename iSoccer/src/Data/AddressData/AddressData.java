package Data.AddressData;

import Data.Model;

public class AddressData extends Model {
    public static final String ADDRESS = "Endereço", CITY = "Cidade", STATE = "Estado", COUNTRY = "País";

    private String address, city, state, country;

    public AddressData(){
        this.address = null;
        this.city = null;
        this.state = null;
        this.country = null;
    }

    public String getAddress() {
        return address;
    }

    void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        String format = "%s: %s\n%s: %s\n%s: %s\n%s: %s\n";
        return String.format(format, ADDRESS, address, CITY, city, STATE, state, COUNTRY, country);
    }
}
