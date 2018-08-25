package Reports;

import Data.Resources.Buildings.StadiumData.StadiumData;
import Data.Resources.VehicleData.VehicleData;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.List;

public class StadiumReport {
    public JPanel panel;

    public StadiumReport(List<StadiumData> list){
        panel = new JPanel();
        JTable table = new JTable();

        String columnNames[] = {StadiumData.NAME, StadiumData.ADDRESS, StadiumData.CAPACITY, StadiumData.BATHROOMS,
            StadiumData.SNACK_BARS};

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
                        return list.get(i).getCapacity();
                    case 3:
                        return list.get(i).getBathrooms();
                    case 4:
                        return list.get(i).getSnackBars();
                }

                return null;
            }

            @Override
            public Class<?> getColumnClass(int i) {
                if(i <= 1){
                    return String.class;
                }

                return Integer.class;
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
