import Data.Controller;
import Data.SupportData.SupportData;
import UserTypes.Person.PersonController;
import UserTypes.Supporter.Supporter;
import UserTypes.Supporter.SupporterController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class iSoccer {
    static JFrame frame;

    public static void main(String args[]) {
        initializeFrame();

        Controller controller = new SupporterController(new Supporter());

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                controller.updateModel();
                System.out.print(controller.getModel());
            }
        });

        frame.getContentPane().add(controller.getView().getMainPanel());

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
}
