package ro.ase.scsie.cts.g1099.design.patterns.singleton;

public class DBConnection {
	//the reference to the unique object(singleton object)
	private static DBConnection connection=null;
	
	private String connectionString;
	private String database;
	private String username;
	
	//private ctor for singleton !!!!!!
	private DBConnection(String connectionString, String database, String username) {
		super();
		this.connectionString = connectionString;
		this.database = database;
		this.username = username;
	}

	private DBConnection() {
		super();
	}
	
	//syncronized for multithreading 
	public synchronized static DBConnection getConnection() {
		if(connection ==null) {
			connection=new DBConnection();
		}
		return connection;
	}
	
	
	
}
