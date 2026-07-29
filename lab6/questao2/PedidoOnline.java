package lab6.questao2;

import java.util.List;

public class PedidoOnline extends PedidoTemplate {
    private String enderecoEntrega;

    public PedidoOnline(List<Double> valoresItens, String enderecoEntrega) {
        super(valoresItens);
        this.enderecoEntrega = enderecoEntrega;
    }

    @Override
    protected void processarPagamento() {
        System.out.println("Processando pagamento online via cartão de crédito");
        System.out.println("Pagamento aprovado!");
    }

    @Override
    protected void decidirEntrega() {
        System.out.println("Pedido será entregue em: " + enderecoEntrega);
        System.out.println("Taxa de entrega: R$ 10,00");
        System.out.println("Prazo de entrega: 45 minutos");
    }

    @Override
    protected String getTipoPedido() {
        return "Pedido Online";
    }
}
