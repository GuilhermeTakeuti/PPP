package lab4.facade.facade;

public class PlayerStreaming {
    public void ligar() {
        System.out.println("Player de streaming ligado");
    }

    public void desligar() {
        System.out.println("Player de streaming desligado");
    }

    public void play(String filme) {
        System.out.println("Reproduzindo: " + filme);
    }

    public void stop() {
        System.out.println("Reprodução parada");
    }
}
