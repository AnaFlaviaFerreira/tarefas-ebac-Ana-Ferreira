import java.util.*;

/**
 * Separar o nome das pessoas por virgula, ordernar em ordem alfabetica
 * Exemplo: Anna,Luana,Ana
 */
public class Tarefa1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite os nomes: ");
        String nomes = scanner.next();

        System.out.println("=====================");
        System.out.print("Lista Ordenada: ");

        //Separa
        String[] separar = nomes.split(",");

        //Cria a lista
        List<String> lista = new ArrayList<String>();

        //Coloca os valores dentro da lista
        lista.addAll(Arrays.asList(separar));

        //Ordena
        Collections.sort(lista);
        System.out.println(lista);
    }
}
