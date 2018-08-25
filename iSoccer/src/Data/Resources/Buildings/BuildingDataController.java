package Data.Resources.Buildings;

import Data.AddressData.AddressData;
import Data.AddressData.AddressDataController;
import Data.Resources.Buildings.BuildingData;
import MVC.Controller;
import MVC.Model;

public class BuildingDataController extends Controller {

    private AddressDataController address;

    public BuildingDataController() {
        super(new BuildingData());

        setView(new BuildingDataView(this));
        address = new AddressDataController();

        getView().getMainPanel().add(address.getView().getMainPanel());
    }

    @Override
    public void updateModel() {
        address.updateView();

        address.updateModel();

        BuildingData model = (BuildingData) getModel();

        model.setName(bundle.getString(BuildingData.NAME));
        model.setAddress((AddressData) address.getModel());
    }

    @Override
    public void resetModel() {
        model = new BuildingData();
    }
}
