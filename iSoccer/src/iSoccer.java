import Data.PersonalData.PersonalData;
import Data.Resources.Buildings.StadiumData.StadiumData;
import Data.Resources.Buildings.StadiumData.StadiumDataController;
import Data.Resources.Buildings.TrainingCenterData.TrainingCenterData;
import Data.Resources.Buildings.TrainingCenterData.TrainingCenterDataController;
import Data.Resources.VehicleData.VehicleData;
import Data.Resources.VehicleData.VehicleDataController;
import MVC.Controller;
import Reports.*;
import UserTypes.Employee.Employee;
import UserTypes.Employee.EmployeeController;
import UserTypes.Supporter.Supporter;
import UserTypes.Supporter.SupporterController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class iSoccer {
    private static JFrame frame;
    private static Map<String, Employee> employees;
    private static Map<String, Supporter> supporters;
    private static List<VehicleData> vehicles;
    private static List<StadiumData> stadiums;
    private static List<TrainingCenterData> trainingCenters;
    private static JComboBox<String> actionSelect;

    public static void main(String args[]) {
        initializeFrame();
        employees = new TreeMap<>();
        supporters = new TreeMap<>();
        vehicles = new ArrayList<>();
        stadiums = new ArrayList<>();
        trainingCenters = new ArrayList<>();

        final Controller[] controller = {new SupporterController()};

        JPanel info = new JPanel();
        JPanel buttons = new JPanel();
        JButton add = new JButton("Adicionar"), showReport = new JButton("Relatório");

        actionSelect = new JComboBox<>(new String[]{"Funcionário", "Sócio Torcedor", "Veículo", "Estádio",
                "Centro de Treinamento"});
        actionSelect.setSelectedIndex(-1);
        actionSelect.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                add.setEnabled(true);
                showReport.setEnabled(true);
                switch (((String) itemEvent.getItem())){
                    case "Funcionário":
                        controller[0] = new EmployeeController();
                        break;
                    case "Sócio Torcedor":
                        controller[0] = new SupporterController();
                        break;
                    case "Veículo":
                        controller[0] = new VehicleDataController();
                        break;
                    case "Estádio":
                        controller[0] = new StadiumDataController();
                        break;
                    case "Centro de Treinamento":
                        controller[0] = new TrainingCenterDataController();
                        break;
                }

                info.removeAll();
                info.add(controller[0].getView().getMainPanel());
                frame.pack();
                frame.revalidate();
                frame.repaint();
            }
        });

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Controller c = controller[0];
                c.updateModel();
                switch(actionSelect.getSelectedIndex()){
                    case 0:
                        employees.put(((Employee) c.getModel()).getPersonalData().getId(), (Employee) c.getModel());
                        break;
                    case 1:
                        supporters.put(((Supporter) c.getModel()).getPersonalData().getId(), (Supporter) c.getModel());
                        break;
                    case 2:
                        vehicles.add((VehicleData) c.getModel());
                        break;
                    case 3:
                        stadiums.add((StadiumData) c.getModel());
                        break;
                    case 4:
                        trainingCenters.add((TrainingCenterData) c.getModel());
                        break;
                }
                controller[0].clearView();
                controller[0].resetModel();
            }
        });

        showReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JDialog dialog = new JDialog();
                switch(actionSelect.getSelectedIndex()){
                    case 0:
                        dialog.add(new EmployeeReport(new ArrayList<>(employees.values())).panel);
                        break;
                    case 1:
                        dialog.add(new SupporterReport(new ArrayList<>(supporters.values())).panel);
                        break;
                    case 2:
                        dialog.add(new VehicleReport(vehicles).panel);
                        break;
                    case 3:
                        dialog.add(new StadiumReport(stadiums).panel);
                        break;
                    case 4:
                        dialog.add(new TrainingCenterReport(trainingCenters).panel);
                        break;
                }
                dialog.pack();
                dialog.setModal(true);
                dialog.setVisible(true);
            }
        });

        add.setEnabled(false);
        showReport.setEnabled(false);

        buttons.add(actionSelect);
        buttons.add(add);
        buttons.add(showReport);

        frame.getContentPane().add(info, BorderLayout.CENTER);
        frame.getContentPane().add(buttons, BorderLayout.SOUTH);
        frame.pack();
        frame.revalidate();
        frame.repaint();
    }

    private static void initializeFrame(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
