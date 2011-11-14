package br.com.biopids.util;

import java.io.Serializable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;


import br.com.biopids.domain.UsuarioSistema;


public class LoginBean implements Serializable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UsuarioSistema usuario;
	
	public LoginBean() {

    }
	
	public UsuarioSistema checkUsuarioController() {
		UsuarioSistema usuario = new UsuarioSistema();
		SecurityContext context = SecurityContextHolder.getContext();
		if (context instanceof SecurityContext) {
			Authentication authentication = context.getAuthentication();
			if (authentication instanceof Authentication) {
				usuario.setUsername( ((User) authentication.getPrincipal()).getUsername());
				usuario.setPassword( ((User) authentication.getPrincipal()).getPassword());
			}
		}
		return usuario;
	}

	public UsuarioSistema getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioSistema usuario) {
		this.usuario = usuario;
	}
 
}