package lab4.facade.facade;

public class Amplificador {
    private int volume;

    public void ligar() {
        System.out.println("Amplificador ligado");
    }

    public void desligar() {
        System.out.println("Amplificador desligado");
    }

    public void ajustarVolume(int volume) {
        this.volume = volume;
        System.out.println("Volume ajustado para " + volume);
    }
}
