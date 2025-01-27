//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Class<?> classAnnotation = Annotation.class;
        System.out.println("Nome da tabela: " + classAnnotation.getAnnotation(Tabela.class).value());

    }
}