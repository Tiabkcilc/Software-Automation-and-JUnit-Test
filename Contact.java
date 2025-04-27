public class Contact {
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    /**
     * Constructs a new Contact.
     * @param contactId   unique ID (non‑null, ≤10 chars)
     * @param firstName   first name (non‑null, ≤10 chars)
     * @param lastName    last name (non‑null, ≤10 chars)
     * @param phone       phone number (non‑null, exactly 10 digits)
     * @param address     address (non‑null, ≤30 chars)
     * @throws InvalidContactDataException if any parameter is invalid
     */
    public Contact(String contactId, String firstName, String lastName,
                   String phone, String address) {
        if (contactId == null || contactId.length() > 10) {
            throw new InvalidContactDataException("Contact ID must be non‑null and at most 10 characters.");
        }
        if (firstName == null || firstName.length() > 10) {
            throw new InvalidContactDataException("First name must be non‑null and at most 10 characters.");
        }
        if (lastName == null || lastName.length() > 10) {
            throw new InvalidContactDataException("Last name must be non‑null and at most 10 characters.");
        }
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new InvalidContactDataException("Phone must be non‑null and exactly 10 digits.");
        }
        if (address == null || address.length() > 30) {
            throw new InvalidContactDataException("Address must be non‑null and at most 30 characters.");
        }
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName  = lastName;
        this.phone     = phone;
        this.address   = address;
    }

    // Getters
    public String getContactId() { return contactId; }
    public String getFirstName() { return firstName; }
    public String getLastName()  { return lastName; }
    public String getPhone()     { return phone; }
    public String getAddress()   { return address; }

    // Setters for updatable fields
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new InvalidContactDataException("First name must be non‑null and at most 10 characters.");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new InvalidContactDataException("Last name must be non‑null and at most 10 characters.");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new InvalidContactDataException("Phone must be non‑null and exactly 10 digits.");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new InvalidContactDataException("Address must be non‑null and at most 30 characters.");
        }
        this.address = address;
    }

    /** Custom exception for invalid contact data. */
    public static class InvalidContactDataException extends RuntimeException {
        private static final long serialVersionUID = 1L;
        public InvalidContactDataException(String message) {
            super(message);
        }
    }
}
