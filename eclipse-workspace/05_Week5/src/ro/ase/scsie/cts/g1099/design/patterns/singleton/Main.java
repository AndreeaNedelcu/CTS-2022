package ro.ase.scsie.cts.g1099.design.patterns.singleton;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBConnection mysql=DBConnection.getConnection();
		DBConnection mysql2=DBConnection.getConnection();
		//compare the references (only 1 object)
		if(mysql==mysql2) {
			System.out.println("They reference the same object");
		}


	}

}
