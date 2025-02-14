package main.java.br.com.ana.dao.jpa;

import main.java.br.com.ana.dao.generic.jpa.GenericJpaDAO;
import main.java.br.com.ana.domain.jpa.ProdutoJPA;

public class ProdutoJpaDAO extends GenericJpaDAO<ProdutoJPA, Long> implements IProdutoJpaDAO {

    public ProdutoJpaDAO() {
        super(ProdutoJPA.class);
    }

}
