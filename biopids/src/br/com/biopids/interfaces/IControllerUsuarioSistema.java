package br.com.biopids.interfaces;

import java.io.Serializable;

import br.com.biopids.domain.UsuarioSistema;
import br.com.biopids.exception.ErrorException;
import br.com.biopids.model.UserChangePassword;

public interface IControllerUsuarioSistema<T extends Serializable, oid extends Serializable> extends IController<T, oid>{
	
	boolean isPasswordValid(UsuarioSistema usuario, UserChangePassword userPassword) throws ErrorException;
	
}
