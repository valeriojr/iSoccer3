package UserTypes.Person;

import Data.AddressData.AddressData;
import Data.AddressData.AddressDataController;
import Data.ContactData.ContactData;
import Data.ContactData.ContactDataController;
import Data.Controller;
import Data.Model;
import Data.PersonalData.PersonalData;
import Data.PersonalData.PersonalDataController;

import javax.swing.*;

/**
 * Created by alunoic on 20/08/18.
 */
public class PersonController extends Controller{
    private Controller personal, address, contact;


    public PersonController(Model model, Controller personal, Controller address, Controller contact) {
        super(model);

        this.personal = personal;
        this.address = address;
        this.contact = contact;
    }

    public PersonController() {
        super(new Person());

        personal = new PersonalDataController();
        address = new AddressDataController();
        contact = new ContactDataController();

        setupView();
    }

    public void setupView(){

        JPanel panel = view.getMainPanel();

        panel.setLayout(new BoxLayout(view.getMainPanel(), BoxLayout.PAGE_AXIS));
        panel.add(personal.getView().getMainPanel());
        panel.add(address.getView().getMainPanel());
        panel.add(contact.getView().getMainPanel());
    }

    @Override
    public void updateModel() {
        personal.getView().update();
        address.getView().update();
        contact.getView().update();

        personal.updateModel();
        address.updateModel();
        contact.updateModel();

        Person model = (Person) getModel();

        if(model == null){
            model = new Person(null, null, null);
        }

        model.setPersonalData((PersonalData) personal.getModel());
        model.setAddressData((AddressData) address.getModel());
        model.setContactData((ContactData) contact.getModel());
    }
}
