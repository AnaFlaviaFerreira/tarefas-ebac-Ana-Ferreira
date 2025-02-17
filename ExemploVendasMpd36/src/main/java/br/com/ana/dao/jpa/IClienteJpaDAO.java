/**
 * 
 */
package main.java.br.com.ana.dao.jpa;

import main.java.br.com.ana.dao.generic.jpa.IGenericJapDAO;
import main.java.br.com.ana.domain.jpa.Persistente;

public interface IClienteJpaDAO<T extends Persistente> extends IGenericJapDAO<T, Long>{

}
