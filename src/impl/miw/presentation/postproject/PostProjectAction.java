package impl.miw.presentation.postproject;

import sun.util.calendar.LocalGregorianCalendar.Date;

import com.miw.business.ProjectManagerService;
import com.miw.infrastructure.log.LogService;
import com.miw.model.Project;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PostProjectAction extends ActionSupport implements
		ModelDriven<Project> {

	private static final long serialVersionUID = 1114776128587326589L;
	private ProjectManagerService projectManagerService;
	private LogService log;

	private Project project = new Project();
	private String titulo;
	private String descripcion;
	private Double coste;
	private Date date;
	private String promotor;
	private Double porcentaje;

	public LogService getLog() {
		return log;
	}

	public void setLog(LogService log) {
		this.log = log;
	}

	public ProjectManagerService getProjectManagerService() {
		log.debug("Invocado el getProjectManagerService de PostProject");
		return projectManagerService;
	}

	public void setProjectManagerService(
			ProjectManagerService projectManagerService) {
		log.debug("Invocado el setProjectManagerService de PostProject");
		this.projectManagerService = projectManagerService;
	}

	public String execute() throws Exception {
		log.debug("Procesando el execute de PostProject con ModelDriven");
		log.debug("Titulo: " + project.getTitulo());
		log.debug("Descipción: " + project.getDescripcion());
		log.debug("Coste: " + project.getCoste());
		log.debug("Fecha: " + project.getFecha());
		log.debug("Promotor: " + project.getPromotor());
		log.debug("Porcentaje: " + project.getPorcentaje());

		log.debug(projectManagerService.setProjects(this));
		return (SUCCESS);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getCoste() {
		return coste;
	}

	public void setCoste(Double coste) {
		this.coste = coste;
	}

	public Date getFecha() {
		return date;
	}

	public void setFecha(Date date) {
		this.date = date;
	}

	public String getPromotor() {
		return promotor;
	}

	public void setPromotor(String promotor) {
		this.promotor = promotor;
	}

	public Double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}

	@Override
	public Project getModel() {
		return project;
	}
}