package Login;

import MVC.Controller;
import MVC.View;
import Util.Bundle;

import javax.swing.*;

public class LoginView extends View {
    private JTextField username, password;

    public LoginView(Controller controller) {
        super(controller);
    }

    @Override
    protected void initialize() {
        super.initialize();

        password = new JTextField();
        username = new JTextField();

        username.setBorder(BorderFactory.createTitledBorder(Login.USERNAME));
        password.setBorder(BorderFactory.createTitledBorder(Login.PASSWORD));

        mainPanel.add(username);
        mainPanel.add(password);
    }

    @Override
    public void update() {
        Bundle bundle = controller.getBundle();

        bundle.put(Login.USERNAME, username.getText());
        bundle.put(Login.PASSWORD, password.getText());
    }

    @Override
    public void clear() {
        username.setText("");
        password.setText("");
    }
}
