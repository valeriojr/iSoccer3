import Data.AddressData.AddressData;
import Data.AddressData.AddressDataController;
import Data.AddressData.Views.AddressDataViewEdit;
import Data.AddressData.Views.AddressDataViewShow;
import Data.ContactData.ContactData;
import Data.ContactData.ContactDataController;
import Data.ContactData.Views.ContactDataViewEdit;
import Data.ContactData.Views.ContactDataViewShow;
import Data.Controller;
import Data.PersonalData.PersonalData;
import Data.PersonalData.PersonalDataController;
import Data.PersonalData.Views.PersonalDataViewEdit;
import Data.PersonalData.Views.PersonalDataViewShow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class iSoccer {
    static JFrame frame;

    public static void main(String args[]){
        initializeFrame();

        Controller personalController = personalTest();
        Controller addressController = addressTest();
        Controller contactController = contactTest();

        JButton updateButton = new JButton("Update");

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                personalController.updateView("Edit");
                personalController.updateModel();
                System.out.println(personalController.getModel());
                personalController.updateView("Show");

                addressController.updateView("Show");
                addressController.updateView("Edit");
                addressController.updateModel();
                System.out.println(addressController.getModel());
                addressController.updateView("Show");

                contactController.updateView("Edit");
                contactController.updateModel();
                System.out.println(contactController.getModel());
                contactController.updateView("Show");
            }
        });

        JPanel buttons = new JPanel();
        buttons.add(updateButton);

        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));

        frame.getContentPane().add(personalController.getView("Edit").getMainPanel(), BorderLayout.NORTH);
        frame.getContentPane().add(personalController.getView("Show").getMainPanel(), BorderLayout.CENTER);
        frame.getContentPane().add(addressController.getView("Edit").getMainPanel(), BorderLayout.NORTH);
        frame.getContentPane().add(addressController.getView("Show").getMainPanel(), BorderLayout.CENTER);
        frame.getContentPane().add(contactController.getView("Edit").getMainPanel(), BorderLayout.NORTH);
        frame.getContentPane().add(contactController.getView("Show").getMainPanel(), BorderLayout.CENTER);
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

    private static Controller addressTest(){
        Controller controller = new AddressDataController(new AddressData());
        controller.addView("Edit", new AddressDataViewEdit(controller));
        controller.addView("Show", new AddressDataViewShow(controller));

        return controller;
    }

    private static Controller personalTest(){
        Controller controller = new PersonalDataController(new PersonalData());
        controller.addView("Edit", new PersonalDataViewEdit(controller));
        controller.addView("Show", new PersonalDataViewShow(controller));

        return controller;
    }

    private static Controller contactTest(){
        Controller controller = new ContactDataController(new ContactData());
        controller.addView("Edit", new ContactDataViewEdit(controller));
        controller.addView("Show", new ContactDataViewShow(controller));

        return controller;
    }
}
