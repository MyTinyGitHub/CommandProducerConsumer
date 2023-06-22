package main;

import main.commands.*;
import main.database.TableProvider;
import main.database.UsersTable;
import main.service.CommandBuffer;
import main.service.Consumer;
import main.service.Producer;
import main.dao.User;

public class Main {
    public static ICommand[] commandsToExecute = {
            new AddCommand(new User(1, "a1", "Robert")),
            new AddCommand(new User(2, "a2", "Martin")),
            new PrintAllCommand(),
            new DeleteAllCommand(),
            new PrintAllCommand()
    };

    public static void main(String[] args) {
        TableProvider.getInstance().setTable(new UsersTable());

        CommandBuffer buffer = new CommandBuffer();
        Producer producer = new Producer(buffer, commandsToExecute);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();
    }
}