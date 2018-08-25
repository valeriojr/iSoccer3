package Data.SupportData;

import MVC.Controller;
import MVC.Model;
import Data.SupportData.Views.SupportDataViewEdit;
import UserTypes.Supporter.Supporter;

public class SupportDataController extends Controller {

    public SupportDataController(Model model) {
        super(model);
    }

    public SupportDataController() {
        super(new SupportData());
        setView(new SupportDataViewEdit(this));
    }

    @Override
    public void updateModel() {
        ((SupportData) getModel()).setType((SupportData.Type) bundle.getObject(SupportData.TYPE));
    }

    @Override
    public void resetModel() {
        model = new SupportData();
    }
}
