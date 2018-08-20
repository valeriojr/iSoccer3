package Data.PersonalData.Views;


import Data.Bundle;
import Data.Controller;
import Data.PersonalData.PersonalData;
import Data.View;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PersonalDataViewEdit extends View {
    private JTextField name, id, birthdate;

    public PersonalDataViewEdit(Controller controller){
        super(controller);
        initialize();
    }

    @Override
    protected void initialize() {
        super.initialize();

        JPanel p = new JPanel();

        mainPanel.setLayout(new GridLayout(0, 1));

        name = new JTextField(30);
        id = new JTextField(11);
        birthdate = new JTextField(10);

        name.setBorder( BorderFactory.createTitledBorder("Nome completo"));
        id.setBorder(BorderFactory.createTitledBorder("CPF"));
        birthdate.setBorder(BorderFactory.createTitledBorder("Data de nascimento"));

        p.setLayout(new GridLayout(0,2));
        p.add(id);
        p.add(birthdate);

        mainPanel.add(name);
        mainPanel.add(p);
    }

    @Override
    public void update() {
        Bundle bundle = controller.getBundle();

        bundle.put(PersonalData.NAME, name.getText());
        bundle.put(PersonalData.ID, id.getText());
        try {
            bundle.put(PersonalData.BIRTHDATE, new SimpleDateFormat("dd/MM/yyyy").parse(birthdate.getText()));
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(mainPanel, "Data inválida");
        }
    }

    @Override
    public void clear() {
        name.setText("");
        id.setText("");
        birthdate.setText("");
    }

    public String getName(){
        return name.getText();
    }

    public String getId(){
        return id.getText();
    }

    public Date getBirthdate() throws ParseException {
        return new SimpleDateFormat("dd/MM/yy").parse(birthdate.getText());
    }
}
