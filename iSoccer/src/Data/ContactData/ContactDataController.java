package Data.ContactData;

import Data.Bundle;
import Data.ContactData.Views.ContactDataViewEdit;
import Data.Controller;
import Data.Model;

public class ContactDataController extends Controller {

    public ContactDataController(Model model) {
        super(model);
    }

    @Override
    public void updateModel() {
        ContactData model = (ContactData) getModel();

        model.setEmail(bundle.getString(ContactData.EMAIL));
        model.setPhone(bundle.getString(ContactData.PHONE));

        System.out.println(model.getEmail() + model.getPhone());
    }
}