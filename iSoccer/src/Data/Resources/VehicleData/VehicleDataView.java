package Data.Resources.VehicleData;

import MVC.Controller;
import MVC.View;
import Util.Bundle;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class VehicleDataView extends View {

    private JTextField id;
    private JComboBox<VehicleData.Type> typeSelection;

    public VehicleDataView(Controller controller) {
        super(controller);
        initialize();
    }

    @Override
    protected void initialize() {
        super.initialize();

        id = new JTextField();
        typeSelection = new JComboBox<>(VehicleData.Type.values());

        id.setBorder(BorderFactory.createTitledBorder(VehicleData.ID));
        typeSelection.setBorder(BorderFactory.createTitledBorder(VehicleData.TYPE));

        mainPanel.add(id);
        mainPanel.add(typeSelection);
    }

    @Override
    public void update() {
        Bundle bundle = controller.getBundle();

        bundle.put(VehicleData.ID, id.getText());
        bundle.put(VehicleData.TYPE, typeSelection.getSelectedItem());
    }

    @Override
    public void clear() {
        id.setText("");
        typeSelection.setSelectedIndex(0);
    }
}
