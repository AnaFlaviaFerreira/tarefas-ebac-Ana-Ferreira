package dao;

import domain.Client;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ClientSetDAO implements IClientDAO {
    private Set<Client> set;

    public ClientSetDAO() {
        this.set = new HashSet<>();
    }

    @Override
    public Boolean cadastrar(Client client) {
        return this.set.add(client);
    }

    @Override
    public void excluir(Long cpf) {
        Client clientEncontrato = null;
        for (Client client : this.set) {
            if (client.getCpf().equals(cpf)) {
                clientEncontrato = client;
                break;
            }
        }

        if (clientEncontrato != null) {
            this.set.remove(clientEncontrato);
        }
    }

    @Override
    public void alterar(Client client) {
        if (this.set.contains(client)) {
            for (Client clientCadastrado : this.set) {
                if (clientCadastrado.equals(client)) {
                    clientCadastrado.setNome(client.getNome());
                    clientCadastrado.setTel(client.getTel());
                    clientCadastrado.setNumero(client.getNumero());
                    clientCadastrado.setEnd(client.getEnd());
                    clientCadastrado.setCidade(client.getCidade());
                    clientCadastrado.setEstado(client.getEstado());
                    break;
                }
            }
        }
    }

    @Override
    public Client consultar(Long cpf) {
        for (Client clientCadastrado : this.set) {
            if (clientCadastrado.getCpf().equals(cpf)) {
                return clientCadastrado;
            }
        }
        return null;
    }

    @Override
    public Collection<Client> buscarTodos() {
        return this.set;
    }
}
