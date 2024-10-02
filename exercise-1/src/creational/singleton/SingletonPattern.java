package src.creational.singleton;
/*
 Scenario: A single instance of a Database class to manage database connections.
 * 
*/
class Database {
    private static Database instance;

    private Database() {
        // Private constructor to prevent instantiation
    }

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public void connect() {
        System.out.println("Connected to the database");
    }
}
