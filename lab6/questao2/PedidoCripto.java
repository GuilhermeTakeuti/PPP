package lab6.questao2;

import java.util.List;

public class PedidoCripto extends PedidoTemplate {
    private String enderecoCarteira;

    public PedidoCripto(List<Double> valoresItens, String enderecoCarteira) {
        super(valoresItens);
        this.enderecoCarteira = enderecoCarteira;
    }

    @Override
    protected void processarPagamento() {
        System.out.println("Processando pagamento via criptomoedas");
        System.out.println("Carteira: " + enderecoCarteira);
        System.out.println("Confirmando transação na blockchain...");
        System.out.println("Pagamento em criptomoedas confirmado!");
    }

    @Override
    protected void decidirEntrega() {
        System.out.println("Pedido será entregue no endereço cadastrado");
        System.out.println("Taxa de entrega: R$ 15,00 (taxa diferenciada)");
        System.out.println("Prazo de entrega: 30 minutos");
    }

    @Override
    protected String getTipoPedido() {
        return "Pedido com Criptomoedas";
    }
}
