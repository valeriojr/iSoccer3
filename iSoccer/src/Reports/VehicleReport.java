package Reports;

import Data.Resources.VehicleData.VehicleData;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.List;

public class VehicleReport {
    public JPanel panel;

    public VehicleReport(List<VehicleData> list){
        panel = new JPanel();
        JTable table = new JTable();

        String columnNames[] = {VehicleData.ID, VehicleData.TYPE};

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
                        return list.get(i).getId();
                    case 1:
                        return list.get(i).getType();
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

        panel.setLayout(new BorderLayout());

        panel.add(scrollPane, BorderLayout.CENTER);
    }
}
