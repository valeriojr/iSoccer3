package Person;

import Data.AddressData.AddressData;
import Data.AddressData.AddressDataController;
import Data.AddressData.Views.AddressDataViewEdit;
import Data.ContactData.ContactData;
import Data.ContactData.ContactDataController;
import Data.ContactData.Views.ContactDataViewEdit;
import Data.Controller;
import Data.Model;
import Data.PersonalData.PersonalData;
import Data.PersonalData.PersonalDataController;
import Data.PersonalData.Views.PersonalDataViewEdit;

import java.util.ArrayList;

/**
 * Created by alunoic on 20/08/18.
 */
public class PersonController extends Controller{
    ArrayList<Controller> controllers;

    public PersonController(Model model) {
        super(model);
        controllers = new ArrayList<Controller>();

        initializeControllers();

        for(int i = 0;i < controllers.size();i++){
            addView("view" + Integer.toString(i), controllers.get(i).getView("Edit"));
        }
    }

    private void initializeControllers() {
        PersonalDataController personalDataController = new PersonalDataController(new PersonalData());
        AddressDataController addressDataController = new AddressDataController(new AddressData());
        ContactDataController contactDataController = new ContactDataController(new ContactData());

        personalDataController.addView("Edit", new PersonalDataViewEdit(this));
        addressDataController.addView("Edit", new AddressDataViewEdit(this));
        contactDataController.addView("Edit", new ContactDataViewEdit(this));

        controllers.add(personalDataController);
        controllers.add(addressDataController);
        controllers.add(contactDataController);
    }

    @Override
    public void updateModel() {
        Person model = (Person) getModel();

        if(model == null){
            model = new Person(null, null, null);
        }

        model.setPersonalData((PersonalData) bundle.getObject(Person.PERSONAL_DATA));
        model.setAddressData((AddressData) bundle.getObject(Person.ADDRESS_DATA));
        model.setContactData((ContactData) bundle.getObject(Person.CONTACT_DATA));
    }
}
