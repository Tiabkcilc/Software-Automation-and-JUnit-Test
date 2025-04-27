import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();

    /**
     * Adds a new contact.
     * @param contact the Contact to add (non‑null, unique ID)
     * @throws IllegalArgumentException       if contact is null
     * @throws DuplicateContactException      if ID already exists
     */
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null.");
        }
        if (contacts.containsKey(contact.getContactId())) {
            throw new DuplicateContactException(
                "Contact with ID " + contact.getContactId() + " already exists.");
        }
        contacts.put(contact.getContactId(), contact);
    }

    /**
     * Deletes a contact by ID.
     * @param contactId the ID of the contact to delete
     * @throws ContactNotFoundException if ID not found
     */
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new ContactNotFoundException(
                "Contact with ID " + contactId + " not found.");
        }
        contacts.remove(contactId);
    }

    /**
     * Updates fields of a contact by ID.
     * @param contactId ID of the contact
     * @param firstName new first name (or null to skip)
     * @param lastName  new last name (or null to skip)
     * @param phone     new phone (or null to skip)
     * @param address   new address (or null to skip)
     * @throws ContactNotFoundException if ID not found
     */
    public void updateContact(String contactId, String firstName,
                              String lastName, String phone, String address) {
        Contact c = contacts.get(contactId);
        if (c == null) {
            throw new ContactNotFoundException(
                "Contact with ID " + contactId + " not found.");
        }
        if (firstName != null) c.setFirstName(firstName);
        if (lastName  != null) c.setLastName(lastName);
        if (phone     != null) c.setPhone(phone);
        if (address   != null) c.setAddress(address);
    }

    /** Retrieves a contact by ID, or null if not found. */
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }

    /** Exception for duplicate IDs. */
    public static class DuplicateContactException extends RuntimeException {
        private static final long serialVersionUID = 1L;
        public DuplicateContactException(String message) {
            super(message);
        }
    }

    /** Exception when contact not found. */
    public static class ContactNotFoundException extends RuntimeException {
        private static final long serialVersionUID = 1L;
        public ContactNotFoundException(String message) {
            super(message);
        }
    }
}
