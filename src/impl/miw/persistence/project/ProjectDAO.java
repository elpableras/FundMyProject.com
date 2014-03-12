package impl.miw.persistence.project;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Vector;

import com.miw.model.Project;
import com.miw.persistence.ProjectDataService;

/**
 * Clase que implementa las operaciones de acceso a la base de datos para la
 * entidad PROYECTO.
 * 
 * @author Pablo
 * @since 18/12/2013
 * @version 1.0
 */
public class ProjectDAO implements ProjectDataService {
	/**
	 * Método que accede a la base de datos para recuerar la lista de proyectos
	 * presentes en la base de datos.
	 */
	public Vector<Project> getProjects() throws Exception {
		// Inicializamos el Vector de retorno.
		Vector<Project> resultado = new Vector<Project>();

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/fundmyproject";

			// Obtenemos la conexión a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager
					.getConnection(SQL_URL, "pablo", "fundmyproject");

			ps = con.prepareStatement("select * from proyecto order by fecha asc");
			rs = ps.executeQuery();

			while (rs.next()) {
				// Completamos los datos del proyecto en la entidad
				Project p = new Project();
				p.setId(rs.getInt("id"));
				p.setTitulo(rs.getString("titulo"));
				p.setDescripcion(rs.getString("descripcion"));
				p.setCoste(rs.getDouble("coste"));
				Date fecha = rs.getDate("fecha");
				java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
						"dd/MM/yyyy");
				String f = sdf.format(fecha);
				p.setFecha(f);
				p.setPromotor(rs.getString("promotor"));
				p.setPorcentaje(rs.getDouble("porcentaje"));
				p.setUsers(rs.getInt("usuarios"));
				// La añadimos al Vector de resultado
				resultado.add(p);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		} finally {
			try {
				ps.close();
				con.close();
			} catch (Exception e) {
			}
		}
		// Retornamos el vector de resultado.
		return resultado;
	}

	/**
	 * Método que accede a la base de datos para guardar PROYECTO
	 */
	public String setProjects(Project project) throws Exception {
		// Inicializamos el String de retorno.
		String resultado = "";

		PreparedStatement ps = null;
		Connection con = null;

		try {
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/fundmyproject";

			// Obtenemos la conexión a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager
					.getConnection(SQL_URL, "pablo", "fundmyproject");

			ps = con.prepareStatement("INSERT INTO proyecto VALUES (?,?,?,?,?,?,?,?)");

			ps.setString(2, project.getTitulo());
			ps.setString(3, project.getDescripcion());
			ps.setDouble(4, project.getCoste());

			SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date date = sdf1.parse(project.getFecha());
			java.sql.Date sqlDate = new Date(date.getTime());

			ps.setDate(5, sqlDate);
			ps.setString(6, project.getPromotor());
			ps.setDouble(7, project.getPorcentaje());
			ps.setInt(8, project.getUsers());

			ps.executeUpdate();

			resultado = "Datos Guardados Correctamente";

		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		} finally {
			try {
				ps.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
				resultado = "Se ha producido un error";
			}
		}
		// Retornamos el vector de resultado.
		return resultado;
	}

	@Override
	public String setPercent(Double newPercent, int newShareholder,
			String idProject) throws Exception {
		// Inicializamos el String de retorno.
		String resultado = "";

		PreparedStatement ps = null;
		Connection con = null;

		try {
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/fundmyproject";

			// Obtenemos la conexión a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager
					.getConnection(SQL_URL, "pablo", "fundmyproject");

			ps = con.prepareStatement("UPDATE proyecto SET porcentaje=?, usuarios=? WHERE titulo=?");

			ps.setDouble(1, newPercent);
			ps.setInt(2, newShareholder);
			ps.setString(3, idProject);

			ps.executeUpdate();

			resultado = "Actualizado Porcentaje Nuevo Correctamente";

		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		} finally {
			try {
				ps.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
				resultado = "Se ha producido un error";
			}
		}
		// Retornamos el vector de resultado.
		return resultado;
	}
}