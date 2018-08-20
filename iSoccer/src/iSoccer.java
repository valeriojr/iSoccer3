import Data.AddressData.*;
import Data.AddressData.Views.*;
import Data.ContactData.*;
import Data.ContactData.Views.*;
import Data.Controller;
import Data.Model;
import Data.PersonalData.*;
import Data.PersonalData.Views.*;
import Data.View;
import Person.Person;
import Person.PersonController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class iSoccer {
    static JFrame frame;

    public static void main(String args[]) {
        initializeFrame();

        PersonController personController = new PersonController(new Person(null, null, null));

        setView(personController);

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (View v : personController.getViews()) {
                    v.update();
                    personController.updateModel();
                    v.clear();
                }
                System.out.print(personController.getModel());
            }
        });

        frame.getContentPane().add(updateButton, BorderLayout.SOUTH);

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

    public static void setView(Controller controller){
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
        for(View v : controller.getViews()){
            frame.getContentPane().add(v.getMainPanel(), BorderLayout.NORTH);
        }
    }

}
