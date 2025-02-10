package dao;

import dao.factory.EstoqueFactory;
import dao.factory.VendaFactory;
import dao.generic.GenericDAO;
import domain.Estoque;
import domain.Venda;
import exceptions.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EstoqueDAO extends GenericDAO<Estoque, Long> implements IEstoqueDAO {
    public EstoqueDAO() {
        super();
    }

    @Override
    public Class<Estoque> getTipoClasse() {
        return Estoque.class;
    }

    @Override
    public void atualiarDados(Estoque entity, Estoque entityCadastrado) {
        entityCadastrado.setQuantidadeOriginal(entity.getQuantidadeOriginal());
        entityCadastrado.setQuatidadeEmEstoque(entity.getQuatidadeEmEstoque());
        entityCadastrado.setProduto(entity.getProduto());
    }

    @Override
    protected String getQueryInsercao() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO TB_ESTOQUE ");
        sb.append("(id, id_produto_fk, qtd_original, qtd_em_estoque)");
        sb.append(" VALUES (nextval('sq_estoque'), ?, ?, ?)");
        return sb.toString();
    }

    @Override
    protected String getQueryExclusao() {
        return "DELETE FROM TB_ESTOQUE WHERE id_produto_fk = ?";
    }

    @Override
    protected String getQueryAtualizacao() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE TB_ESTOQUE ");
        sb.append("SET qtd_original = ?,");
        sb.append("qtd_em_estoque = ?");
        sb.append(" WHERE id_produto_fk = ?");
        return sb.toString();
    }

    @Override
    protected void setParametrosQueryInsercao(PreparedStatement stmInsert, Estoque entity) throws SQLException {
        stmInsert.setLong(1, entity.getProduto().getId());
        stmInsert.setInt(2, entity.getQuantidadeOriginal());
        stmInsert.setInt(3, entity.getQuatidadeEmEstoque());
    }

    @Override
    protected void setParametrosQueryExclusao(PreparedStatement stmDelete, Long valor) throws SQLException {
        stmDelete.setLong(1, valor);
    }

    @Override
    protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Estoque entity) throws SQLException {
        stmUpdate.setInt(1, entity.getQuantidadeOriginal());
        stmUpdate.setInt(2, entity.getQuatidadeEmEstoque());
        stmUpdate.setLong(3, entity.getProduto().getId());
    }

    @Override
    protected void setParametrosQuerySelect(PreparedStatement stmSelect, Long valor) throws SQLException {
        stmSelect.setLong(1, valor);
    }

    @Override
    public Estoque buscarAssociacaoEstoqueProduto(Long idProduto) throws DAOException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            connection = getConnection();

            StringBuilder sb = new StringBuilder();
            sb.append("SELECT E.ID, E.QTD_ORIGINAL, E.QTD_EM_ESTOQUE,");
            sb.append("P.ID AS ID_PRODUTO, P.CODIGO, P.NOME, P.DESCRICAO, P.VALOR, P.STATUS");
            sb.append(" FROM TB_ESTOQUE E");
            sb.append(" INNER JOIN TB_PRODUTO P ON P.ID = E.ID_PRODUTO_FK");
            sb.append(" WHERE E.ID_PRODUTO_FK = ?");

            stm = connection.prepareStatement(sb.toString());
            setParametrosQuerySelect(stm, idProduto);
            rs = stm.executeQuery();
            if (rs.next()) {
                Estoque estoque = EstoqueFactory.convert(rs); //setando os campos do estoque
                return estoque;
            }

        } catch (SQLException e) {
            throw new DAOException("ERRO CONSULTANDO OBJETO ", e);
        } finally {
            closeConnection(connection, stm, rs);
        }
        return null;
    }
}
