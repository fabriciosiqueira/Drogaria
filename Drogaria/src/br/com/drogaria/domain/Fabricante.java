package br.com.drogaria.domain;

public class Fabricante {
	private Long codigo;
	private String descricao;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	//Ensinar o JAVA a impirmir OBJFabricante de forma legivel
	
	@Override
	public String toString() {
		// Formatador de OBJ
		String saida = codigo + " / " + descricao;
		return saida;
	}

}
