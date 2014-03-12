package impl.miw.presentation.login;

import org.apache.struts2.StrutsStatics;

import com.miw.infrastructure.log.LogService;
import com.miw.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor implements
		StrutsStatics {

	private static final long serialVersionUID = -4203964390619150335L;
	private LogService log;

	public LogService getLog() {
		return log;
	}

	public void setLog(LogService log) {
		this.log = log;
	}

	@Override
	public void destroy() {
		log.debug("Destroy invocado de LoginInterceptor");
	}

	@Override
	public void init() {
		log.debug("init de LoginInterceptor");

	}

	@Override
	public String intercept(ActionInvocation inv) throws Exception {
		ActionContext ctx = inv.getInvocationContext();
		User usuario = (User) ctx.getSession().get("usuario");
		String uri = ctx.getName().toLowerCase();
		// Redirección si no se ha hecho login (a no ser que sea
		// la petición de la página de login) (ojo, bucle)
		if (uri.contains("seekprojects") || uri.contains("showprojects")
				|| uri.contains("index") || uri.contains("register"))
			return inv.invoke();
		if (usuario == null && !uri.contains("login")) {
			return "login";
		}
		// En el resto de casos, proceso normal
		return inv.invoke();
	}

}
