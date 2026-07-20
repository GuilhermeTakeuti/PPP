package questao4;

/**
 * PROBLEMA PROPOSTO (Questão 4):
 * Um sistema de e-commerce consulta o catálogo de produtos em um
 * banco de dados. Essa consulta é "cara" (demorada), e vários
 * pontos do sistema pedem repetidamente o mesmo produto em um curto
 * intervalo de tempo (ex.: exibir o mesmo produto em várias seções
 * da página). Um Proxy de cache pode interceptar essas chamadas:
 * se o produto já foi buscado recentemente, o Proxy devolve o valor
 * guardado em memória, sem acionar novamente o banco de dados real.
 *
 * Interface comum ao objeto base (RepositorioProdutosReal) e
 * ao Proxy (ProxyCacheProdutos), garantindo que o cliente use
 * exatamente a mesma interface para os dois.
 */
public interface RepositorioProdutos {
    Produto buscarProduto(String codigo);
}
