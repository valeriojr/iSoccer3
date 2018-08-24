package Data.SupportData;

import MVC.Controller;
import MVC.Model;
import Data.SupportData.Views.SupportDataViewEdit;

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
}
