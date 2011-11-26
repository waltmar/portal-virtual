/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.biopids.domain;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 *
 * @author cdl
 */
@Entity
@Table(name="empresa")
@Inheritance(strategy=InheritanceType.JOINED)
public class Empresa extends PessoaJuridica{
    

}
