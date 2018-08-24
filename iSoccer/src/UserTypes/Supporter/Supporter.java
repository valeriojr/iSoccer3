package UserTypes.Supporter;

import Data.SupportData.SupportData;
import UserTypes.Person.Person;

public class Supporter extends Person {
    SupportData supportData;

    public Supporter(){
        super();
        supportData = new SupportData();
    }

    public void setPerson(Person model) {
        setPersonalData(model.getPersonalData());
        setAddressData(model.getAddressData());
        setContactData(model.getContactData());
    }

    public SupportData getSupportData() {
        return supportData;
    }

    @Override
    public String toString() {
        return super.toString() + supportData.toString();
    }

    public void setSupportData(SupportData model) {
        supportData = model;
    }
}
