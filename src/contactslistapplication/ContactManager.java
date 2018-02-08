/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactslistapplication;

import java.util.Arrays;

/**
 *
 * @author justin
 */
public class ContactManager {

    Contact[] contacts = new Contact[100];
    int contactCount = 0;
    DBHandler dbHandler = new DBHandler();

    void addContact(
            String firstName,
            String lastName,
            String phone,
            String email) {
        Contact contact = new Contact();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhone(phone);
        contact.setEmail(email);

        contacts[contactCount++] = contact;
        
        dbHandler.insertRow(firstName, lastName, phone, email);
    }

    String[] getContactsList() {
        String[] stringArray = new String[contactCount];
        for (int i = 0; i < contactCount; i++) {
            if (contacts[i] != null) {
                stringArray[i] = contacts[i].toString();
            }
        }
        return stringArray;
    }

    String[] getContactFields(int selected) {

        if (selected > -1) {
            Contact c = contacts[selected];
            String[] fields = new String[4];
            fields[0] = c.getFirstName();
            fields[1] = c.getLastName();
            fields[2] = c.getPhone();
            fields[3] = c.getEmail();
            return fields;
        } else {
            return null;
        }
    }

    boolean deleteContact(int index) {
        if (index > -1 && index < contactCount) {
            for (int i = index; i < contactCount - 1; i++) {
                contacts[i] = contacts[i + 1];

            }
            contactCount = contactCount - 1;
            return true;
        } else {
            return false;
        }

    }

    boolean editContact(
            int index, String firstName,
            String lastName,
            String phone,
            String email) {
        contacts[index].setFirstName(firstName);
        contacts[index].setLastName(lastName);
        contacts[index].setPhone(phone);
        contacts[index].setEmail(email);
        return true;
    }

}
