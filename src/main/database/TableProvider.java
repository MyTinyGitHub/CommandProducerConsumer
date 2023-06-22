package main.database;

public class TableProvider {
    private ITable table;
    private static TableProvider instance;
    private TableProvider() {
    }

    public void setTable(ITable table) {
        this.table = table;
    }

    public ITable getTable() {
        return this.table;
    }

    public static TableProvider getInstance() {
        if(instance == null) {
            instance = new TableProvider();
        }

        return instance;
    }
}
