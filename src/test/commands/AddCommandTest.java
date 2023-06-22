package test.commands;

import main.commands.AddCommand;
import main.dao.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddCommandTest extends CommandTestUtil {
    AddCommand command;

    @Before
    public void setUp() {
        super.setUp();

        command = new AddCommand(user);
    }

    @Test
    public void testAddCommand() {
        assertEquals(0, list.size());

        command.execute();

        assertEquals(1, list.size());

        for(User u : list) {
            assertEquals(user, u);
        }
    }
}
