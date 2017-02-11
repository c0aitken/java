package iterator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * An address book application.
 */
public class Main {

    /**
     * The name of the file in which the contacts are stored.
     */
    private static final String BOOK_FILE =
            "/Users/campbell/courses/207/course-20713f/stg/lectures/design/addresses.txt";

    /**
     * @param args the command line arguments
     * @throws FileNotFoundException if the address book file does not exist.
     */
    public static void main(final String[] args) 
            throws FileNotFoundException {
        AddressBook book = new AddressBook();
        readBook(book);

        // We can explicitly construct an iterator and go through it.
        Iterator<Contact> contacts0 = book.iterator();
        while (contacts0.hasNext()) {
            System.out.println(contacts0.next());
        }

        // Or we can use this style of for-loop (which depends upon an 
        // iterator).
        System.out.println("==========");
        for (Contact c : book) {
            System.out.println(c);
        }

        // Notice that we can have multiple iterators for the same address book,
        // and they are independent.  Advancing one does not advance the other.
        Iterator<Contact> contacts1 = book.iterator();
        Iterator<Contact> contacts2 = book.iterator();

        System.out.println("==========");
        System.out.println(String.format("C1: %s, %s", contacts1.hasNext(),
                contacts1.next()));
        System.out.println(String.format("C1: %s, %s", contacts1.hasNext(),
                contacts1.next()));
        System.out.println(String.format("C1: %s, %s", contacts1.hasNext(),
                contacts1.next()));
        System.out.println(String.format("C2: %s, %s", contacts2.hasNext(),
                contacts2.next()));

        System.out.println(String.format("C1: %s, %s", contacts1.hasNext(),
                contacts1.next()));
        System.out.println(String.format("C2: %s, %s", contacts2.hasNext(),
                contacts2.next()));
    }

    /**
     * Reads the address book file and add contacts to book.
     *
     * @param book the AddressBook to fill with Contacts.
     * @throws FileNotFoundException if the file does not exist.
     */
    private static void readBook(AddressBook book)
            throws FileNotFoundException {
        File f = new File(BOOK_FILE);
        Scanner sc = new Scanner(f);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            addContact(s, book);
        }
        sc.close();
    }

    /**
     * Adds the Contact described by s to book. s must have this format:
     * "firstName,lastName,email,phone,address"
     *
     * @param s the information about the Contact to extract.
     * @param book the AddressBook to add the current Contact to
     */
    private static void addContact(String s, AddressBook book) {
        Scanner sc = new Scanner(s);
        sc.useDelimiter(",");
        book.addContact(sc.next(), sc.next(), sc.next(), sc.next(), sc.next());
        sc.close();
    }
}