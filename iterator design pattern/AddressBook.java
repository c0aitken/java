package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * An address book: a list of contacts.
 */
class AddressBook implements Iterable<Contact> {

    /** This AddressBook's list of contacts. */
    private List<Contact> contacts;
    
    /** The index of the currently-viewed contact in this AddressBook. */
    private int currentContact = 0;
    
    /**
     * Constructs a new AddressBook.
     */
    public AddressBook() {
    	contacts = new ArrayList<>();
    }

    @Override
    public String toString() {
        String res = "";
        for (Contact c : contacts) {
            res += c;
        }
        return res;
    }

    /**
     * Adds a new contact with last name lastName, first name firstName, email
     * address email, phone number phone, and address address.
     * @param lastName the last name
     * @param firstName the first name
     * @param email the email address
     * @param phone the phone number
     * @param address the address
     */
    public void addContact(String lastName, String firstName,
            String email, String phone, String address) {
        Contact c = new Contact(lastName, firstName, email, phone, address);
        contacts.add(c);
    }

    /**
     * Returns the currently-selected Contact, or null if there are none.
     * @return the currently-selected Contact.
     */
    public Contact getCurrentContact() {
        if (!contacts.isEmpty()) {
            return contacts.get(currentContact);
        } else {
            return null;
        }
    }

    /**
     * Returns the number of contacts in this book.
     * @return the number of contacts in this book.
     */
    public int getSize() {
        return contacts.size();
    }

    /**
     * Returns the ith Contact.
     * @param i the index of the Contact to return.
     * @return the ith Contact.
     */
    public Contact getContact(int i) {
        return contacts.get(i);
    }

    /**
     * Returns an iterator for this address book.
     * @return an iterator for this address book.
     */
    @Override
    public Iterator<Contact> iterator() {
        return new AddressBookIterator();
    }

    /**
     * An Iterator for AddressBook Contacts.
     */
    private class AddressBookIterator implements Iterator<Contact> {

        /** The index of the next Contact to return. */
        private int current = 0;

        /**
         * Returns whether there is another Contact to return.
         * @return whether there is another Contact to return.
         */
        @Override
        public boolean hasNext() {
            return current < contacts.size();
        }

        /**
         * Returns the next Contact.
         * @return the next Contact.
         */
        @Override
        public Contact next() {
        	Contact res = contacts.get(current);
            current += 1;
            return res;
        }

        /**
         * Removes the contact just returned.  Unsupported.
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported.");
        }
    }
}