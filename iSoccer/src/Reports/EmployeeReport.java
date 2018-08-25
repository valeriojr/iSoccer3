package Reports;

import Data.EmployeeData.EmployeeData;
import Data.PersonalData.PersonalData;
import Data.SupportData.SupportData;
import UserTypes.Employee.Employee;
import UserTypes.Supporter.Supporter;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.List;

public class EmployeeReport {
    public JPanel panel;

    public EmployeeReport(List<Employee> list){
        panel = new JPanel();
        JTable table = new JTable();

        String columnNames[] = {PersonalData.NAME, PersonalData.ID, PersonalData.BIRTHDATE, EmployeeData.JOB,
                EmployeeData.SALARY};

        table.setModel(new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return list.size();
            }

            @Override
            public int getColumnCount() {
                return columnNames.length;
            }

            @Override
            public Object getValueAt(int i, int i1) {
                switch (i1){
                    case 0:
                        return list.get(i).getPersonalData().getName();
                    case 1:
                        return list.get(i).getPersonalData().getId();
                    case 2:
                        return new SimpleDateFormat("dd/MM/yyyy").format(list.get(i).getPersonalData().getBirthdate());
                    case 3:
                        return list.get(i).getEmployeeData().getType();
                    case 4:
                        return list.get(i).getEmployeeData().getSalary();
                }

                return null;
            }

            @Override
            public Class<?> getColumnClass(int i) {
                switch (i){
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return String.class;
                    case 4:
                        return Double.class;
                    default:
                        return null;
                }
            }

            @Override
            public String getColumnName(int i) {
                return columnNames[i];
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane, BorderLayout.CENTER);
    }
}
