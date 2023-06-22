package main.commands;

import java.util.List;

public class PrintAllCommand extends Command {

    @Override
    public void execute() {
        List<Object> list = tableProvider.getTable().getAll();

        if(list.isEmpty()) {
            System.out.println("The resulting table is empty");
        }

        tableProvider.getTable().getAll().forEach(e -> System.out.println(e.toString()));
    }
}
