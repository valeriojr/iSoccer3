package Data.PersonalData;

import Data.AddressData.AddressData;
import Data.Controller;
import Data.Model;
import Data.PersonalData.Views.PersonalDataViewEdit;
import Data.PersonalData.Views.PersonalDataViewShow;
import Data.View;
import Person.Person;

import javax.swing.*;
import java.text.ParseException;

public class PersonalDataController extends Controller {

    public PersonalDataController(Model model) {
        super(model);
    }

    @Override
    public void updateModel() {
        PersonalData model = (PersonalData) getModel();

        model.setName(bundle.getString(PersonalData.NAME));
        model.setId(bundle.getString(PersonalData.ID));
        model.setBirthdate(bundle.getDate(PersonalData.BIRTHDATE));

        JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
    }
}
