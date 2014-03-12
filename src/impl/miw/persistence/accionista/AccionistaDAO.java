package impl.miw.persistence.accionista;

import impl.miw.presentation.participeproject.ParticipeProjectAction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import com.miw.model.Shareholder;
import com.miw.persistence.ShareholderDataService;

/**
 * Clase que implementa las operaciones de acceso a la base de datos para la
 * entidad ACCIONISTA.
 * 
 * @author Pablo
 * @since 18/12/2013
 * @version 1.0
 */
public class AccionistaDAO implements ShareholderDataService {
	/**
	 * Método que accede a la base de datos para recuerar la lista de
	 * ACCIONISTAS presentes en la base de datos.
	 */
	public Vector<Shareholder> getShareholders() throws Exception {
		// Inicializamos el Vector de retorno.
		Vector<Shareholder> resultado = new Vector<Shareholder>();

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

			ps = con.prepareStatement("select * from accionista");
			rs = ps.executeQuery();

			while (rs.next()) {
				// Completamos los datos del proyecto en la entidad
				Shareholder a = new Shareholder();
				a.setId(rs.getInt("id"));
				a.setIdProyecto(rs.getString("id_proyecto"));
				a.setIdAccionario(rs.getString("id_user"));
				a.setDinero(rs.getDouble("dinero"));
				a.setPendiente(rs.getBoolean("pendiente"));
				// La añadimos al Vector de resultado
				resultado.add(a);
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
	 * Método que accede a la base de datos para guardar ACCIONISTAS
	 * 
	 * @throws Exception
	 */
	public String setShareholder(ParticipeProjectAction participeProjectAction)
			throws Exception {
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

			Shareholder s = new Shareholder();
			s = participeProjectAction.getModel();

			ps = con.prepareStatement("INSERT INTO accionista VALUES (?,?,?,?,?)");

			ps.setString(2, s.getIdProyecto());
			ps.setString(3, s.getIdAccionario());
			ps.setDouble(4, s.getDinero());
			ps.setBoolean(5, s.isPendiente());

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
	public String setPendiente(int id) throws Exception {
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

			ps = con.prepareStatement("UPDATE accionista SET pendiente=? WHERE id=?");

			ps.setBoolean(1, false);
			ps.setInt(2, id);

			ps.executeUpdate();

			resultado = "Accionista Aprobado";

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