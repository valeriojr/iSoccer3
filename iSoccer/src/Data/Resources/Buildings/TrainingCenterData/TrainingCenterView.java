package Data.Resources.Buildings.TrainingCenterData;

import MVC.Controller;
import MVC.View;
import Util.Bundle;

import javax.swing.*;

public class TrainingCenterView extends View {
    private JTextField dorms;

    TrainingCenterView(Controller controller) {
        super(controller);
        initialize();
    }

    @Override
    protected void initialize() {
        super.initialize();

        dorms = new JTextField();
        dorms.setBorder(BorderFactory.createTitledBorder(TrainingCenterData.DORMS));

        mainPanel.add(dorms);
    }

    @Override
    public void update() {
        Bundle bundle = controller.getBundle();

        bundle.put(TrainingCenterData.DORMS, Integer.valueOf(dorms.getText()));
    }

    @Override
    public void clear() {
        dorms.setText("");
    }
}
