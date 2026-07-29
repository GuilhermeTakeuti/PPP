package lab5.observer.observer;

public class MainTempo {
    public static void main(String[] args) {
        System.out.println("=== OBSERVER - ESTAÇÃO DO TEMPO ===\n");

        CentralEstacaoTempo estacao = new CentralEstacaoTempo();

        Prefeitura prefeitura = new Prefeitura();
        Aeroporto aeroporto = new Aeroporto();

        estacao.registrarObservador(prefeitura);
        estacao.registrarObservador(aeroporto);

        System.out.println("\n=== PRIMEIRA MEDIÇÃO ===");
        estacao.setMedicoes(28.5, 18.0, 15.0);

        System.out.println("\n=== SEGUNDA MEDIÇÃO ===");
        estacao.setMedicoes(32.0, 12.0, 45.0);

        System.out.println("\n=== TERCEIRA MEDIÇÃO ===");
        estacao.setMedicoes(25.0, 55.0, 8.0);
    }
}
