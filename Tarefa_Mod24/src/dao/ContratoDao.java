package dao;

public class ContratoDao implements IContratoDao{
    @Override
    public void salvar() {
        throw new UnsupportedOperationException("Não funciona com o banco");
    }

    @Override
    public void buscar() {
        throw new UnsupportedOperationException("Não funciona o buscar com o banco");
    }

    @Override
    public void excluir() {
        throw new UnsupportedOperationException("Não funciona o excluir com o banco");
    }

    @Override
    public void atualizar() {
        throw new UnsupportedOperationException("Não funciona o atualizar com o banco");
    }
}
