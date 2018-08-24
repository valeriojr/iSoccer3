package Data.Resources.Buildings.StadiumData;

import Data.AddressData.AddressData;
import Data.Resources.Buildings.BuildingData;

public class StadiumData extends BuildingData {
    public static final String CAPACITY = "Capacidade",
            BATHROOMS = "Quantidade de banheiros", SNACK_BARS = "Quantidade de lanchonetes";

    private BuildingData buildingData;
    private int capacity, bathrooms, snackBars;

    public StadiumData(){
        this.buildingData = null;
        this.capacity = 0;
        this.bathrooms = 0;
        this.snackBars = 0;
    }

    public void setBuildingData(BuildingData buildingData) {
        this.buildingData = buildingData;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public void setSnackBars(int snackBars) {
        this.snackBars = snackBars;
    }

    @Override
    public String toString() {
        return buildingData.toString() + String.format("%s: %d\n%s: %d\n%s: %d\n", CAPACITY, capacity, BATHROOMS,
                bathrooms, SNACK_BARS, snackBars);
    }
}
