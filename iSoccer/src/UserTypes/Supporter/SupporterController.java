package UserTypes.Supporter;

import MVC.Controller;
import MVC.Model;
import Data.SupportData.SupportData;
import Data.SupportData.SupportDataController;
import UserTypes.Person.Person;
import UserTypes.Person.PersonController;

import javax.swing.*;

public class SupporterController extends Controller {
    private Controller person, supporter;

    public SupporterController(Model model) {
        super(model);

        person = new PersonController();
        supporter = new SupportDataController();

        setupView();
    }

    void setupView(){
        JPanel panel = view.getMainPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        panel.add(person.getView().getMainPanel());
        panel.add(supporter.getView().getMainPanel());
    }

    @Override
    public void updateModel() {
        person.getView().update();
        supporter.getView().update();

        person.updateModel();
        supporter.updateModel();

        Supporter model = (Supporter) getModel();

        model.setPerson((Person) person.getModel());
        model.setSupportData((SupportData) supporter.getModel());
    }
}
