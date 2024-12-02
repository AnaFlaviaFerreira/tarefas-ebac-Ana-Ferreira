import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] notas = {0,0,0,0};
        for (int i = 0; i < 4; i++) {
            int posicao = i+1;
            System.out.println("Digite a nota " + posicao + ": ");
            notas[i] = scanner.nextDouble();
        }
        String media = CalculaMedia(notas);
        System.out.println("==================");
        System.out.println(media);
    }

    public static String CalculaMedia(double[] notas) {
        double media = 0;
        for (int i = 0; i < notas.length; i++) {
            media += notas[i];
        }
        media = media / 4;
        if (media >= 7) {
            return "Aprovado";
        } else if (media >= 5) {
            return "Recuperação";
        } else {
            return "Reprovado";
        }
    }
}