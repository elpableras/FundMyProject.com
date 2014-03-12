package impl.miw.presentation.unlogin;

import javax.servlet.http.HttpServletRequest;

import com.miw.infrastructure.log.LogService;
import com.miw.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class UnLoginAction extends ActionSupport implements
		org.apache.struts2.interceptor.ServletRequestAware {

	private static final long serialVersionUID = -231793042015025420L;
	private User usuario = new User();
	private HttpServletRequest request;
	private LogService log;

	public LogService getLog() {
		return log;
	}

	public void setLog(LogService log) {
		this.log = log;
	}

	public void setServletRequest(HttpServletRequest httpServletRequest) {
		log.debug("Invocado el setServletRequest de UnLogin");
		this.request = httpServletRequest;
	}

	public String execute() throws Exception {
		// Supuestamente, por "dependecy injection" debería
		// tener un: usuario, password
		log.debug("Procesando el execute de UnLogin con ModelDriven");
		log.debug("Usuario: " + usuario.getLogin());
		log.debug("Password: " + usuario.getPassword());
		// Quitamois el usuario de sesión.
		if (request.getSession().getAttribute("usuario") != null) {
			request.getSession().setAttribute("usuario", null);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
}
