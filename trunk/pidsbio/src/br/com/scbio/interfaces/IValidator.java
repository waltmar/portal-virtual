package br.com.scbio.interfaces;

public interface IValidator<T> {
	
	public boolean validateField(T entity);

}
