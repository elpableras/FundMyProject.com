package impl.miw.presentation.shareproject;

import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.miw.business.ShareholderManagerService;
import com.miw.infrastructure.log.LogService;
import com.miw.model.Project;
import com.miw.model.Shareholder;
import com.miw.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class ShareProjectAction extends ActionSupport implements
		ApplicationAware, ServletRequestAware {

	private static final long serialVersionUID = 3049479379260231328L;

	private Map<String, Object> application;
	private ShareholderManagerService shareholderManagerService;
	private HttpServletRequest request;
	private LogService log;

	public LogService getLog() {
		return log;
	}

	public void setLog(LogService log) {
		this.log = log;
	}

	public ShareholderManagerService getShareholderManagerService() {
		log.debug("Invocado el getShareholderManagerService de ShareProject");
		return shareholderManagerService;
	}

	public void setShareholderManagerService(
			ShareholderManagerService shareholderManagerService) {
		log.debug("Invocado el setShareholderManagerService de ShareProject");
		this.shareholderManagerService = shareholderManagerService;
	}

	public String execute() throws Exception {
		log.debug("Procesando el execute de ShareProject con ModelDriven");
		@SuppressWarnings("unchecked")
		Vector<Project> projects = (Vector<Project>) application
				.get("projectlist");
		Vector<Shareholder> share = shareholderManagerService.getShareholders();
		Vector<Shareholder> shareProjects = new Vector<Shareholder>();
		Vector<Shareholder> pending = new Vector<Shareholder>();

		User user = (User) request.getSession().getAttribute("usuario");
		String u = user.getLogin();
		for (int i = 0; i < projects.size(); i++) {
			if (u.equals(projects.get(i).getPromotor())) {
				String projectTitulo = projects.get(i).getTitulo();
				for (int j = 0; j < share.size(); j++) {
					if (share.get(j).getIdProyecto().equals(projectTitulo)) {
						shareProjects.add(share.get(j));
						if (share.get(j).isPendiente() == true) {
							pending.add(share.get(j));
						}
					}
				}
			}
		}
		application.put("sharelist", shareProjects);
		application.put("pendinglist", pending);
		return (SUCCESS);
	}

	@Override
	public void setApplication(Map<String, Object> arg0) {
		application = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest httpServletRequest) {
		this.request = httpServletRequest;
	}
}