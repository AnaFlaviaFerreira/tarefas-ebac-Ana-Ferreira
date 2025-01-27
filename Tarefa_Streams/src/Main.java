import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite Nome-Sexo separado por virgulas para mais pessoas: ");
        String nomes = scanner.next();
        System.out.println("=====================");

        //Separar
        String[] separar = nomes.split(",");

        //Cria a lista
        Stream<String> stream = List.of(separar).stream();

        //filtrando e mostrando
        stream.filter(pessoa -> pessoa.split("-")[1].equalsIgnoreCase("F"))
                .forEach(pessoa -> System.out.println(pessoa.split("-")[0]));
    }
}