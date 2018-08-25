package Reports;

import Data.Resources.Buildings.TrainingCenterData.TrainingCenterData;
import Data.Resources.VehicleData.VehicleData;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.List;

public class TrainingCenterReport {
    public JPanel panel;

    public TrainingCenterReport(List<TrainingCenterData> list){
        panel = new JPanel();
        JTable table = new JTable();

        String columnNames[] = {TrainingCenterData.NAME, TrainingCenterData.ADDRESS, TrainingCenterData.DORMS};

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
                        return list.get(i).getName();
                    case 1:
                        return list.get(i).getAddress().toString();
                    case 2:
                        return  list.get(i).getDorms();
                }

                return null;
            }

            @Override
            public Class<?> getColumnClass(int i) {
                if(i == 2){
                    return Integer.class;
                }

                return String.class;
            }

            @Override
            public String getColumnName(int i) {
                return columnNames[i];
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);

        panel.setLayout(new BorderLayout());

        panel.add(scrollPane, BorderLayout.CENTER);
    }
}
