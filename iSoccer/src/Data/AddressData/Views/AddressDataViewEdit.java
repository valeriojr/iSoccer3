package Data.AddressData.Views;

import Data.AddressData.AddressData;
import Data.Bundle;
import Data.Controller;
import Data.View;

import javax.swing.*;
import java.awt.*;

public class AddressDataViewEdit extends View {
    private JTextField address, city, state, country;

    public AddressDataViewEdit(Controller controller) {
        super(controller);
        initialize();
    }

    @Override
    protected void initialize() {
        super.initialize();

        JPanel auxiliarPanel = new JPanel();

        mainPanel.setLayout(new GridLayout(0, 1));
        auxiliarPanel.setLayout(new GridLayout(0, 3));

        address = new JTextField(30);
        city = new JTextField();
        state = new JTextField();
        country = new JTextField();

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

        bundle.put(AddressData.ADDRESS, address.getText());
        bundle.put(AddressData.CITY, city.getText());
        bundle.put(AddressData.STATE, state.getText());
        bundle.put(AddressData.COUNTRY, country.getText());
    }

    @Override
    protected void clear() {

    }
}
