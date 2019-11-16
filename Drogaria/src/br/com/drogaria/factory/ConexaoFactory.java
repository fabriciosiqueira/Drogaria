package br.com.drogaria.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	private static final String USUARIO = "root";
	private static final String SENHA = "123123";
	private static final String URL = "jdbc:mysql://localhost:3306/drogaria?useTimezone=true&serverTimezone=America/Sao_Paulo";

	// Caso ocorra porblemas de fuso horario adicione ao final da Stirng URL
	// Oinico…padrao/SeuBancoVemAqui?useTimezone=true&serverTimezone=America/Sao_Paulo
	public static Connection conectar() throws SQLException {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		return conexao;
	}

	public static void main(String[] args) {
		try {
			Connection conexao = ConexaoFactory.conectar();
			System.out.println("Conexao realizada com sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("N„o foi possivel realizar a conexao!");
		}
	}

}
