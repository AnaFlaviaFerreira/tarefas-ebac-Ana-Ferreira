public class Nota {
    private double[] notas;

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    public void calculaMedia() {
        double media = 0;
        System.out.println("****** Notas ******");
        for (int i = 0; i < this.notas.length; i++) {
            int posicao = i+1;
            System.out.println("Nota " + posicao + ": " + this.notas[i]);
            media += this.notas[i];
        }

        System.out.println("\nMédia das notas: " + media / this.notas.length);
    }
}
