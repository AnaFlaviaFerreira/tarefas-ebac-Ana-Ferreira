package dao;

import domain.Client;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClientMapDAO implements IClientDAO {
    private Map<Long, Client> map;

    public ClientMapDAO() {
        this.map = new HashMap<>();
    }

    @Override
    public Boolean cadastrar(Client client) {
        if(this.map.containsKey(client.getCpf())) {
            return false;
        }
        this.map.put(client.getCpf(), client);
        return true;
    }

    @Override
    public void excluir(Long cpf) {
        Client client = this.map.get(cpf);

        if(client != null) {
            //pode ser feito somente com a key, não precisa passar o objeto
            this.map.remove(client.getCpf(), client);
        }
    }

    @Override
    public void alterar(Client client) {
        Client existClient = this.map.get(client.getCpf());
        if(existClient != null) {
            existClient.setNome(client.getNome());
            existClient.setCidade(client.getCidade());
            existClient.setCpf(client.getCpf());
            existClient.setEnd(client.getEnd());
            existClient.setEstado(client.getEstado());
            existClient.setTel(client.getTel());
            existClient.setNumero(client.getNumero());
        }
    }

    @Override
    public Client consultar(Long cpf) {
        return this.map.get(cpf);
    }

    @Override
    public Collection<Client> buscarTodos() {
        return this.map.values();
    }
}
