package questao3;

/**
 * PROBLEMA PROPOSTO (Questão 3):
 * Uma loja virtual quer processar pagamentos com cartão de crédito
 * usando um serviço de pagamentos de terceiros já existente no mercado
 * (por exemplo, um gateway estilo PayPal/Stripe). Esse gateway, porém,
 * possui uma interface própria, incompatível com a que o sistema da
 * loja foi projetado para usar (valores em centavos, moeda como
 * String, retorno como texto de status). O padrão Adapter resolve
 * essa incompatibilidade sem alterar nem o gateway externo, nem o
 * sistema da loja.
 *
 * Esta classe representa o gateway externo (Adaptee) — já pronto,
 * não pode ser modificado.
 */
public class GatewayPagamentoExterno {

    /**
     * Processa uma transação.
     * @param valorEmCentavos valor da transação em centavos
     * @param moeda           código da moeda, ex: "BRL", "USD"
     * @param numeroCartao    número do cartão de crédito
     * @return uma String de status: "APPROVED" ou "DECLINED"
     */
    public String processarTransacao(long valorEmCentavos, String moeda, String numeroCartao) {
        System.out.println(String.format(
                "[GatewayPagamentoExterno] Processando %d centavos (%s) no cartão %s...",
                valorEmCentavos, moeda, mascarar(numeroCartao)));

        // Simulação simples: valores muito altos são recusados.
        if (valorEmCentavos > 1_000_000L) {
            return "DECLINED";
        }
        return "APPROVED";
    }

    private String mascarar(String numeroCartao) {
        if (numeroCartao.length() < 4) {
            return numeroCartao;
        }
        return "**** **** **** " + numeroCartao.substring(numeroCartao.length() - 4);
    }
}
