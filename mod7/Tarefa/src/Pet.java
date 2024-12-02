/**
 * Classe referente a um pet
 */
public class Pet {
    private String nome;
    private int idade;
    private String raca;
    private String tipo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Classe para imprimir as informações do pet
     */
    public void imprimirInformacoes() {
        System.out.println("******* Informações *******");
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade);
        System.out.println("Raça: " + this.raca);
        System.out.println("Tipo: " + this.tipo);
    }

    /**
     *
     * @param verificaIdade
     * @return retorna a categoria do pet
     */
    public String verificarIdade(int verificaIdade) {
        if (verificaIdade <= 1) {
            return "Filhote";
        } else if (verificaIdade <= 7) {
            return "Adulto";
        } else {
            return "Idoso";
        }
    }
}
