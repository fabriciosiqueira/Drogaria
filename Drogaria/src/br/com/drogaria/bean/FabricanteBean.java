package br.com.drogaria.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;
import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;

@ManagedBean(name = "MBFabricante")
@ViewScoped

public class FabricanteBean {

	private Fabricante fabricante; // Variavel vai ser usada para cadastra, editar e excluir um fabricante
	private ListDataModel<Fabricante> itens;

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public ListDataModel<Fabricante> getItens() {
		return itens;
	}

	public void setItens(ListDataModel<Fabricante> itens) {
		this.itens = itens;
	}

	@PostConstruct
	//Pesquisar
	public void prepararPesquisa() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			ArrayList<Fabricante> lista = dao.listar();
			itens = new ListDataModel<Fabricante>(lista);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void prepararNovo () {
		fabricante = new Fabricante();
		
	}
	
	
	//Cadastrar
	public void novoFabricante() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.salvar(fabricante);
			
			//Reorganizar lista p�s cadastramento
			ArrayList<Fabricante> lista = dao.listar();
			itens = new ListDataModel<Fabricante>(lista);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
