package br.com.biopids.validator;

import java.util.regex.Pattern;

public class CNPJValidator extends AbstractValidator {
	
	protected static Pattern replaceSintaxPattern;

	static {
		replaceSintaxPattern = Pattern.compile("[\\.\\-\\/s]");
	}
	
	
	@Override
	public boolean validate() {
		boolean result = validCNPJ();
		if(!result){
			setErroMessage(getPropertiesLoader().getValor("cnpj_message"));
		}
		return result;
	}
	
	public boolean validCNPJ(){
		String cnpj = replaceSintaxPattern.matcher((CharSequence) getValue()).replaceAll("");
		int soma = 0, dig;
		String cnpj_calc = cnpj.substring(0, 12);
		char[] chr_cnpj = cnpj.toCharArray();
		for (int i = 0; i < 4; i++){
			if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9){
				soma += (chr_cnpj[i] - 48) * (6 - (i + 1));
			}
		}
		for (int i = 0; i < 8; i++){
			if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9){
				soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));
			}
		}
		dig = 11 - (soma % 11);
		cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(dig);
		soma = 0;
		for (int i = 0; i < 5; i++){
			if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9){
				soma += (chr_cnpj[i] - 48) * (7 - (i + 1));
			}
		}
		for (int i = 0; i < 8; i++){
			if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9){
				soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));
			}
		}
		dig = 11 - (soma % 11);
		cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(dig);
		return cnpj.equals(cnpj_calc);
		
		
	}

}
