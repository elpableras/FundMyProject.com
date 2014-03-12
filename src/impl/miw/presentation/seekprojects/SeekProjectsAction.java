package impl.miw.presentation.seekprojects;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;

import com.miw.business.ProjectManagerService;
import com.miw.infrastructure.log.LogService;
import com.opensymphony.xwork2.ActionSupport;

public class SeekProjectsAction extends ActionSupport implements
		ApplicationAware {
	private static final long serialVersionUID = -6346120559503444781L;

	private Map<String, Object> application;

	private ProjectManagerService projectManagerService;
	private LogService log;

	public LogService getLog() {
		return log;
	}

	public void setLog(LogService log) {
		this.log = log;
	}

	public ProjectManagerService getProjectManagerService() {
		log.debug("Invocado el getProjectManagerService de SeekProjects");
		return projectManagerService;
	}

	public void setProjectManagerService(
			ProjectManagerService projectManagerService) {
		log.debug("Invocado el setProjectManagerService  de SeekProjects");
		this.projectManagerService = projectManagerService;
	}

	public String execute() throws Exception {
		log.debug("Procesando el execute de SeekProjects");
		application.put("projectlist", projectManagerService.getProjects());
		return (SUCCESS);
	}

	@Override
	public void setApplication(Map<String, Object> arg0) {
		application = arg0;
	}
}