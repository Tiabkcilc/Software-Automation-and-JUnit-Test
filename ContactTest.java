import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    public void testValidContactCreation() {
        Contact c = new Contact("ID123", "Alice", "Smith", "1234567890", "123 Elm Street");
        assertEquals("ID123", c.getContactId());
        assertEquals("Alice", c.getFirstName());
        assertEquals("Smith", c.getLastName());
        assertEquals("1234567890", c.getPhone());
        assertEquals("123 Elm Street", c.getAddress());
    }

    @Test
    public void testContactIdBoundary() {
        String validId = "ABCDEFGHIJ";  // 10 chars
        new Contact(validId, "A", "B", "0123456789", "Addr");
        assertThrows(Contact.InvalidContactDataException.class, () ->
            new Contact(validId + "K", "A", "B", "0123456789", "Addr"));
    }

    @Test
    public void testNameBoundaries() {
        String valid = "ABCDEFGHIJ";  // 10 chars
        new Contact("ID1", valid, valid, "0123456789", "Addr");
        assertThrows(Contact.InvalidContactDataException.class, () ->
            new Contact("ID2", valid + "K", "Last", "0123456789", "Addr"));
        assertThrows(Contact.InvalidContactDataException.class, () ->
            new Contact("ID3", "First", valid + "K", "0123456789", "Addr"));
    }

    @Test
    public void testPhoneValidation() {
        assertThrows(Contact.InvalidContactDataException.class, () ->
            new Contact("ID1", "A", "B", "12345", "Addr"));
        assertThrows(Contact.InvalidContactDataException.class, () ->
            new Contact("ID1", "A", "B", "ABCDEFGHIJ", "Addr"));
    }

    @Test
    public void testAddressBoundary() {
        String validAddr = "123456789012345678901234567890"; // 30 chars
        new Contact("ID1", "A", "B", "0123456789", validAddr);
        assertThrows(Contact.InvalidContactDataException.class, () ->
            new Contact("ID2", "A", "B", "0123456789", validAddr + "X"));
    }

    @Test
    public void testSettersAndNegative() {
        Contact c = new Contact("ID1", "Alice", "Smith", "1234567890", "Addr");
        c.setFirstName("Bob");
        assertEquals("Bob", c.getFirstName());
        assertThrows(Contact.InvalidContactDataException.class, () -> c.setFirstName(null));

        c.setLastName("Jones");
        assertEquals("Jones", c.getLastName());
        assertThrows(Contact.InvalidContactDataException.class, () -> c.setLastName("TooLongLastName"));

        c.setPhone("0987654321");
        assertEquals("0987654321", c.getPhone());
        assertThrows(Contact.InvalidContactDataException.class, () -> c.setPhone("123"));

        c.setAddress("New Addr");
        assertEquals("New Addr", c.getAddress());
        assertThrows(Contact.InvalidContactDataException.class, () -> c.setAddress(null));
    }
}
