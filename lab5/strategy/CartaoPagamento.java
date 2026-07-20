package lab5.strategy.strategy;

public class CartaoPagamento implements PagamentoStrategy {
    private String numeroCartao;

    public CartaoPagamento(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento via Cartão de Crédito no valor de R$ " + String.format("%.2f", valor));
        System.out.println("Cartão: " + numeroCartao);
        System.out.println("Pagamento com cartão realizado com sucesso!");
    }
}
