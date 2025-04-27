import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
    private ContactService svc;

    @BeforeEach
    public void setUp() {
        svc = new ContactService();
    }

    @Test
    public void testAddAndGetContact() {
        Contact c = new Contact("ID1", "A", "B", "0123456789", "Addr");
        svc.addContact(c);
        assertEquals(c, svc.getContact("ID1"));
    }

    @Test
    public void testAddNullOrDuplicate() {
        assertThrows(IllegalArgumentException.class, () -> svc.addContact(null));
        Contact c = new Contact("ID1", "A", "B", "0123456789", "Addr");
        svc.addContact(c);
        assertThrows(ContactService.DuplicateContactException.class, () -> svc.addContact(c));
    }

    @Test
    public void testDeleteContact() {
        Contact c = new Contact("ID1", "A", "B", "0123456789", "Addr");
        svc.addContact(c);
        svc.deleteContact("ID1");
        assertNull(svc.getContact("ID1"));
        assertThrows(ContactService.ContactNotFoundException.class, () -> svc.deleteContact("ID1"));
    }

    @Test
    public void testUpdateContact() {
        Contact c = new Contact("ID1", "A", "B", "0123456789", "Addr");
        svc.addContact(c);
        svc.updateContact("ID1", "X", "Y", "0987654321", "New Addr");
        assertEquals("X", c.getFirstName());
        assertEquals("Y", c.getLastName());
        assertEquals("0987654321", c.getPhone());
        assertEquals("New Addr", c.getAddress());
    }

    @Test
    public void testUpdateNonexistent() {
        assertThrows(ContactService.ContactNotFoundException.class,
                     () -> svc.updateContact("NOPE", "X", "Y", "0123456789", "Addr"));
    }
}
