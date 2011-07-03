package itensParaPersistencia;

public class Taxonomia extends ItemGenerico{
	

	private String pai;

	
	
	public void setPai(String pai) {
		this.pai = pai;
	}
	public String getPai() {
		return pai;
	}
	public void clear(){
		nome_tabela="";
		id_item="";
		pai="";
	}
}	
		     
			