package Data.ContactData.Views;

import Data.Bundle;
import Data.ContactData.ContactData;
import Data.Controller;
import Data.View;

import javax.swing.*;
import java.awt.*;

public class ContactDataViewShow extends View {
    private JLabel email, phone;

    public ContactDataViewShow(Controller controller){
        super(controller);
        initialize();
    }

    @Override
    protected void initialize() {
        super.initialize();

        mainPanel.setLayout(new GridLayout(1, 0));

        email = new JLabel(EMPTY_LABEL);
        phone = new JLabel(EMPTY_LABEL);

        email.setBorder(BorderFactory.createTitledBorder(ContactData.EMAIL));
        phone.setBorder(BorderFactory.createTitledBorder(ContactData.PHONE));

        mainPanel.add(email);
        mainPanel.add(phone);
    }

    @Override
    public void update() {
        Bundle bundle = controller.getBundle();

        setEmail(bundle.getString(ContactData.EMAIL));
        setPhone(bundle.getString(ContactData.PHONE));
    }

    @Override
    protected void clear() {

    }

    private void setEmail(String email){
        this.email.setText(email);
    }

    private void setPhone(String phone){
        this.phone.setText(phone);
    }
}
