package Data.Resources.Buildings;

import Data.Resources.Buildings.StadiumData.StadiumData;
import MVC.Controller;
import MVC.View;
import Util.Bundle;

import javax.swing.*;

public class BuildingDataView extends View {
    public static final String NAME = "Nome";

    private JTextField name;

    public BuildingDataView(Controller controller) {
        super(controller);
        initialize();
    }

    @Override
    protected void initialize() {
        super.initialize();

        name = new JTextField();
        name.setBorder(BorderFactory.createTitledBorder(NAME));

        mainPanel.add(name);
    }

    @Override
    public void update() {
        Bundle bundle = controller.getBundle();

        bundle.put(StadiumData.NAME, name.getText());
    }

    @Override
    public void clear() {

    }
}
