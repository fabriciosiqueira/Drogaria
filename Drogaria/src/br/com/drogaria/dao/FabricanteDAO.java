package br.com.drogaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.factory.ConexaoFactory;

public class FabricanteDAO {

	// ***********CRUD SQL**********

	// SQL INSERT
	public void salvar(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fabricante ");
		sql.append("(descricao) ");
		sql.append("VALUES (?)");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());

		comando.executeUpdate();
	}

	// SQL DELETE
	public void excluir(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fabricante ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getCodigo());

		comando.executeUpdate();

	}

	// SQL UPDATE
	public void editar(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append("UPDATE fabricante ");
		sql.append("SET descricao = ? ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());
		comando.setLong(2, f.getCodigo());

		comando.executeUpdate();
	}

	// SQL SELECT
	public Fabricante buscarPorCodigo(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fabricante ");
		sql.append("WHERE  codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getCodigo());

		ResultSet resultado = comando.executeQuery();

		Fabricante retorno = null;

		if (resultado.next()) {
			retorno = new Fabricante();
			retorno.setCodigo(resultado.getLong("codigo"));
			retorno.setDescricao(resultado.getString("descricao"));
		}
		return retorno;
	}

	// Listagem
	public ArrayList<Fabricante> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fabricante ");
		sql.append("ORDER BY descricao ASC ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Fabricante> lista = new ArrayList<Fabricante>();

		while (resultado.next()) {
			Fabricante f = new Fabricante();
			f.setCodigo(resultado.getLong("codigo"));
			f.setDescricao(resultado.getString("descricao"));

			lista.add(f);
		}
		return lista;
	}

	// BUSCAR POR DESCRI��O
	public ArrayList<Fabricante> buscarPorDescricao(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fabricante ");
		sql.append("WHERE descricao  LIKE ? ");
		sql.append("ORDER BY descricao ASC ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, "%" + f.getDescricao() + "%");

		ResultSet resultado = comando.executeQuery();

		ArrayList<Fabricante> lista = new ArrayList<Fabricante>();

		while (resultado.next()) {
			Fabricante item = new Fabricante();
			item.setCodigo(resultado.getLong("codigo"));
			item.setDescricao(resultado.getString("descricao"));

			lista.add(item);
		}
		return lista;

	}

	public static void main(String[] args) {
		// Teste INSERT

		/*
		 * Fabricante f1 = new Fabricante(); f1.setDescricao("DESCRI��O 1"); Fabricante
		 * f2 = new Fabricante(); f2.setDescricao("DESCRI��O 1");
		 * 
		 * FabricanteDAO fdao = new FabricanteDAO();
		 * 
		 * try { fdao.salvar(f1); fdao.salvar(f2);
		 * System.out.println("Fabricantes foram salvos com sucesso!!"); } catch
		 * (SQLException e) {
		 * System.out.println("Ocorreu um erro ao tentar salvar um dos fabricantes!");
		 * // TODO Auto-generated catch block e.printStackTrace(); }
		 */

		// Teste DELETE
		/*
		 * Fabricante f1 = new Fabricante(); f1.setCodigo(1L);
		 * 
		 * Fabricante f2 = new Fabricante(); f2.setCodigo(2L);
		 * 
		 * FabricanteDAO fdao =new FabricanteDAO();
		 * 
		 * try { fdao.excluir(f1); fdao.excluir(f2);
		 * System.out.println("Fabricantes foram excluidos  com sucesso!!"); } catch
		 * (SQLException e) {
		 * System.out.println("Ocorreu um erro ao tentar excluir um dos fabricantes!");
		 * // TODO Auto-generated catch block e.printStackTrace(); }
		 */

		// Teste Editar
		/*
		 * Fabricante f1 = new Fabricante(); f1.setCodigo(4L);
		 * f1.setDescricao("DESCRICAO 2"); FabricanteDAO fdao = new FabricanteDAO();
		 * 
		 * try { fdao.editar(f1);
		 * System.out.println("Fabricantes foram editados com sucesso!!"); } catch
		 * (SQLException e) {
		 * System.out.println("Ocorreu um erro ao tentar editar um dos fabricantes!");
		 * // TODO Auto-generated catch block e.printStackTrace(); }
		 */

		// Teste SELECT
		/*
		 * Fabricante f1 = new Fabricante(); f1.setCodigo(4L);
		 * 
		 * Fabricante f2 = new Fabricante(); f2.setCodigo(5L); FabricanteDAO fdao = new
		 * FabricanteDAO();
		 * 
		 * try { Fabricante f3 = fdao.buscarPorCodigo(f1); Fabricante f4 =
		 * fdao.buscarPorCodigo(f2);
		 * System.out.println("Fabricantes foram pesquisados  com sucesso!!");
		 * System.out.println("Resultado 1:  " + f3);
		 * System.out.println("Resultado 2:  " + f4); } catch (SQLException e) {
		 * System.out.println("Ocorreu um erro ao tentar pesquisar um dos fabricantes!"
		 * ); // TODO Auto-generated catch block e.printStackTrace(); }
		 */

		// LISTAGEM
		/*
		 * FabricanteDAO fdao = new FabricanteDAO(); try { ArrayList<Fabricante> lista =
		 * fdao.listar();
		 * 
		 * for(Fabricante f : lista) { System.out.println("Resultado da listagem: " +
		 * f); }
		 * 
		 * } catch (SQLException e) { // TODO Auto-generated catch block
		 * System.out.println("Ocorreu um erro ao tenatr listar os fabricantes!");
		 * e.printStackTrace(); }
		 */
		/*
		 * // BUSCAR POR DESCRI��O Fabricante f1 = new Fabricante();
		 * f1.setDescricao("1");
		 * 
		 * FabricanteDAO fdao = new FabricanteDAO();
		 * 
		 * ArrayList<Fabricante> lista; try { lista = fdao.buscarPorDescricao(f1); for
		 * (Fabricante f : lista) { System.out.println("Resultado da listagem: " + f); }
		 * } catch (SQLException e) { // TODO Auto-generated catch block
		 * System.out.println("Ocorreu um erro ao tentar pesquisar um fabricante!");
		 * e.printStackTrace(); }
		 */

	}
}
