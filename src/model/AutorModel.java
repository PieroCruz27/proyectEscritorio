package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Logger;

import entidad.Autor;
import util.MySqlDBConexion;

public class AutorModel {
	private static final Logger log = Logger.getLogger(AutorModel.class.getName());

	public int insertarAutor(Autor oAutor) {
		int salida = -1;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			// Obtención de la conexión
			con = MySqlDBConexion.getConexion();

			// Creación de sentencia SQL
			String sql = "insert into autor values(null,?,?,?,curtime(),?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, oAutor.getNombres());
			pst.setString(2, oAutor.getApellidos());
			pst.setDate(3, oAutor.getFechaNacimiento());
			pst.setString(4, oAutor.getPais());
			pst.setString(5, oAutor.getGrado());

			log.info(">>>" + pst);

			// Ejecución de la sentencia SQL
			salida = pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (con != null)
					con.close();
				if (pst != null)
					pst.close();
			} catch (Exception e2) {
			}
		}

		return salida;
	}

}
