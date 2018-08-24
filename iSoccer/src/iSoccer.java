import Data.Resources.Buildings.StadiumData.StadiumDataController;
import MVC.Controller;
import MVC.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class iSoccer {
    static JFrame frame;

    public static void main(String args[]) {
        initializeFrame();

        View view;
        Controller controller;

        controller = new StadiumDataController();

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                controller.updateModel();
                System.out.println(controller.getModel());
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
