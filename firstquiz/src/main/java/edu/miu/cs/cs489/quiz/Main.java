package edu.miu.cs.cs489.quiz;

import java.util.Scanner;

import edu.miu.cs.cs489.quiz.model.Contact;
import edu.miu.cs.cs489.quiz.model.ContactUtil;
import edu.miu.cs.cs489.quiz.model.EmailAddress;
import edu.miu.cs.cs489.quiz.model.PhoneNumber;

public class Main {
    public static void main(String[] args) {
        ContactUtil contactUtil = new ContactUtil();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Create contact");
            System.out.println("2. Print all contacts");
            System.out.println("3 Search contact by phone number");
            System.out.println("4. Update contact");
            System.out.println("5. Delete contact");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter first name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter last name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter company: ");
                    String company = scanner.nextLine();
                    System.out.print("Enter job title: ");
                    String jobTitle = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter phone number label: ");
                    String phoneNumberLabel = scanner.nextLine();
                    System.out.print("Enter email address: ");
                    String emailAddress = scanner.nextLine();
                    System.out.print("Enter email address label: ");
                    String emailAddressLabel = scanner.nextLine();
                    Contact contact = new Contact(firstName, lastName, company, jobTitle,
                            new PhoneNumber(phoneNumber, phoneNumberLabel),
                            new EmailAddress(emailAddress, emailAddressLabel));
                    contactUtil.addContact(contact);
                    break;
                case 2:
                    System.out.println(contactUtil.printAllContactsJSON());
                    break;
                case 3:
                    System.out.print("Enter phone number: ");
                    String searchPhoneNumber = scanner.nextLine();
                    Contact searchContact = contactUtil.getContactByPhoneNumber(searchPhoneNumber);
                    if (searchContact != null) {
                        System.out.println(searchContact);
                    } else {
                        System.out.println("Contact not found");
                    }
                    break;
                // couldnt finish all the cases due to time but I have implemented the logic for
                // all the cases in the Util class
            }
        } while (choice > 0 || choice < 5);

    }
}