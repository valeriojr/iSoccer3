package Data.ContactData;

import Data.Model;

public class ContactData extends Model {
    public static final String EMAIL = "Endereço de e-mail", PHONE = "Número de telefone";

    private String email, phone;

    public ContactData(){
        this.email = null;
        this.phone = null;
    }

    @Override
    public String toString() {
        return String.format("%s: %s\n%s: %s\n", EMAIL, email, PHONE, phone);
    }

    void setEmail(String email){
        this.email = email;
    }

    String getEmail(){
        return email;
    }

    void setPhone(String phone){
        this.phone = phone;
    }

    String getPhone() {
        return phone;
    }
}
