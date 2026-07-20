package lab5.strategy.strategy;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== STRATEGY - PAGAMENTOS E FRETE ===\n");

        Item notebook = new Item("Notebook", 3500.00, 2.5);
        Item mouse = new Item("Mouse", 80.00, 0.2);
        Item teclado = new Item("Teclado", 150.00, 0.5);

        CarrinhoCompras carrinho = new CarrinhoCompras();
        carrinho.adicionarItem(notebook);
        carrinho.adicionarItem(mouse);
        carrinho.adicionarItem(teclado);
        carrinho.setDistanciaEntrega(15.0);

        System.out.println("\n--- Pagamento com PIX e Frete Sedex ---");
        carrinho.setPagamentoStrategy(new PixPagamento());
        carrinho.setFreteStrategy(new FreteSedex());
        carrinho.realizaPagamento();

        System.out.println("\n--- Pagamento com Cartão e Frete Normal ---");
        carrinho.setPagamentoStrategy(new CartaoPagamento("1234-5678-9012-3456"));
        carrinho.setFreteStrategy(new FreteNormal());
        carrinho.realizaPagamento();

        System.out.println("\n--- Pagamento com Boleto ---");
        carrinho.setPagamentoStrategy(new BoletoPagamento());
        carrinho.setFreteStrategy(new FreteNormal());
        carrinho.realizaPagamento();
    }
}
