/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.biopids.interfaces;

import java.io.Serializable;
import java.util.List;

import br.com.biopids.persistence.GenericSearch;

public interface IDAO <T, oid extends Serializable> extends Serializable{
    void save (T entity);
    void update(T entity);
    void delete(T entity);
    T getByID(T entity,oid id);
    List<T> getAll(T entity);
    List<T> getByFinger(T entity);
    List<T> getByFinder(T entity, String ...colluns);
    List<Object[]> executeQuery(String query);
    List<T> getByFinder(T entity, String[] orders, String ...colluns);
} 
