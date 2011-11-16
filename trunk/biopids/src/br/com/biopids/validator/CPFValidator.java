package br.com.biopids.validator;

import java.util.regex.Pattern;

public class CPFValidator extends AbstractValidator {
	
	protected static Pattern replaceSintaxPattern;
	
	static{
		replaceSintaxPattern = Pattern.compile("[\\.\\-\\s]");
	}
	
	@Override
	public boolean validate() {
		boolean result = true;
		if(!validCPF()){
			result = false;
			setErroMessage(getPropertiesLoader().getValor("cpf_message"));
		}
		return result;
	}
	
	private boolean validCPF(){
		String cpf =  replaceSintaxPattern.matcher(getValue().toString()).replaceAll("");
		int     d1, d2;
		int     digito1, digito2, resto;
		int     digitoCPF;
		String  nDigResult;
		d1 = d2 = 0;
		digito1 = digito2 = resto = 0;
		for (int n_Count = 1; n_Count < cpf.length() -1; n_Count++)	{
			digitoCPF = Integer.valueOf (cpf.substring(n_Count -1, n_Count)).intValue();
			d1 = d1 + ( 11 - n_Count ) * digitoCPF;
			d2 = d2 + ( 12 - n_Count ) * digitoCPF;
		}
		resto = (d1 % 11);
		if (resto < 2){
			digito1 = 0;
		}else{
			digito1 = 11 - resto;
		}
		d2 += 2 * digito1;
		resto = (d2 % 11);
		if (resto < 2){
			digito2 = 0;
		}else{
			digito2 = 11 - resto;
		}
		String nDigVerific = cpf.substring (cpf.length()-2, cpf.length());
		nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
		return nDigVerific.equals(nDigResult);
	}

}
