package dao;

import dao.jdbc.ConnectionFactory;
import domain.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements IProdutoDAO{

    @Override
    public Integer cadastrar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "INSERT INTO TB_PRODUTO (ID, CODIGO, NOME, DESCRICAO, PRECO) VALUES (nextval('SQ_PRODUTO'), ?, ?, ?, ?)";

            stm = connection.prepareStatement(sql);
            stm.setString(1,produto.getCodigo());
            stm.setString(2,produto.getNome());
            stm.setString(3,produto.getDescricao());
            stm.setDouble(4,produto.getPreco());

            return stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Produto consultar(String codigo) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet result = null;
        Produto produto = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM TB_PRODUTO WHERE CODIGO=?";

            stm = connection.prepareStatement(sql);
            stm.setString(1,codigo);

            result = stm.executeQuery();
            if(result.next()) {
                produto = new Produto();
                produto.setId(result.getLong("id"));
                produto.setCodigo(result.getString("codigo"));
                produto.setNome(result.getString("nome"));
                produto.setDescricao(result.getString("descricao"));
                produto.setPreco(result.getDouble("preco"));
            }
            return produto;
        } catch (Exception e) {
            throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Integer excluir(Produto produtoBD) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "DELETE FROM TB_PRODUTO WHERE CODIGO=?";

            stm = connection.prepareStatement(sql);
            stm.setString(1,produtoBD.getCodigo());

            return stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public List<Produto> buscarTodos() throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet result = null;
        List<Produto> produtos = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM TB_PRODUTO";

            stm = connection.prepareStatement(sql);

            result = stm.executeQuery();
            while(result.next()) {
                Produto produto = new Produto();
                produto.setId(result.getLong("id"));
                produto.setCodigo(result.getString("codigo"));
                produto.setNome(result.getString("nome"));
                produto.setDescricao(result.getString("descricao"));
                produto.setPreco(result.getDouble("preco"));

                produtos.add(produto);
            }
            return produtos;
        } catch (Exception e) {
            throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Integer alterar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "UPDATE TB_PRODUTO SET CODIGO=?, NOME=?, DESCRICAO=?, PRECO=? WHERE ID=?";

            stm = connection.prepareStatement(sql);
            stm.setString(1,produto.getCodigo());
            stm.setString(2,produto.getNome());
            stm.setString(3,produto.getDescricao());
            stm.setDouble(4,produto.getPreco());
            stm.setLong(5,produto.getId());

            return stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Integer excluirTodos() throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "DELETE FROM TB_PRODUTO";

            stm = connection.prepareStatement(sql);

            return stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
}
