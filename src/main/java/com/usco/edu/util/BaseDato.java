package com.usco.edu.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;	
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

public class BaseDato {
	
	@Value("${spring.profiles.active}")
	private String perfilSeleccionado;

	Logger log = Logger.getLogger(getClass().getName());

	public Connection getConexion() {
		Connection conexion = null;
		try {
			Context ctx = new InitialContext();

			DataSource dataSource = null;
			
			if (perfilSeleccionado.equals("local")) {

				dataSource = (DataSource) ctx.lookup("jboss/datasources/ConsultaDS");

			} else if (perfilSeleccionado.equals("test") || perfilSeleccionado.equals("produccion")) {

				dataSource = (DataSource) ctx.lookup("java:jboss/datasources/EgresadoWebConsultaDS");

			}

			conexion = dataSource.getConnection();
			
		} catch (Exception e) {
			StringWriter stack = new StringWriter();
			e.printStackTrace(new PrintWriter(stack));
			log.error("getConexion() - ERROR: " + stack.toString());
		}
		return conexion;
	}
	

	public void cerrarConexion(Connection conexion) {
		if (conexion != null) {
			try {
				conexion.close();
			} catch (SQLException e) {
				StringWriter stack = new StringWriter();
				e.printStackTrace(new PrintWriter(stack));
				log.error("cerrarConexion(Connection) - ERROR: " + stack.toString());
			}
		}
	}

	public void cerrarConexion(PreparedStatement sentencia) {
		if (sentencia != null) {
			try {
				sentencia.close();
			} catch (SQLException e) {
				StringWriter stack = new StringWriter();
				e.printStackTrace(new PrintWriter(stack));
				log.error("cerrarConexion(PreparedStatement) - ERROR: " + stack.toString());
			}
		}
	}

	public void cerrarConexion(Statement sentencia) {
		if (sentencia != null) {
			try {
				sentencia.close();
			} catch (SQLException e) {
				StringWriter stack = new StringWriter();
				e.printStackTrace(new PrintWriter(stack));
				log.error("cerrarConexion(Statement) - ERROR: " + stack.toString());
			}
		}
	}

	public void cerrarConexion(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				StringWriter stack = new StringWriter();
				e.printStackTrace(new PrintWriter(stack));
				log.error("cerrarConexion(ResultSet) - ERROR: " + stack.toString());
			}
		}
	}

}
