package impl.miw.presentation.register;

import com.miw.business.UserManagerService;
import com.miw.infrastructure.log.LogService;
import com.miw.model.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RegisterAction extends ActionSupport implements ModelDriven<User> {

	private static final long serialVersionUID = -5248426744413574083L;

	private User usuario = new User();

	private UserManagerService userManagerService;

	private String login;
	private String password;
	private LogService log;

	public LogService getLog() {
		return log;
	}

	public void setLog(LogService log) {
		this.log = log;
	}

	public UserManagerService getUserManagerService() {
		log.debug("Invocado el getUserManagerService de Register");
		return userManagerService;
	}

	public void setUserManagerService(UserManagerService userManagerService) {
		log.debug("Invocado el setUserManagerService de Register");
		this.userManagerService = userManagerService;
	}

	public String execute() throws Exception {
		log.debug("Procesando el execute de Register con ModelDriven");
		log.debug("Usuario: " + usuario.getLogin());
		log.debug("Password: " + usuario.getPassword());

		log.debug(userManagerService.setUser(this));
		return (SUCCESS);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public User getModel() {
		return usuario;
	}
}
