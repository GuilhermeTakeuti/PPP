package questao3;

/**
 * Adapter que converte a interface do GatewayPagamentoExterno
 * (Adaptee) para a interface ProcessadorPagamento (Target),
 * esperada pelo sistema da loja virtual (cliente).
 *
 * Faz a "tradução" entre os dois mundos:
 * - converte reais (double) para centavos (long);
 * - fixa a moeda como "BRL";
 * - converte a String de status ("APPROVED"/"DECLINED") em boolean.
 */
public class GatewayPagamentoAdapter implements ProcessadorPagamento {

    private static final String MOEDA_PADRAO = "BRL";

    private final GatewayPagamentoExterno gateway;

    public GatewayPagamentoAdapter(GatewayPagamentoExterno gateway) {
        this.gateway = gateway;
    }

    @Override
    public boolean pagar(double valorEmReais, String numeroCartao) {
        long valorEmCentavos = Math.round(valorEmReais * 100);

        String status = gateway.processarTransacao(valorEmCentavos, MOEDA_PADRAO, numeroCartao);

        return "APPROVED".equals(status);
    }
}
