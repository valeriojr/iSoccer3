package Data.Resources.Buildings.StadiumData;

import MVC.Controller;
import MVC.View;
import Util.Bundle;

import javax.swing.*;

public class StadiumDataView extends View {
    private JTextField capacity, bathrooms, snackBars;

    public StadiumDataView(Controller controller) {
        super(controller);
        initialize();
    }

    @Override
    protected void initialize() {
        super.initialize();

        capacity = new JTextField();
        bathrooms = new JTextField();
        snackBars = new JTextField();

        capacity.setBorder(BorderFactory.createTitledBorder(StadiumData.CAPACITY));
        bathrooms.setBorder(BorderFactory.createTitledBorder(StadiumData.BATHROOMS));
        snackBars.setBorder(BorderFactory.createTitledBorder(StadiumData.SNACK_BARS));

        mainPanel.add(capacity);
        mainPanel.add(bathrooms);
        mainPanel.add(snackBars);
    }

    @Override
    public void update() {
        Bundle bundle = controller.getBundle();

        bundle.put(StadiumData.CAPACITY, Integer.valueOf(capacity.getText()));
        bundle.put(StadiumData.BATHROOMS, Integer.valueOf(bathrooms.getText()));
        bundle.put(StadiumData.SNACK_BARS, Integer.valueOf(snackBars.getText()));
    }

    @Override
    public void clear() {
        capacity.setText("");
        bathrooms.setText("");
        snackBars.setText("");
    }
}
