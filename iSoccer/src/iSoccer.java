import Login.*;
import MVC.Controller;
import MVC.Model;
import MVC.View;
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

        Model model;
        View view;
        Controller controller;

        model = new Login("username", "123456");
        controller = new LoginController(model);
        view = new LoginView(controller);
        controller.setView(view);

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
