package test.commands;

import main.dao.User;
import main.database.TableProvider;
import main.database.UsersTable;
import org.junit.After;
import org.junit.Before;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

public class CommandTestUtil {

    protected UsersTable table;
    protected User user;

    protected List<User> list = new ArrayList<>();

    protected final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    protected final PrintStream originalOut = System.out;
    @Before
    public void setUp() {
        table = Mockito.mock(UsersTable.class);

        TableProvider.getInstance().setTable(table);

        when(table.getAll()).thenReturn(Collections.singletonList(list));

        doAnswer(e -> {
            list.add(user);
            return e;
        }).when(table).insert(any());

        doAnswer(e -> {
            list.clear();
            return e;
        }).when(table).deleteAll();

        System.setOut(new PrintStream(outContent));
    }

    @After
    public void destroy() {
        System.setOut(originalOut);
    }




}
