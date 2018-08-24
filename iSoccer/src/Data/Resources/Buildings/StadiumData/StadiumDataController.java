package Data.Resources.Buildings.StadiumData;

import Data.Resources.Buildings.BuildingData;
import Data.Resources.Buildings.BuildingDataController;
import MVC.Controller;
import MVC.View;

import javax.swing.*;
import java.awt.*;

public class StadiumDataController extends Controller {
    private BuildingDataController building;
    private View stadiumView;

    public StadiumDataController() {
        super(new StadiumData());

        building = new BuildingDataController();
        stadiumView = new StadiumDataView(this);

        view.getMainPanel().add(building.getView().getMainPanel());
        view.getMainPanel().add(stadiumView.getMainPanel());
    }

    @Override
    public void updateModel() {
        building.updateView();
        stadiumView.update();

        building.updateModel();

        StadiumData stadium = (StadiumData) getModel();

        stadium.setBuildingData((BuildingData) building.getModel());
        stadium.setCapacity(bundle.getInt(StadiumData.CAPACITY));
        stadium.setBathrooms(bundle.getInt(StadiumData.BATHROOMS));
        stadium.setSnackBars(bundle.getInt(StadiumData.SNACK_BARS));
    }
}
