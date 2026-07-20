package lab5.strategy.strategy;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompras {
    private List<Item> itens = new ArrayList<>();
    private PagamentoStrategy pagamentoStrategy;
    private FreteStrategy freteStrategy;
    private double distanciaEntrega = 10.0;

    public void adicionarItem(Item item) {
        itens.add(item);
        System.out.println("Item adicionado: " + item.getNome() + " - R$ " + String.format("%.2f", item.getPreco()));
    }

    public void removerItem(Item item) {
        itens.remove(item);
        System.out.println("Item removido: " + item.getNome());
    }

    public double calculaTotal() {
        double total = 0.0;
        for (Item item : itens) {
            total += item.getPreco();
        }
        return total;
    }

    public double calculaPesoTotal() {
        double pesoTotal = 0.0;
        for (Item item : itens) {
            pesoTotal += item.getPeso();
        }
        return pesoTotal;
    }

    public double calculaFrete() {
        if (freteStrategy == null) {
            System.out.println("Estratégia de frete não definida!");
            return 0.0;
        }
        double pesoTotal = calculaPesoTotal();
        return freteStrategy.calcularFrete(pesoTotal, distanciaEntrega);
    }

    public void realizaPagamento() {
        if (pagamentoStrategy == null) {
            System.out.println("Estratégia de pagamento não definida!");
            return;
        }

        double total = calculaTotal();
        double frete = calculaFrete();
        double totalComFrete = total + frete;

        System.out.println("\n=== Resumo do Pedido ===");
        System.out.println("Total dos itens: R$ " + String.format("%.2f", total));
        System.out.println("Frete: R$ " + String.format("%.2f", frete));
        System.out.println("Total com frete: R$ " + String.format("%.2f", totalComFrete));
        System.out.println("======================");

        pagamentoStrategy.pagar(totalComFrete);
    }

    public void setPagamentoStrategy(PagamentoStrategy pagamentoStrategy) {
        this.pagamentoStrategy = pagamentoStrategy;
    }

    public void setFreteStrategy(FreteStrategy freteStrategy) {
        this.freteStrategy = freteStrategy;
    }

    public void setDistanciaEntrega(double distancia) {
        this.distanciaEntrega = distancia;
    }
}
