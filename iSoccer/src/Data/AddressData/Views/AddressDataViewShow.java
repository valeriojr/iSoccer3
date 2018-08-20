package Data.AddressData.Views;

import Data.AddressData.AddressData;
import Data.Bundle;
import Data.Controller;
import Data.View;

import javax.swing.*;
import java.awt.*;

public class AddressDataViewShow extends View {
    private JLabel address, city, state, country;

    public AddressDataViewShow(Controller controller) {
        super(controller);
        initialize();
    }

    @Override
    protected void initialize() {
        super.initialize();

        JPanel auxiliarPanel = new JPanel();

        mainPanel.setLayout(new GridLayout(0, 1));
        auxiliarPanel.setLayout(new GridLayout(0, 3));

        address = new JLabel(EMPTY_LABEL);
        city = new JLabel(EMPTY_LABEL);
        state = new JLabel(EMPTY_LABEL);
        country = new JLabel(EMPTY_LABEL);

        address.setBorder(BorderFactory.createTitledBorder(AddressData.ADDRESS));
        city.setBorder(BorderFactory.createTitledBorder(AddressData.CITY));
        state.setBorder(BorderFactory.createTitledBorder(AddressData.STATE));
        country.setBorder(BorderFactory.createTitledBorder(AddressData.COUNTRY));

        auxiliarPanel.add(city);
        auxiliarPanel.add(state);
        auxiliarPanel.add(country);

        mainPanel.add(address);
        mainPanel.add(auxiliarPanel);
    }

    @Override
    public void update() {
        Bundle bundle = controller.getBundle();

        address.setText(bundle.getString(AddressData.ADDRESS));
        city.setText(bundle.getString(AddressData.CITY));
        state.setText(bundle.getString(AddressData.STATE));
        country.setText(bundle.getString(AddressData.COUNTRY));
    }

    @Override
    public void clear() {
        address.setText("");
        city.setText("");
        state.setText("");
        country.setText("");
    }
}
