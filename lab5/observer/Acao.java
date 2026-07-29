package lab5.observer.observer;

import java.util.ArrayList;
import java.util.List;

public class Acao {
    private String codigo;
    private double preco;
    private List<Investidor> investidores = new ArrayList<>();

    public Acao(String codigo, double precoInicial) {
        this.codigo = codigo;
        this.preco = precoInicial;
    }

    public void registrarInvestidor(Investidor investidor) {
        investidores.add(investidor);
        System.out.println("Investidor " + investidor.getNome() + " registrado na ação " + codigo);
    }

    public void removerInvestidor(Investidor investidor) {
        investidores.remove(investidor);
        System.out.println("Investidor " + investidor.getNome() + " removido da ação " + codigo);
    }

    public void notificarInvestidores() {
        for (Investidor investidor : investidores) {
            investidor.atualizarPreco(codigo, preco);
        }
    }

    public void setPreco(double preco) {
        this.preco = preco;
        System.out.println("\n--- Ação " + codigo + " atualizada para R$ " + String.format("%.2f", preco) + " ---");
        notificarInvestidores();
    }

    public String getCodigo() { return codigo; }
    public double getPreco() { return preco; }
}
