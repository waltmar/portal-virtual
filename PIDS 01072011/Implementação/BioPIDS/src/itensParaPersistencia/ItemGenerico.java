package itensParaPersistencia;

public class ItemGenerico {
	
	protected String nome_tabela;
	protected String id_item;
	protected String nome; 
	   
	public String NomeTabela(){
		return nome_tabela;
	}
	public void setNomeTabela(String nome_tabela){
		this.nome_tabela = nome_tabela;
	}
	
	public String Id() {
		return id_item;
	}
	public void setId(String id) {
		id_item = id;
	}
	
	public void setNome (String nome){
		this.nome = nome;
	}
	public String getNome(){
		return nome;
	}
	
}
