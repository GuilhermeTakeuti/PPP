package lab5.strategy.strategy;

public class PixPagamento implements PagamentoStrategy {
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento via PIX no valor de R$ " + String.format("%.2f", valor));
        System.out.println("QR Code gerado para pagamento");
        System.out.println("Pagamento via PIX realizado com sucesso!");
    }
}
