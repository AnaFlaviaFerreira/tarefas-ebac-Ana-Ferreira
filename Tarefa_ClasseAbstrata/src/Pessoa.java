import java.util.Date;

public abstract class Pessoa {
    private String nome;
    private Date data_nascimento_criacao;
    private String endereço;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_nascimento_criacao() {
        return data_nascimento_criacao;
    }

    public void setData_nascimento_criacao(Date data_nascimento_criacao) {
        this.data_nascimento_criacao = data_nascimento_criacao;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }
}
