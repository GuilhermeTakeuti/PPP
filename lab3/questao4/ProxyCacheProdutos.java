package questao4;

import java.util.HashMap;
import java.util.Map;

/**
 * PROXY do padrão Proxy.
 *
 * - Objeto base (RealSubject): RepositorioProdutosReal
 * - Cliente: a classe Main (representando, por exemplo, o
 *   controlador de páginas de um e-commerce)
 * - Proxy: esta classe (ProxyCacheProdutos)
 *
 * O Proxy implementa a MESMA interface do objeto base
 * (RepositorioProdutos), então o cliente não percebe diferença ao
 * trocar um pelo outro. Toda chamada do cliente passa primeiro pelo
 * Proxy: se o produto já estiver no cache, o Proxy responde
 * imediatamente; caso contrário, ele delega a chamada para o objeto
 * base (RepositorioProdutosReal) e guarda o resultado em cache antes
 * de devolvê-lo ao cliente.
 */
public class ProxyCacheProdutos implements RepositorioProdutos {

    // Objeto base para o qual o Proxy delega as buscas "de verdade".
    private final RepositorioProdutosReal repositorioReal;

    // Cache em memória: código do produto -> produto já buscado.
    private final Map<String, Produto> cache = new HashMap<>();

    public ProxyCacheProdutos(RepositorioProdutosReal repositorioReal) {
        this.repositorioReal = repositorioReal;
    }

    @Override
    public Produto buscarProduto(String codigo) {
        if (cache.containsKey(codigo)) {
            System.out.println("[ProxyCacheProdutos] Produto " + codigo
                    + " encontrado no cache. Banco de dados NÃO foi acessado.");
            return cache.get(codigo);
        }

        System.out.println("[ProxyCacheProdutos] Produto " + codigo
                + " não está em cache. Delegando para o objeto base...");
        Produto produto = repositorioReal.buscarProduto(codigo);
        cache.put(codigo, produto);
        return produto;
    }
}
