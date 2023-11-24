package dao;

import java.sql.*;

public class DAO {
	protected static Connection conexao;
	
	public DAO() {
		conexao = null;
	}
	
	public boolean conectar() {
	    String driverName = "org.postgresql.Driver";
	    String serverName = "localhost";
	    String mydatabase = "matchup";
	    int porta = 5432;
	    String url = "jdbc:postgresql://" + serverName + ":" + porta + "/" + mydatabase;
	    String username = "postgres";
	    String password = "mvva2005";
	    try {
	        Class.forName(driverName);
	        conexao = DriverManager.getConnection(url, username, password);
	        System.out.println("Conexão efetuada com o postgres!");
	        return true;  // Connection successful
	    } catch (ClassNotFoundException e) {
	        System.err.println("Driver não encontrado: " + e.getMessage());
	    } catch (SQLException e) {
	        System.err.println("Conexão falhou: " + e.getMessage());
	        System.out.println(e);
	    }

	    return false;  // Connection failed
	}

	
	public boolean close() {
		boolean status = false;
		
		try {
			conexao.close();
			status = true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return status;
	}
}