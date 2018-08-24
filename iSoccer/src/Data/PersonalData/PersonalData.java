package Data.PersonalData;

import MVC.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PersonalData implements Model {
    public static final String NAME = "Nome", ID = "CPF", BIRTHDATE = "Data de nascimento"; 
    
    private String name, id;
    private Date birthdate;

    public PersonalData(){
        this.name = null;
        this.id = null;
        this.birthdate = null;
    }

    public PersonalData(String name, String id, Date birthdate){
        this.name = name;
        this.id = id;
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        String birthdateFormatted = new SimpleDateFormat("dd/MM/yyyy").format(birthdate);
        return String.format("%s: %s\n%s: %s\n%s: %s\n", NAME, name, ID, id, BIRTHDATE, birthdateFormatted);
    }

    void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public Date getBirthdate(){
        return birthdate;
    }

    void setBirthdate(Date birthdate){
        this.birthdate = birthdate;
    }

}
