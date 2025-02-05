package dao;

import dao.jdbc.ConnectionFactory;
import domain.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class ClienteDAO implements IClienteDAO{
    @Override
    public Integer cadastrar(Cliente cliente) throws Exception {
        Connection connection = null; //Iniciando a conexão
        PreparedStatement stm = null; //Preparando a conexão com as queries

        try{
            connection = ConnectionFactory.getConnection();
            String sql = "INSERT INTO TB_CLIENTE (ID, CODIGO, NOME) VALUES (nextval('SQ_CLIENTE'),?,?)";

            stm = connection.prepareStatement(sql);
            stm.setString(1, cliente.getCodigo());
            stm.setString(2, cliente.getNome());

            return stm.executeUpdate(); //executar a querie
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
    public Cliente consultar(String codigo) throws Exception {
        Connection connection = null; //Iniciando a conexão
        PreparedStatement stm = null; //Preparando a conexão com as queries
        ResultSet rs = null; //Resultado da consulta
        Cliente cliente = null;

        try{
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM TB_CLIENTE WHERE CODIGO = ?";

            stm = connection.prepareStatement(sql);
            stm.setString(1, codigo);

            rs = stm.executeQuery(); //executar a querie de select
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getLong("id"));
                cliente.setCodigo(rs.getString("codigo"));
                cliente.setNome(rs.getString("nome"));
            }
            return cliente;
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
    public Integer excluir(Cliente clienteBD) throws Exception {
        Connection connection = null; //Iniciando a conexão
        PreparedStatement stm = null; //Preparando a conexão com as queries

        try{
            connection = ConnectionFactory.getConnection();
            String sql = "DELETE FROM TB_CLIENTE WHERE CODIGO = ? ";

            stm = connection.prepareStatement(sql);
            stm.setString(1, clienteBD.getCodigo());

            return stm.executeUpdate(); //executar a querie
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
    public List<Cliente> buscarTodos() throws Exception {
        return List.of();
    }

    @Override
    public Integer alterar(Cliente cliente) throws Exception {
        return 0;
    }
}
