package impl.miw.presentation.login;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.miw.business.UserManagerService;
import com.miw.infrastructure.log.LogService;
import com.miw.model.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ServletRequestAware,
		ModelDriven<Object> {

	private static final long serialVersionUID = 9105304741910854626L;
	private User usuario = new User();
	private UserManagerService userManagerService;
	private HttpServletRequest request;

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
		log.debug("Invocado el getUserManagerService de Login");
		return userManagerService;
	}

	public void setUserManagerService(UserManagerService userManagerService) {
		log.debug("Invocado el setUserManagerService de Login");
		this.userManagerService = userManagerService;
	}

	public void setServletRequest(HttpServletRequest httpServletRequest) {
		log.debug("Invocado el setServletRequest de Login");
		this.request = httpServletRequest;
	}

	public String execute() throws Exception {
		// Supuestamente, por "dependecy injection" debería
		// tener un: usuario, password
		log.debug("Procesando el execute de Login con ModelDriven");
		log.debug("Usuario: " + usuario.getLogin());
		log.debug("Password: " + usuario.getPassword());

		// Recuperando los usuarios de la base de datos
		Vector<User> users = userManagerService.getUsers();

		for (int i = 0; i < users.size(); i++) {

			// Colocamos el usuario en sesión. En caso de saltar
			// una excepción, no llegaría a colocarse nada.
			if (usuario.getLogin().equals(users.get(i).getLogin())
					&& usuario.getPassword().equals(users.get(i).getPassword())) {
				request.getSession().setAttribute("usuario", usuario);
				return SUCCESS;
			}
		}
		log.error("Contraseña o usuario, incorrectos");
		addFieldError("login", getText("user.error"));
		addFieldError("password", getText("password.error"));
		return ERROR;
	}

	// @RequiredStringValidator(message="El login es obligatorio!")
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
	public Object getModel() {
		return usuario;
	}
}
