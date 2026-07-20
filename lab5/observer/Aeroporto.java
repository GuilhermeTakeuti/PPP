package lab5.observer.observer;

public class Aeroporto implements ObservadorTempo {
    @Override
    public void atualizar(double temperatura, double umidade, double velocidadeVento) {
        System.out.println("=== AEROPORTO DE UBERLÂNDIA ===");
        System.out.println("Velocidade do vento: " + velocidadeVento + " km/h");

        if (velocidadeVento > 50) {
            System.out.println("⚠️ ALERTA: Ventos fortes detectados! Pode haver atrasos nos voos.");
        } else if (velocidadeVento > 30) {
            System.out.println("⚠️ ATENÇÃO: Condições de vento moderado. Pista em observação.");
        } else {
            System.out.println("✅ Condições de vento favoráveis para pousos e decolagens.");
        }
        System.out.println("Temperatura atual: " + temperatura + "°C");
        System.out.println();
    }
}
