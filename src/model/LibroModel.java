package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Logger;

//
import entidad.Libro;
import util.MySqlDBConexion;

public class LibroModel {
	
	
	private static Logger log = Logger.getLogger(LibroModel.class.getName());

	public ArrayList<Libro> reporteXAño(int Desde, int Hasta){
		ArrayList<Libro> lista = new  ArrayList<Libro>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
		
			conn = MySqlDBConexion.getConexion();
			
			String sql = "select anio, count(*) from libro where year (fechaRegistro) between ? and ? group by anio;";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, Desde);
			pstm.setInt(2, Hasta);
			log.info(">> SQL >> " + pstm);

			rs = pstm.executeQuery();
			Libro obj = null;
			while(rs.next()) {
				obj = new Libro();
				obj.setAnio(rs.getInt(1));
				obj.setCantidad(rs.getInt(2));
				lista.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstm != null) pstm.close();
				if (conn != null) conn.close(); 
			} catch (Exception e2) {}
		}
		return lista;
	}
	
}
