package servlet.controller;

public class HandlerMapping {
	
	private static HandlerMapping handler = new HandlerMapping();
	private HandlerMapping() {}
	public static HandlerMapping getInstance() {
		return handler;
	}	
	public Controller createController(String command) {
		Controller controller = null;
		if(command.equals("find.do")) {
			controller = new FindController();
			System.out.println("FindController  생성됨....");
		}
		return controller;
	}
}
