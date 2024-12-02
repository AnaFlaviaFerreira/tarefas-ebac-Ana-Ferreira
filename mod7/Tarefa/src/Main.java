//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Pet pet = new Pet();
        pet.setNome("Maggie Maria");
        pet.setIdade(9);
        pet.setRaca("Shih Tzu");
        pet.setTipo("Cachorro");

        pet.imprimirInformacoes();
        System.out.println("Categoria: " + pet.verificarIdade(pet.getIdade()));
    }
}