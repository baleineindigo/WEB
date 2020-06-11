package pattern.action;

public class AddAction implements Action {

	@Override
	public String execute() {
	/*
	 1/ 폼값 받아서
	 2/ 폼값
	 3. BIZ로직
	 4. 리턴값 바인딩
	 5. PATH를 최종적으로 리턴
	 * */
		;
		return insert();
		
	}

	public String insert() {
		return "insert";
	}
	
	public void delete() {
		System.out.print("delete");
	}
	
}
