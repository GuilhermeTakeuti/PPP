package lab5.observer.observer;

public class MainFinanceiro {
    public static void main(String[] args) {
        System.out.println("=== OBSERVER - MERCADO FINANCEIRO ===\n");

        AcaoBroker broker = new AcaoBroker();

        Acao acaoPetrobras = new Acao("PETR4", 30.00);
        Acao acaoVale = new Acao("VALE3", 60.00);
        Acao acaoItau = new Acao("ITUB4", 35.00);

        broker.registrarAcao(acaoPetrobras);
        broker.registrarAcao(acaoVale);
        broker.registrarAcao(acaoItau);

        Investidor investidor1 = new Investidor("João Silva", 28.00, 40.00, broker);
        Investidor investidor2 = new Investidor("Maria Santos", 55.00, 70.00, broker);
        Investidor investidor3 = new Investidor("Carlos Oliveira", 32.00, 45.00, broker);

        System.out.println("\n=== REGISTRANDO INVESTIDORES ===");
        acaoPetrobras.registrarInvestidor(investidor1);
        acaoPetrobras.registrarInvestidor(investidor3);
        acaoVale.registrarInvestidor(investidor2);
        acaoItau.registrarInvestidor(investidor3);

        System.out.println("\n=== SIMULANDO MERCADO ===");
        
        acaoPetrobras.setPreco(32.50);
        acaoPetrobras.setPreco(38.00);
        acaoPetrobras.setPreco(42.00);

        acaoVale.setPreco(58.00);
        acaoVale.setPreco(65.00);
        acaoVale.setPreco(72.00);

        acaoItau.setPreco(36.00);
        acaoItau.setPreco(33.00);
        acaoItau.setPreco(30.00);
    }
}
