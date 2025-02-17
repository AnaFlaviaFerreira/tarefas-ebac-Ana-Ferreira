/**
 * 
 */
package main.java.br.com.ana.dao.jpa;

import main.java.br.com.ana.dao.generic.jpa.GenericJpaDB1DAO;
import main.java.br.com.ana.domain.jpa.ProdutoJpa;

public class ProdutoJpaDAO extends GenericJpaDB1DAO<ProdutoJpa, Long> implements IProdutoJpaDAO {

	public ProdutoJpaDAO() {
		super(ProdutoJpa.class);
	}

}
