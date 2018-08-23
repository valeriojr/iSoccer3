package Data.SupportData;

import Data.Controller;
import Data.Model;
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
        SupportData model = (SupportData) getModel();

        SupportData.Type type = (SupportData.Type) getBundle().getObject(SupportData.TYPE);

        if(type != null){
            model.setType(type);
            System.out.println("aqui");
        }
    }
}
