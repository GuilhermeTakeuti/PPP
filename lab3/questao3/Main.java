package questao3;

public class Main {
    public static void main(String[] args) {

        ProcessadorPagamento processadorPagamento =
                new GatewayPagamentoAdapter(new GatewayPagamentoExterno());

        LojaVirtual loja = new LojaVirtual(processadorPagamento);

        // Compra dentro do limite -> aprovada
        loja.finalizarCompra(150.90, "1234567812345678");

        System.out.println("-----------------------------");

        // Compra acima do limite simulado -> recusada
        loja.finalizarCompra(15000.00, "8765432187654321");
    }
}
