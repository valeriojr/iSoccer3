package Reports;

import Data.PersonalData.PersonalData;
import Data.SupportData.SupportData;
import UserTypes.Supporter.Supporter;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.List;

public class SupporterReport {
    public JPanel panel;

    public SupporterReport(List<Supporter> list){
        panel = new JPanel();
        JTable table = new JTable();

        String columnNames[] = {PersonalData.NAME, PersonalData.ID, PersonalData.BIRTHDATE, SupportData.TYPE,
                "Mensalidade", "Adimplente"};

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
                        return list.get(i).getSupportData().getType();
                    case 4:
                        return list.get(i).getSupportData().getPricing();
                    case 5:
                        return list.get(i).getSupportData().getSituation();
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
                    case 5:
                        return Boolean.class;
                    default:
                        return null;
                }
            }

            @Override
            public void setValueAt(Object o, int i, int i1) {
                if(i1 == 5){
                    list.get(i).getSupportData().setSituation((Boolean) o);
                }
            }

            @Override
            public String getColumnName(int i) {
                return columnNames[i];
            }

            @Override
            public boolean isCellEditable(int i, int i1) {
                return i1 == 5;
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);

        JPanel info = new JPanel();

        info.add(new JLabel("Quantidade total: " + list.size()));

        int defaulterCount = 0;

        for(Supporter s : list){
            if(s.getSupportData().getSituation()){
                defaulterCount++;
            }
        }

        info.add(new JLabel("Adimplentes: " + defaulterCount));
        info.add(new JLabel("Inadimplentes: " + (list.size() - defaulterCount)));

        panel.setLayout(new BorderLayout());

        panel.add(info, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
    }
}
