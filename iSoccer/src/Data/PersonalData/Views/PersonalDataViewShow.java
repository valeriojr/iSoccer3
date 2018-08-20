package Data.PersonalData.Views;

import Data.Bundle;
import Data.Controller;
import Data.PersonalData.PersonalData;
import Data.PersonalData.PersonalDataController;
import Data.View;
import Person.Person;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PersonalDataViewShow extends View{
    private JLabel name, id, birthdate;

    public PersonalDataViewShow(Controller controller){
        super(controller);
        initialize();
    }

    @Override
    protected void initialize() {
        super.initialize();
        JPanel p = new JPanel();

        mainPanel.setLayout(new GridLayout(2, 0));

        name = new JLabel(EMPTY_LABEL);
        id = new JLabel(EMPTY_LABEL);
        birthdate = new JLabel(EMPTY_LABEL);

        name.setBorder(BorderFactory.createTitledBorder("Nome completo"));
        id.setBorder(BorderFactory.createTitledBorder("CPF"));
        birthdate.setBorder(BorderFactory.createTitledBorder("Data de nascimento"));

        p.setLayout(new GridLayout(1,2));
        p.add(id);
        p.add(birthdate);

        mainPanel.add(name);
        mainPanel.add(p);
    }

    @Override
    public void update() {
        Bundle bundle = controller.getBundle();

        setName(bundle.getString(PersonalData.NAME));
        setId(bundle.getString(PersonalData.ID));
        setBirthdate(bundle.getDate(PersonalData.BIRTHDATE));
    }

    @Override
    public void clear() {
        name.setText(EMPTY_LABEL);
        id.setText(EMPTY_LABEL);
        birthdate.setText(EMPTY_LABEL);
    }

    private void setName(String name){
        this.name.setText(name != null ? name : "");
    }

    private void setId(String id){
        this.id.setText(id != null ? id : "");
    }

    private void setBirthdate(Date birthdate){
        this.birthdate.setText(birthdate  != null ? new SimpleDateFormat("dd/MM/yyyy").format(birthdate) : "");
    }
}
