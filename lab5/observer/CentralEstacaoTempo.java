package lab5.observer.observer;

import java.util.ArrayList;
import java.util.List;

public class CentralEstacaoTempo {
    private List<ObservadorTempo> observadores = new ArrayList<>();
    private double temperatura;
    private double umidade;
    private double velocidadeVento;

    public void registrarObservador(ObservadorTempo observador) {
        observadores.add(observador);
        System.out.println("Observador registrado: " + observador.getClass().getSimpleName());
    }

    public void removerObservador(ObservadorTempo observador) {
        observadores.remove(observador);
        System.out.println("Observador removido: " + observador.getClass().getSimpleName());
    }

    public void notificarObservadores() {
        System.out.println("\n--- Notificando observadores ---");
        for (ObservadorTempo observador : observadores) {
            observador.atualizar(temperatura, umidade, velocidadeVento);
        }
    }

    public void setMedicoes(double temperatura, double umidade, double velocidadeVento) {
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.velocidadeVento = velocidadeVento;
        System.out.println("\nNovas medições registradas:");
        System.out.println("Temperatura: " + temperatura + "°C");
        System.out.println("Umidade: " + umidade + "%");
        System.out.println("Velocidade do vento: " + velocidadeVento + " km/h");
        notificarObservadores();
    }
}
