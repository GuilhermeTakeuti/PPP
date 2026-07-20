package lab6.questao2;

import java.util.List;

public class PedidoLoja extends PedidoTemplate {
    public PedidoLoja(List<Double> valoresItens) {
        super(valoresItens);
    }

    @Override
    protected void processarPagamento() {
        System.out.println("Processando pagamento na loja");
        System.out.println("Pagamento em dinheiro/cartão na loja");
        System.out.println("Pagamento confirmado!");
    }

    @Override
    protected void decidirEntrega() {
        System.out.println("Cliente retirará o pedido na loja");
        System.out.println("Sem taxa de entrega");
        System.out.println("Pedido disponível para retirada em 15 minutos");
    }

    @Override
    protected String getTipoPedido() {
        return "Pedido na Loja";
    }

    @Override
    protected boolean temEntrega() {
        return false;
    }
}
