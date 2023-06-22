package main.commands;

public class AddCommand extends Command {
    private Object object;

    public AddCommand(Object object) {
        this.object = object;
    }

    @Override
    public void execute() {
        tableProvider.getTable().insert(object);
    }
}
