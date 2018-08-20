package Data.ContactData.Views;

import Data.Bundle;
import Data.ContactData.ContactData;
import Data.Controller;
import Data.View;

import javax.swing.*;
import java.awt.*;

import static Data.ContactData.ContactData.EMAIL;

public class ContactDataViewEdit extends View {
    private JTextField email, phone;

    public ContactDataViewEdit(Controller controller){
        super(controller);
        initialize();
    }

    @Override
    protected void initialize() {
        super.initialize();

        mainPanel.setLayout(new GridLayout(1, 0));

        email = new JTextField();
        phone = new JTextField(20);

        email.setBorder(BorderFactory.createTitledBorder(ContactData.EMAIL));
        phone.setBorder(BorderFactory.createTitledBorder(ContactData.PHONE));

        mainPanel.add(email);
        mainPanel.add(phone);
    }

    @Override
    public void update() {
        Bundle bundle = controller.getBundle();

        bundle.put(ContactData.EMAIL, email.getText());
        bundle.put(ContactData.PHONE, phone.getText());
    }

    @Override
    protected void clear() {
        email.setText("");
        phone.setText("");
    }

    public String getEmail(){
        return email.getText();
    }
    public String getPhone(){
        return phone.getText();
    }
}
