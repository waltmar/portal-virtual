package itensParaPersistencia;

import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class EnumTaxonomia {
	
	private ArrayList<String> tax = new ArrayList();
	
	public EnumTaxonomia () {
		
	tax.add("Reino");
	tax.add("Filo");
	tax.add("Classe");
	tax.add("SubClasse");
	tax.add("Ordem");
	tax.add("SubOrdem");
	tax.add("Familia");
	tax.add("SubFamilia");
	tax.add("Genero");
	tax.add("Especie");
	tax.add("Epiteto");
	}
	public ArrayList getEnumTaxonomia(){
		return tax;
	}
	
}
