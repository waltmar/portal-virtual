package br.com.biopids.interfaces;

public interface IValidator<T> {
	
	public boolean validateField(T entity);

}
