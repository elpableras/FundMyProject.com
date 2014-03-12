package impl.miw.presentation.participant;

import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.miw.business.ShareholderManagerService;
import com.miw.infrastructure.log.LogService;
import com.miw.model.Shareholder;
import com.opensymphony.xwork2.ActionSupport;

public class ParticipantsProjectAction extends ActionSupport implements
		ApplicationAware, ServletRequestAware {

	private static final long serialVersionUID = 7838267565155343124L;
	private ShareholderManagerService shareholderManagerService;
	private Map<String, Object> application;
	private HttpServletRequest request;
	private String idTitulo;
	private String idPromotor;
	private LogService log;

	public LogService getLog() {
		return log;
	}

	public void setLog(LogService log) {
		this.log = log;
	}

	public ShareholderManagerService getShareholderManagerService() {
		log.debug("Invocado el getShareholderManagerService de ParticipantsProject");
		return shareholderManagerService;
	}

	public void setShareholderManagerService(
			ShareholderManagerService shareholderManagerService) {
		log.debug("Invocado el setShareholderManagerService de ParticipantsProject");
		this.shareholderManagerService = shareholderManagerService;
	}

	public String getIdTitulo() {
		return idTitulo;
	}

	public void setIdTitulo(String idTitulo) {
		this.idTitulo = idTitulo;
	}

	public String getIdPromotor() {
		return idPromotor;
	}

	public void setIdPromotor(String idPromotor) {
		this.idPromotor = idPromotor;
	}

	@Override
	public String execute() throws Exception {
		setIdTitulo(idTitulo);
		setIdPromotor(idPromotor);
		log.debug("Procesando el execute de ParcicipantsProject");
		log.debug("Titulo Proyecto: " + getIdTitulo());
		log.debug("Promotor Proyecto: " + getIdPromotor());

		Vector<Shareholder> share = shareholderManagerService.getShareholders();
		Vector<Shareholder> shareProjects = new Vector<Shareholder>();

		for (int j = 0; j < share.size(); j++) {
			if (share.get(j).getIdProyecto().equals(idTitulo)) {
				shareProjects.add(share.get(j));
			}
		}
		application.put("participantslist", shareProjects);
		request.getSession().setAttribute("titulo", idTitulo);
		request.getSession().setAttribute("promotor", idPromotor);
		return (SUCCESS);
	}

	@Override
	public void setApplication(Map<String, Object> arg0) {
		application = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest httpServletRequest) {
		log.debug("Invocado el setServletRequest de ParticipantsProject");
		this.request = httpServletRequest;
	}
}