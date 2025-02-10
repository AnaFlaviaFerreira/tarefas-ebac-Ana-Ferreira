package dao.factory;

import domain.Estoque;
import domain.Produto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EstoqueFactory {
    public static Estoque convert(ResultSet rs) throws SQLException {
        Produto prod = ProdutoFactory.convert(rs);
        Estoque estoque = new Estoque();
        estoque.setProduto(prod);
        estoque.setId(rs.getLong(("ID")));
        estoque.setQuantidadeOriginal(rs.getInt(("QTD_ORIGINAL")));
        estoque.setQuatidadeEmEstoque(rs.getInt(("QTD_EM_ESTOQUE")));
        return estoque;
    }
}
