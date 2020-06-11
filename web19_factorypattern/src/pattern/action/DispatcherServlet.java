package pattern.action;

import pattern.factory.ActionFactory;

public class DispatcherServlet {

	public static void main(String[] args) {
		String command = "INSERT";
		ActionFactory factory = ActionFactory.getInstance();
		
		Action action  = factory.createAction(command);
		System.out.print(action.execute());
	}

}
