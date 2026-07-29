package questao3;

/**
 * Cliente do padrão Adapter. A loja virtual conhece apenas a
 * interface ProcessadorPagamento, sem se importar com qual gateway
 * de pagamento está sendo usado por trás dela.
 */
public class LojaVirtual {

    private final ProcessadorPagamento processadorPagamento;

    public LojaVirtual(ProcessadorPagamento processadorPagamento) {
        this.processadorPagamento = processadorPagamento;
    }

    public void finalizarCompra(double valorEmReais, String numeroCartao) {
        System.out.println("Finalizando compra de R$ " + valorEmReais + "...");
        boolean aprovado = processadorPagamento.pagar(valorEmReais, numeroCartao);

        if (aprovado) {
            System.out.println("Pagamento aprovado! Pedido confirmado.");
        } else {
            System.out.println("Pagamento recusado. Tente outro cartão.");
        }
    }
}
