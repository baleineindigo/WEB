package servlet.function;

public class ComponentFactory {
	private static ComponentFactory Compfac = new ComponentFactory();
	private ComponentFactory() {};
	public static ComponentFactory getInstance() {
		return Compfac;
	}
	public Component getComponent(String command) {
		if(command.equals("register")) {
			return new RegisterComp();
		}else if (command.equals("find")) {
			return new FindComp();
		}else if (command.equals("idcheck")) {
			return new IdCheckComp();
		}else if (command.equals("update")) {
			return new UpdateComp();
		}else if (command.equals("login")) {
			return new LoginComp();
		}else if (command.equals("logout")) {
			return new LogoutComp();
		}else if (command.equals("allmember")) {
			return new AllMemberComp();
		}
		return null;
	}
}
