package Data.PersonalData;

import MVC.Controller;
import MVC.Model;
import Data.PersonalData.Views.PersonalDataViewEdit;

public class PersonalDataController extends Controller {

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

    @Override
    public void resetModel() {
        model = new PersonalData();
        view.clear();
    }
}
