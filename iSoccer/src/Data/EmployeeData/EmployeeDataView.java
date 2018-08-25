package Data.EmployeeData;

import MVC.View;
import Util.Bundle;

import javax.swing.*;

public class EmployeeDataView extends View {
    private JTextField salary;
    private JComboBox<EmployeeData.Type> type;

    public EmployeeDataView(EmployeeDataController employeeDataController) {
        super(employeeDataController);
        initialize();
    }

    @Override
    protected void initialize() {
        super.initialize();

        salary = new JTextField();
        type = new JComboBox<>(EmployeeData.Type.values());

        salary.setBorder(BorderFactory.createTitledBorder(EmployeeData.SALARY));
        type.setBorder(BorderFactory.createTitledBorder(EmployeeData.JOB));

        mainPanel.add(salary);
        mainPanel.add(type);
    }

    @Override
    public void update() {
        Bundle bundle = controller.getBundle();

        bundle.put(EmployeeData.SALARY, Double.parseDouble(salary.getText()));
        bundle.put(EmployeeData.JOB, type.getSelectedItem());
    }

    @Override
    public void clear() {
        salary.setText("");
        type.setSelectedIndex(0);
    }
}
