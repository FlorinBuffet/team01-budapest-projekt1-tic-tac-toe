import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UserinterfaceTest {

    @Test
    public void testChangeLanguage() {
        //implement test

        UserInterface ui = new UserInterface();
        ui.changeLanguage("English");
        assertEquals("English", ui.getLanguage());

    }
}
