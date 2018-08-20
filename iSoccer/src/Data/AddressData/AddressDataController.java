package Data.AddressData;

import Data.Controller;

public class AddressDataController extends Controller {

    public AddressDataController(AddressData model){
        super(model);
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
