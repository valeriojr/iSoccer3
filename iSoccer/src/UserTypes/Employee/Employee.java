package UserTypes.Employee;

import Data.EmployeeData.EmployeeData;
import Data.SupportData.SupportData;
import UserTypes.Person.Person;

public class Employee extends Person {
    private EmployeeData employeeData;

    public Employee(){
        this.employeeData = null;
    }

    @Override
    public String toString() {
        return super.toString() + employeeData.toString();
    }

    public void setEmployeeData(EmployeeData employeeData) {
        this.employeeData = employeeData;
    }

    public void setPerson(Person model) {
        setPersonalData(model.getPersonalData());
        setAddressData(model.getAddressData());
        setContactData(model.getContactData());
    }

    public EmployeeData getEmployeeData() {
        return employeeData;
    }
}
