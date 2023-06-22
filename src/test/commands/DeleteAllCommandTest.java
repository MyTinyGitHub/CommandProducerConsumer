package test.commands;

import main.commands.DeleteAllCommand;
import org.junit.Before;
import org.junit.Test;
import main.dao.User;

import static org.junit.Assert.assertEquals;

public class DeleteAllCommandTest extends CommandTestUtil {
    DeleteAllCommand command;

    @Before
    public void setUp() {
        super.setUp();

        command = new DeleteAllCommand();
    }

    @Test
    public void testRemoveEmptyList() {
        assertEquals(true, list.isEmpty());

        command.execute();

        assertEquals(true, list.isEmpty());
    }

    @Test
    public void testRemoveMultipleItemsInList() {
        User user1 = new User(1, "a", "a");
        User user2 = new User(2, "b", "b");

        list.add(user1);
        list.add(user2);

        assertEquals(false, list.isEmpty());

        command.execute();

        assertEquals(true, list.isEmpty());
    }
}
