package Data.Resources.Buildings;

import Data.AddressData.AddressData;
import MVC.Model;

public class BuildingData implements Model {
    public static final String NAME = "Nome", ADDRESS = "Endereço";

    private String name;
    private AddressData address;

    public BuildingData(){
        this.name = null;
        this.address = null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(AddressData address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("%s: %s\n", NAME, name) + address.toString();
    }
}
