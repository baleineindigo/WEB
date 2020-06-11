package pattern.model;

public class DAO {
	private static DAO dao = new DAO();
	private DAO() {}
	public static DAO getInstance() {
		return dao;
	}
	
	public NoteBook findNoteBook(String model) {
		System.out.print(model);
		NoteBook notebook = new NoteBook(model,1500000);
		return notebook;
	}
}
