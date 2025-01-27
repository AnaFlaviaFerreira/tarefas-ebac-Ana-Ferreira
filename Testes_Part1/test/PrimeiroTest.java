import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrimeiroTest {
    @Test
    public void onlyWomen() {
        String nomes = "Ana-F,Julia-F,Bia-F";
        //Separar
        String[] separar = nomes.split(",");

        //Cria a lista
        List<String> nomesComparar = List.of(separar);

        //filtrando o resultado
        List<String> nomesResultado = nomesComparar.stream()
                .filter(pessoa -> pessoa.split("-")[1].equalsIgnoreCase("F"))
                .collect(Collectors.toList());

        Assert.assertEquals(nomesResultado, nomesComparar);
    }

    @Test
    public void notOnlyWomen() {
        String nomes = "Ana-F,Tiago-M,Julia-F,Bia-F,Mat-M";
        //Separar
        String[] separar = nomes.split(",");

        //Cria a lista
        List<String> nomesComparar = List.of(separar);

        //filtrando o resultado
        List<String> nomesResultado = nomesComparar.stream()
                .filter(pessoa -> pessoa.split("-")[1].equalsIgnoreCase("F"))
                .collect(Collectors.toList());

        Assert.assertEquals(nomesResultado, nomesComparar);
    }
}
