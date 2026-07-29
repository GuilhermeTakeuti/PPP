package lab6.questao2;

import java.util.List;

public abstract class PedidoTemplate {
    protected List<Double> valoresItens;
    protected double total;

    public PedidoTemplate(List<Double> valoresItens) {
        this.valoresItens = valoresItens;
        this.total = calcularTotal();
    }

    public final void processarPedido() {
        System.out.println("\n=== PROCESSANDO PEDIDO ===");
        System.out.println("Tipo: " + getTipoPedido());
        System.out.println("Total do pedido: R$ " + String.format("%.2f", total));
        
        processarPagamento();
        decidirEntrega();
        
        System.out.println("=== PEDIDO PROCESSADO COM SUCESSO ===\n");
    }

    protected double calcularTotal() {
        double soma = 0.0;
        for (Double valor : valoresItens) {
            soma += valor;
        }
        return soma;
    }

    protected abstract void processarPagamento();
    protected abstract void decidirEntrega();
    protected abstract String getTipoPedido();

    protected boolean temEntrega() {
        return true;
    }
}
