package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.log4j.Logger;

import entidad.Alumno;
import util.MySqlDBConexion;

public class AlumnoModel {
	
	private static Logger log = Logger.getLogger(AlumnoModel.class.getName());
	
	public int insertarAlumno (Alumno al) {
		
		log.info(">> Inicio >> InsertarAlumno()");
		int salida = -1;
		
		Connection cn = null;
		PreparedStatement prep = null;
		
		try {
			cn = MySqlDBConexion.getConexion();
			
			String sql = "insert into alumno values (null, ?, ?, ?, ?, ?, ?, curtime()";
			prep = cn.prepareStatement(sql);
			prep.setString(1, al.getNombre());
			prep.setString(2, al.getApellido());
			prep.setString(3, al.getDni());
			prep.setString(4, al.getCorreo());
			prep.setString(5, al.getPais());
			prep.setDate(6, al.getFechanac());
			
			log.info(">> SQL >>" + prep);
			
			salida = prep.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				if (cn != null) cn.close();
				if (prep != null) prep.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		log.info(">> Fin >> InsertarAlumno()");
		return salida;
	}

}
