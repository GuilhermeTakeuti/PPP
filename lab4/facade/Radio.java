package lab4.facade.facade;

public class Radio {
    private String estacaoPreferida = "89.1 FM";

    public void ligar() {
        System.out.println("Rádio ligado");
    }

    public void desligar() {
        System.out.println("Rádio desligado");
    }

    public void sintonizar(String estacao) {
        this.estacaoPreferida = estacao;
        System.out.println("Rádio sintonizado em " + estacao);
    }

    public void sintonizarPreferida() {
        System.out.println("Rádio sintonizado na estação preferida: " + estacaoPreferida);
    }
}
