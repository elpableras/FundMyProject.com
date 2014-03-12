package impl.miw.presentation.participeproject;

import com.miw.business.ShareholderManagerService;
import com.miw.infrastructure.log.LogService;
import com.miw.model.Shareholder;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ParticipeProjectAction extends ActionSupport implements
		ModelDriven<Shareholder> {

	private static final long serialVersionUID = -670830982667206043L;
	private Shareholder accionista = new Shareholder();
	private ShareholderManagerService shareholderManagerService;
	private String IdProyecto;
	private Double dinero;
	private Boolean pendiente;
	private String idAccionario;

	private LogService log;
	private String addedProject;

	public LogService getLog() {
		return log;
	}

	public void setLog(LogService log) {
		this.log = log;
	}

	public ShareholderManagerService getShareholderManagerService() {
		log.debug("Invocado el getShareholderManagerService de ParticipeProject");
		return shareholderManagerService;
	}

	public void setShareholderManagerService(
			ShareholderManagerService shareholderManagerService) {
		log.debug("Invocado el setShareholderManagerService de ParticipeProject");
		this.shareholderManagerService = shareholderManagerService;
	}

	public String getIdProyecto() {
		return IdProyecto;
	}

	public void setIdProyecto(String idProyecto) {
		IdProyecto = idProyecto;
	}

	public Double getDinero() {
		return dinero;
	}

	public void setDinero(Double dinero) {
		this.dinero = dinero;
	}

	public String getIdAccionario() {
		return idAccionario;
	}

	public void setIdAccionario(String idAccionario) {
		this.idAccionario = idAccionario;
	}

	public Boolean getPendiente() {
		return pendiente;
	}

	public void setPendiente(Boolean pendiente) {
		this.pendiente = pendiente;
	}

	public String getAddedProject() {
		return addedProject;
	}

	public void setAddedProject(String addedProject) {
		this.addedProject = addedProject;
	}

	@Override
	public String execute() throws Exception {
		accionista.setIdProyecto(addedProject);

		log.debug("Procesando el execute de ParticipeProject con ModelDriven");
		log.debug("IdProyecto: " + accionista.getIdProyecto());
		log.debug("Dinero: " + accionista.getDinero());
		log.debug("IdAccionista: " + accionista.getIdAccionario());
		log.debug("Pendiente: " + accionista.isPendiente());

		log.debug(shareholderManagerService.setShareholder(this));
		return (SUCCESS);
	}

	@Override
	public Shareholder getModel() {
		return accionista;
	}
}