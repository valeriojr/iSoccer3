package Data.Resources.VehicleData;

import MVC.Controller;

public class VehicleDataController extends Controller {

    public VehicleDataController() {
        super(new VehicleData());

        setView(new VehicleDataView(this));
    }

    @Override
    public void updateModel() {
        updateView();

        VehicleData model = (VehicleData) getModel();

        model.setId(bundle.getString(VehicleData.ID));
        model.setType((VehicleData.Type) bundle.getObject(VehicleData.TYPE));
    }

    @Override
    public void resetModel() {
        model = new VehicleData();
    }
}
