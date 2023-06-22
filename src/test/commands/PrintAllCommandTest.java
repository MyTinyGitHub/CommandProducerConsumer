package test.commands;

import main.commands.PrintAllCommand;
import main.dao.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrintAllCommandTest extends CommandTestUtil {

    private PrintAllCommand command;
    private static final String SEPARATOR = System.lineSeparator();
    @Before
    public void setUp() {
        super.setUp();

        command = new PrintAllCommand();
    }

    @Test
    public void testEmptyPrintAllCommand() {


        String result = "[]" + SEPARATOR;

        command.execute();
        assertEquals(result, outContent.toString());
    }

    @Test
    public void testSingleElementPrintAllCommand() {
        User user1 = new User(1, "a", "Test");
        list.add(user1);

        String result = "[" + user1.toString() + "]" + SEPARATOR;
        command.execute();
        assertEquals(result, outContent.toString());
    }

    @Test
    public void testMultipleElementPrintAllCommand() {
        User user2 = new User(2, "b", "Test");
        User user1 = new User(1, "a", "Test");

        list.add(user1);
        list.add(user2);

        String result = "[" + user1.toString() + ", " + user2.toString() + "]"  + SEPARATOR;

        command.execute();

        assertEquals(result, outContent.toString());

    }
}
