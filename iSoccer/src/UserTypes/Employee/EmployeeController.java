package UserTypes.Employee;

import Data.EmployeeData.EmployeeData;
import Data.EmployeeData.EmployeeDataController;
import MVC.Controller;
import UserTypes.Employee.Employee;
import UserTypes.Person.Person;
import UserTypes.Person.PersonController;
import UserTypes.Supporter.Supporter;

import javax.swing.*;

public class EmployeeController extends Controller {
    private Controller person, employee;

    public EmployeeController() {
        super(new Employee());

        person = new PersonController();
        employee = new EmployeeDataController();

        setupView();
    }

    void setupView(){
        JPanel panel = view.getMainPanel();

        panel.add(person.getView().getMainPanel());
        panel.add(employee.getView().getMainPanel());
    }

    @Override
    public void clearView() {
        person.getView().clear();
        employee.getView().clear();
    }

    @Override
    public void resetModel() {
        model = new Employee();
        person.resetModel();
        employee.resetModel();
    }

    @Override
    public void updateModel() {
        person.updateView();
        employee.updateView();

        person.updateModel();
        employee.updateModel();

        Employee model = (Employee) getModel();

        model.setPerson((Person) person.getModel());
        model.setEmployeeData((EmployeeData) employee.getModel());
    }
}
