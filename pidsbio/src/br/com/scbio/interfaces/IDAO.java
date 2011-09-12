/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.scbio.interfaces;

import java.io.Serializable;
import java.util.List;

public interface IDAO <T, oid extends Serializable> {
    void save (T entity);
    void update(T entity);
    void delete(T entity);
    T getByID(T entity,oid id);
    List<T> getAll(T entity);
    List<T> getByFinger(T entity);
}
