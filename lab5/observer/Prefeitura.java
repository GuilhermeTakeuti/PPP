package lab5.observer.observer;

public class Prefeitura implements ObservadorTempo {
    @Override
    public void atualizar(double temperatura, double umidade, double velocidadeVento) {
        System.out.println("=== PREFEITURA DE UBERLÂNDIA ===");
        if (umidade < 20) {
            System.out.println("⚠️ ALERTA DE DEFESA CIVIL: Umidade do ar está crítica (" + umidade + "%)");
            System.out.println("Recomenda-se: beber água, evitar atividades ao ar livre e umidificar ambientes");
        } else if (umidade < 30) {
            System.out.println("⚠️ ATENÇÃO: Umidade do ar está baixa (" + umidade + "%)");
            System.out.println("Recomenda-se hidratação e evitar exposição prolongada ao sol");
        } else {
            System.out.println("✅ Umidade do ar dentro dos padrões normais: " + umidade + "%");
        }
        System.out.println();
    }
}
