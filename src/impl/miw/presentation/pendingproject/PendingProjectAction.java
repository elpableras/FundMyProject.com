package impl.miw.presentation.pendingproject;

import java.util.Map;
import java.util.Vector;

import org.apache.struts2.interceptor.ApplicationAware;

import com.miw.business.ShareholderManagerService;
import com.miw.infrastructure.log.LogService;
import com.miw.model.Project;
import com.miw.model.Shareholder;
import com.opensymphony.xwork2.ActionSupport;

public class PendingProjectAction extends ActionSupport implements
		ApplicationAware {

	private static final long serialVersionUID = -670830982667206043L;
	private Shareholder accionista = new Shareholder();
	private ShareholderManagerService shareholderManagerService;
	private Boolean pendiente;
	private int addedPending;
	private LogService log;
	private Map<String, Object> application;

	public LogService getLog() {
		return log;
	}

	public void setLog(LogService log) {
		this.log = log;
	}

	public ShareholderManagerService getShareholderManagerService() {
		log.debug("Invocado el getShareholderManagerService de PendingProject");
		return shareholderManagerService;
	}

	public void setShareholderManagerService(
			ShareholderManagerService shareholderManagerService) {
		log.debug("Invocado el setShareholderManagerService de PendingProject");
		this.shareholderManagerService = shareholderManagerService;
	}

	public Boolean getPendiente() {
		return pendiente;
	}

	public void setPendiente(Boolean pendiente) {
		this.pendiente = pendiente;
	}

	public int getAddedPending() {
		return addedPending;
	}

	public void setAddedPending(int addedPending) {
		this.addedPending = addedPending;
	}

	@Override
	public String execute() throws Exception {
		accionista.setId(addedPending);

		log.debug("Procesando el execute de PendingProject");
		log.debug("Id: " + accionista.getId());

		@SuppressWarnings("unchecked")
		Vector<Project> projects = (Vector<Project>) application
				.get("projectlist");
		@SuppressWarnings("unchecked")
		Vector<Shareholder> shares = (Vector<Shareholder>) application
				.get("pendinglist");
		log.debug(shareholderManagerService.setPendiente(accionista.getId(),
				projects, shares));
		return (SUCCESS);
	}

	@Override
	public void setApplication(Map<String, Object> arg0) {
		application = arg0;
	}
}