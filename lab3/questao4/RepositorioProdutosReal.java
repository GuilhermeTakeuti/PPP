package questao4;

/**
 * OBJETO BASE do padrão Proxy.
 * Simula um repositório real, que consulta um banco de dados
 * (ou serviço externo) para buscar um produto. Essa operação é
 * propositalmente lenta (Thread.sleep) para simular o custo real
 * de uma consulta em disco/rede.
 *
 * O cliente NUNCA deve acessar esta classe diretamente: todo
 * acesso deve passar pelo ProxyCacheProdutos.
 */
public class RepositorioProdutosReal implements RepositorioProdutos {

    @Override
    public Produto buscarProduto(String codigo) {
        System.out.println("[RepositorioProdutosReal] Consultando banco de dados para o código "
                + codigo + " (operação lenta)...");
        try {
            // Simula latência de uma consulta real ao banco de dados.
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Dados "fictícios" retornados pelo banco de dados.
        return new Produto(codigo, "Produto " + codigo, 99.90);
    }
}
