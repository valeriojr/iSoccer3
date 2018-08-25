package UserTypes.Person;

import Data.AddressData.AddressData;
import Data.ContactData.ContactData;
import Data.PersonalData.PersonalData;
import MVC.Model;

public class Person implements Model{
    private PersonalData personalData;
    private AddressData addressData;
    private ContactData contactData;

    public Person(PersonalData personalData, AddressData addressData, ContactData contactData){
        this.personalData = personalData;
        this.addressData = addressData;
        this.contactData = contactData;
    }

    public Person() {
        this.personalData = null;
        this.addressData = null;
        this.contactData = null;
    }

    @Override
    public String toString() {
        return personalData.toString() + addressData.toString() + contactData.toString();
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    public void setAddressData(AddressData addressData) {
        this.addressData = addressData;
    }

    public void setContactData(ContactData contactData) {
        this.contactData = contactData;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public AddressData getAddressData(){
        return addressData;
    }

    public ContactData getContactData(){
        return contactData;
    }
}
