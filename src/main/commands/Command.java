package main.commands;

import main.database.TableProvider;

public abstract class Command implements ICommand {
    protected TableProvider tableProvider = TableProvider.getInstance();

    abstract public void execute();
}
