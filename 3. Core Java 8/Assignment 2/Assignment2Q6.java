package Assignment2;

abstract class Persistence {
    abstract public String persist();
}
class FilePersistence extends Persistence{
    @Override
    public String persist() {
    	System.out.println("FilePersistence");
    	return "FilePersistence";
    }
}
class DatabasePersistence extends Persistence{
    @Override
    public String persist() {
    	System.out.println("DatabasePersistence");
    	return "DatabasePersistence";
    }
}
class Client{
	Client(FilePersistence filePersistence){
		filePersistence.persist();
	}
	Client(DatabasePersistence databasePersistence){
		databasePersistence.persist();
	}
}

public class Assignment2Q6 {
    public static void main(String[] args) {
//    	FilePersistence filePersistence = new FilePersistence();
//    	DatabasePersistence databasePersistence = new DatabasePersistence();
//    	Client client1 = new Client(filePersistence);
//    	Client client2 = new Client(databasePersistence);
    }
}
