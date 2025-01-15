import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite os nomes: ");
        String nomes = scanner.next();
        System.out.println("=====================");

        //Separar
        String[] separar = nomes.split(",");

        //Cria a lista
        List<String> lista = new ArrayList<String>();

        //Coloca os valores dentro da lista
        lista.addAll(Arrays.asList(separar));

        //Separar grupos
        List<String> listaF = new ArrayList<String>();
        List<String> listaM = new ArrayList<String>();

        lista.forEach((value) -> {
            String[] newItem = value.split("-");
            if (newItem[1].equalsIgnoreCase("F")) {
                listaF.add(value);
            } else if (newItem[1].equalsIgnoreCase("M")) {
                listaM.add(value);
            }
        });
        System.out.print("Genero Feminino: ");
        System.out.println(listaF);

        System.out.print("Genero Massculino: ");
        System.out.println(listaM);
    }
}