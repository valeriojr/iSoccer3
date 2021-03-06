package Login;

import MVC.Controller;
import MVC.Model;
import MVC.View;

public class LoginController extends Controller {

    public LoginController(Model model, View view) {
        super(model, view);
    }

    public LoginController() {
        super(new Login());
        setView(new LoginView(this));
    }

    @Override
    public void updateModel() {
        Login model = (Login) getModel();

        updateView();

        model.setUsername(bundle.getString(Login.USERNAME));
        model.setPassword(bundle.getString(Login.PASSWORD));
    }

    @Override
    public void resetModel() {
        model = new Login();
    }


}
