package edu.miu.cs.cs489.quiz.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactUtil {
    private List<Contact> contacts = new ArrayList<>();
    Map<Long, Contact> contactMap = new HashMap<>();

    public boolean addContact(Contact contact) { // retruns false if a contact exists if it exists it will merge the
                                                 // contact else it will add the contact basically it will update the
                                                 // existing contact
        for (Contact savedContact : contacts) {
            if (savedContact.getFirstName().equals(contact.getFirstName())
                    && savedContact.getLastName().equals(contact.getLastName())) {
                savedContact.setCompany(contact.getCompany());
                savedContact.setJobTitle(contact.getJobTitle());
                savedContact.getPhoneNumbers().addAll(contact.getPhoneNumbers());
                savedContact.getEmailAddresses().addAll(contact.getEmailAddresses());
                return false;
            }
        }
        contacts.add(contact);
        contactMap.put(contact.getId(), contact);
        return true;
    }

    // update functionality
    public boolean updateContact(long id, Contact updatedContact) {
        if (contactMap.containsKey(id)) {
            Contact savedContact = contactMap.get(id);
            savedContact.setFirstName(updatedContact.getFirstName());
            savedContact.setLastName(updatedContact.getLastName());
            savedContact.setCompany(updatedContact.getCompany());
            savedContact.setJobTitle(updatedContact.getJobTitle());
            savedContact.setPhoneNumbers(updatedContact.getPhoneNumbers());
            savedContact.setEmailAddresses(updatedContact.getEmailAddresses());
            contactMap.put(id, savedContact);
            return true;
        } else {
            return false;
        }
    }

    // delete functionality
    public boolean deleteContact(long id) {
        if (contactMap.containsKey(id)) {
            contactMap.remove(id);
            return true;
        } else {
            return false;
        }
    }

    // search functionality by phone number
    public Contact getContactByPhoneNumber(String phoneNumber) {
        for (Contact contact : contacts) {
            for (PhoneNumber number : contact.getPhoneNumbers()) {
                if (number.getNumber().equals(phoneNumber)) {
                    return contact;
                }
            }
        }
        return null;
    }

    // search functionality by name(first name and last name)
    public Contact getContactByName(String firstName, String lastName) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
                return contact;
            }
        }
        return null;
    }

    public void addPhoneNumber(long id, PhoneNumber phoneNumber) {
        if (contactMap.containsKey(id)) {
            Contact contact = contactMap.get(id);
            contact.getPhoneNumbers().add(phoneNumber);
            contactMap.put(id, contact);
        }
    }

    public void addEmailAddress(long id, EmailAddress emailAddress) {
        if (contactMap.containsKey(id)) {
            Contact contact = contactMap.get(id);
            contact.getEmailAddresses().add(emailAddress);
            contactMap.put(id, contact);
        }
    }

    public String printAllContactsJSON() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Contact contact : contacts) {
            sb.append("\n{");
            sb.append("\n\"id\":").append(contact.getId()).append(",");
            sb.append("\n\"firstName\":\"").append(contact.getFirstName()).append("\",");
            sb.append("\n\"lastName\":\"").append(contact.getLastName()).append("\",");
            sb.append("\n\"company\":\"").append(contact.getCompany()).append("\",");
            sb.append("\n\"jobTitle\":\"").append(contact.getJobTitle()).append("\",");
            sb.append("\n\"phoneNumbers\":[");
            for (PhoneNumber phoneNumber : contact.getPhoneNumbers()) {
                sb.append("\n{");
                sb.append("\n\"label\":\"").append(phoneNumber.getLabel()).append("\",");
                sb.append("\n\"number\":\"").append(phoneNumber.getNumber()).append("\"");
                sb.append("\n},");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\n],");
            sb.append("\n\"emailAddresses\":[");
            for (EmailAddress emailAddress : contact.getEmailAddresses()) {
                sb.append("\n{");
                sb.append("\n\"label\":\"").append(emailAddress.getLabel()).append("\",");
                sb.append("\n\"email\":\"").append(emailAddress.getEmail()).append("\"");
                sb.append("\n},");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\n]");
            sb.append("\n},");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("\n]");
        return sb.toString();
    }

}
