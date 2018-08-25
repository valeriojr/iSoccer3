package Data.EmployeeData;

import MVC.Controller;

public class EmployeeDataController extends Controller {

    public EmployeeDataController() {
        super(new EmployeeData());
        setView(new EmployeeDataView(this));
    }

    @Override
    public void updateModel() {
        EmployeeData model = (EmployeeData) getModel();

        model.setSalary(bundle.getDouble(EmployeeData.SALARY));
        model.setType(((EmployeeData.Type) bundle.getObject(EmployeeData.JOB)));
    }

    @Override
    public void resetModel() {
        model = new EmployeeData();
    }
}
