package lab5.observer.observer;

public class Investidor {
    private String nome;
    private double limiteMinimo;
    private double limiteMaximo;
    private AcaoBroker broker;

    public Investidor(String nome, double limiteMinimo, double limiteMaximo, AcaoBroker broker) {
        this.nome = nome;
        this.limiteMinimo = limiteMinimo;
        this.limiteMaximo = limiteMaximo;
        this.broker = broker;
    }

    public String getNome() { return nome; }

    public void atualizarPreco(String codigoAcao, double preco) {
        System.out.println("Investidor " + nome + " foi notificado:");
        System.out.println("Ação " + codigoAcao + " está em R$ " + String.format("%.2f", preco));

        if (preco >= limiteMaximo) {
            System.out.println("⚠️ Preço máximo atingido! Vendendo ação " + codigoAcao);
            broker.vender(codigoAcao, preco);
        } else if (preco <= limiteMinimo) {
            System.out.println("⚠️ Preço mínimo atingido! Comprando ação " + codigoAcao);
            broker.comprar(codigoAcao, preco);
        } else {
            System.out.println("✅ Preço dentro dos limites estabelecidos.");
        }
        System.out.println();
    }
}
