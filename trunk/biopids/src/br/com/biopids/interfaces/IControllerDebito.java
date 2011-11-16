package br.com.biopids.interfaces;

import java.io.Serializable;
import java.util.List;

import br.com.biopids.domain.Debito;
import br.com.biopids.domain.Pessoa;
import br.com.biopids.domain.PessoaFisica;
import br.com.biopids.domain.PessoaJuridica;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.model.ParcelasModel;

public interface IControllerDebito<T extends Serializable, oid extends Serializable> extends IController<T, oid>{
	Pessoa solvePessoa(Long id);
	PessoaJuridica findCnpj(String n) throws ErrorException;
	Object findField(Pessoa pj)throws ErrorException;
	PessoaFisica findCpf(String n) throws ErrorException;
	List<Debito> generateParcels(Debito debito) throws ErrorException;
	void saveListDebito(List<Debito> debitos) throws ErrorException;
	
}
