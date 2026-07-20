package lab4.facade.facade;

public class CarroFacade {
    private Motor motor;
    private CintoSeguranca cinto;
    private Porta porta;
    private Farol farol;
    private Radio radio;

    public CarroFacade(Motor motor, CintoSeguranca cinto, Porta porta,
                       Farol farol, Radio radio) {
        this.motor = motor;
        this.cinto = cinto;
        this.porta = porta;
        this.farol = farol;
        this.radio = radio;
    }

    public void dirigir() {
        System.out.println("\n=== Preparando para dirigir ===");
        motor.ligar();
        porta.trancar();
        cinto.travar();
        farol.acender();
        radio.ligar();
        radio.sintonizarPreferida();
        System.out.println("=== Carro pronto para dirigir! ===");
    }

    public void finalizarCorrida() {
        System.out.println("\n=== Finalizando corrida ===");
        radio.desligar();
        farol.apagar();
        cinto.destravar();
        porta.destrancar();
        motor.desligar();
        System.out.println("=== Carro desligado! ===");
    }
}
