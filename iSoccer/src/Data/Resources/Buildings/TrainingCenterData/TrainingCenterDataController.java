package Data.Resources.Buildings.TrainingCenterData;

import Data.Resources.Buildings.BuildingData;
import Data.Resources.Buildings.BuildingDataController;
import MVC.Controller;
import MVC.View;

public class TrainingCenterDataController extends Controller {

    private BuildingDataController building;
    private View trainingCenterView;

    public TrainingCenterDataController() {
        super(new TrainingCenterData());

        building = new BuildingDataController();
        trainingCenterView = new TrainingCenterView(this);

        view.getMainPanel().add(building.getView().getMainPanel());
        view.getMainPanel().add(trainingCenterView.getMainPanel());
    }

    @Override
    public void updateModel() {
        building.updateView();
        trainingCenterView.update();

        building.updateModel();

        TrainingCenterData model = (TrainingCenterData) getModel();

        model.setDorms(getBundle().getInt(TrainingCenterData.DORMS));
        model.setBuildingData((BuildingData) building.getModel());
    }

    @Override
    public void resetModel() {
        model = new TrainingCenterData();
    }
}
