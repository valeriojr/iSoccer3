package Data.Resources.Buildings.TrainingCenterData;

import Data.Resources.Buildings.BuildingData;

public class TrainingCenterData extends BuildingData {
    public static final String DORMS = "Quantidade de dormitórios";

    private int dorms;

    TrainingCenterData(){
        this.dorms = 0;
    }

    void setDorms(int dorms) {
        this.dorms = dorms;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%s: %d", DORMS, dorms);
    }

    public int getDorms() {
        return dorms;
    }
}
