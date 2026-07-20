package lab5.observer.observer;

import java.util.HashMap;
import java.util.Map;

public class AcaoBroker {
    private Map<String, Acao> acoes = new HashMap<>();

    public void registrarAcao(Acao acao) {
        acoes.put(acao.getCodigo(), acao);
        System.out.println("Ação " + acao.getCodigo() + " registrada na corretora");
    }

    public void comprar(String codigoAcao, double preco) {
        Acao acao = acoes.get(codigoAcao);
        if (acao != null) {
            System.out.println("💼 BROKER: Comprando ação " + codigoAcao + " por R$ " + String.format("%.2f", preco));
            System.out.println("💼 Transação de compra executada com sucesso!");
        } else {
            System.out.println("❌ Ação " + codigoAcao + " não encontrada");
        }
    }

    public void vender(String codigoAcao, double preco) {
        Acao acao = acoes.get(codigoAcao);
        if (acao != null) {
            System.out.println("💼 BROKER: Vendendo ação " + codigoAcao + " por R$ " + String.format("%.2f", preco));
            System.out.println("💼 Transação de venda executada com sucesso!");
        } else {
            System.out.println("❌ Ação " + codigoAcao + " não encontrada");
        }
    }
}
