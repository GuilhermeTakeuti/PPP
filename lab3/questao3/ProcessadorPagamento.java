package questao3;

/**
 * Interface alvo (Target): é o que o sistema da loja virtual
 * (cliente) espera usar para cobrar seus clientes, trabalhando
 * com reais (double) e retornando um boolean simples de
 * aprovado/recusado.
 */
public interface ProcessadorPagamento {
    boolean pagar(double valorEmReais, String numeroCartao);
}
