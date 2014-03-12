package impl.miw.persistence.user;

import impl.miw.presentation.register.RegisterAction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import com.miw.model.User;
import com.miw.persistence.UserDataService;

/**
 * Clase que implementa las operaciones de acceso a la base de datos para la
 * entidad USER.
 * 
 * @author Pablo
 * @since 18/12/2013
 * @version 1.0
 */
public class UserDAO implements UserDataService {
	/**
	 * Método que accede a la base de datos para recuerar lista de USUARIOS
	 * presentes en la base de datos.
	 */
	public Vector<User> getUsers() throws Exception {
		// Inicializamos el Vector de retorno.
		Vector<User> resultado = new Vector<User>();

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

			ps = con.prepareStatement("select * from user");
			rs = ps.executeQuery();

			while (rs.next()) {
				// Completamos los datos del user en la entidad
				User u = new User();
				u.setLogin(rs.getString("login"));
				u.setPassword(rs.getString("password"));
				// La añadimos al Vector de resultado
				resultado.add(u);
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
	 * Método que accede a la base de datos para guardar USER
	 */
	public String setUser(RegisterAction registerAction) throws Exception {
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

			User u = new User();
			u = registerAction.getModel();

			ps = con.prepareStatement("INSERT INTO user VALUES (?,?,?)");

			ps.setString(2, u.getLogin());
			ps.setString(3, u.getPassword());

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
}
