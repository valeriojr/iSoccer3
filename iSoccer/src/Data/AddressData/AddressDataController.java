package Data.AddressData;

import Data.AddressData.Views.AddressDataViewEdit;
import MVC.Controller;

public class AddressDataController extends Controller {

    public AddressDataController(AddressData model){
        super(model);
    }

    public AddressDataController() {
        super(new AddressData());
        setView(new AddressDataViewEdit(this));
    }

    @Override
    public void updateModel() {
        AddressData model = (AddressData) getModel();

        model.setAddress(bundle.getString(AddressData.ADDRESS));
        model.setCity(bundle.getString(AddressData.CITY));
        model.setState(bundle.getString(AddressData.STATE));
        model.setCountry(bundle.getString(AddressData.COUNTRY));
    }
}
