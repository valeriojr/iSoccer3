package Data.PersonalData;

import Data.Controller;
import Data.Model;
import Data.PersonalData.Views.PersonalDataViewEdit;

import javax.swing.*;

public class PersonalDataController extends Controller {

    public PersonalDataController(Model model) {
        super(model);
    }

    public PersonalDataController() {
        super(new PersonalData());
        setView(new PersonalDataViewEdit(this));
    }

    @Override
    public void updateModel() {
        PersonalData model = (PersonalData) getModel();

        model.setName(bundle.getString(PersonalData.NAME));
        model.setId(bundle.getString(PersonalData.ID));
        model.setBirthdate(bundle.getDate(PersonalData.BIRTHDATE));
    }
}
