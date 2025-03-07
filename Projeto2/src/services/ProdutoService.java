package services;

import dao.IProdutoDAO;
import domain.Produto;
import services.generics.GenericService;

public class ProdutoService extends GenericService<Produto> implements IProdutoService {
    public ProdutoService(IProdutoDAO dao) {
        super(dao);
    }
}
