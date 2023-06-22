package main.commands;

public class DeleteAllCommand extends Command {

    @Override
    public void execute() {
        tableProvider.getTable().deleteAll();
    }
}
