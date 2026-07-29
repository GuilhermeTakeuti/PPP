package lab5.strategy.strategy;

public class BoletoPagamento implements PagamentoStrategy {
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento via Boleto no valor de R$ " + String.format("%.2f", valor));
        System.out.println("Código de barras: 12345.67890.12345.67890.12345.67890.1");
        System.out.println("Boleto gerado com sucesso!");
    }
}
