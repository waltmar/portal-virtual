package br.com.biopids.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.biopids.domain.Autorizacao;
import br.com.biopids.domain.Status;
import br.com.biopids.domain.UsuarioSistema;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.exception.TypeErrors;
import br.com.biopids.model.UserChangePassword;
import br.com.biopids.persistence.DAOUsuarioSistema;
import br.com.biopids.persistence.GenericDAO;
import br.com.biopids.interfaces.IControllerUsuarioSistema;
import br.com.biopids.provider.AppContext;
import br.com.biopids.util.FactoreProperties;

@Service("ControllerUsuarioSistema")
public class ControllerUsuarioSistema extends GenericController<UsuarioSistema, Long> implements IControllerUsuarioSistema<UsuarioSistema, Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5520808066356852875L;
	@Autowired(required=true)
	private DAOUsuarioSistema daoUsuarioSistema;
	
	public ControllerUsuarioSistema(){
		super();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public void save(UsuarioSistema entity) throws ErrorException {
		// TODO Auto-generated method stub
		entity.setEnable(true);
		Autorizacao autorizacao = new Autorizacao();
		autorizacao.setCodigo(Long.valueOf(3));
		autorizacao.setNome("ROLE_FIRST");
		autorizacao.setStatus(Status.ATIVO);
	
		List<Autorizacao> autorizacoes = new ArrayList<Autorizacao>();
		autorizacoes.add(autorizacao);
		entity.setAutorizacoes(autorizacoes);
		entity.setPassword(Integer.toString(1000 + (int)(Math.random() * 1000)));
		super.save(entity);	
		
	}
	
	public boolean isPasswordValid(UsuarioSistema usuario, UserChangePassword userPassword) throws ErrorException{
		Boolean result= true;
		if (!usuario.getPassword().equalsIgnoreCase(userPassword.getPasswordDigitado()) ){
			result = false;
			throw new ErrorException(TypeErrors.SEVERITY_ERROR, FactoreProperties.loadPtbr().getValor("senhaIncorreta"));	
		}
		else if (userPassword.getPasswordNovo().getBytes().length < 4){
			result = false;
			throw new ErrorException(TypeErrors.SEVERITY_ERROR, FactoreProperties.loadPtbr().getValor("senhaComNoMinimo"));
		}
		else if (!userPassword.getPasswordNovo().equalsIgnoreCase(userPassword.getConfirmPassword())) {
			result = false;
			throw new ErrorException(TypeErrors.SEVERITY_ERROR, FactoreProperties.loadPtbr().getValor("senhaDiferente"));
		}
		else if (userPassword.getPasswordDigitado().equalsIgnoreCase(userPassword.getPasswordNovo())) {
			result = false;
			throw new ErrorException(TypeErrors.SEVERITY_ERROR, FactoreProperties.loadPtbr().getValor("senhaIgualaAntiga"));
		}
		return result;
		
	}

	@Override
	public GenericDAO<UsuarioSistema, Long> getDAO() {
		return this.daoUsuarioSistema;
	}

	public DAOUsuarioSistema getDaoUsuarioSistema() {
		return daoUsuarioSistema;
	}

	public void setDaoUsuarioSistema(DAOUsuarioSistema daoUsuarioSistema) {
		this.daoUsuarioSistema = daoUsuarioSistema;
	}
	
}
