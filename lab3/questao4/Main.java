package questao4;

public class Main {
    public static void main(String[] args) {

        // O cliente conhece apenas a interface RepositorioProdutos.
        // Ele "conversa" com o Proxy, nunca diretamente com o
        // RepositorioProdutosReal.
        RepositorioProdutos repositorio = new ProxyCacheProdutos(new RepositorioProdutosReal());

        long inicio1 = System.currentTimeMillis();
        Produto produto1 = repositorio.buscarProduto("P001");
        long fim1 = System.currentTimeMillis();
        System.out.println("Resultado: " + produto1);
        System.out.println("Tempo gasto: " + (fim1 - inicio1) + " ms");

        System.out.println("-----------------------------");

        // Segunda busca pelo MESMO produto: deve vir do cache e ser
        // praticamente instantânea, sem acessar o objeto base.
        long inicio2 = System.currentTimeMillis();
        Produto produto2 = repositorio.buscarProduto("P001");
        long fim2 = System.currentTimeMillis();
        System.out.println("Resultado: " + produto2);
        System.out.println("Tempo gasto: " + (fim2 - inicio2) + " ms");

        System.out.println("-----------------------------");

        // Busca por um produto diferente: não está em cache,
        // então o Proxy precisa acessar o objeto base novamente.
        long inicio3 = System.currentTimeMillis();
        Produto produto3 = repositorio.buscarProduto("P002");
        long fim3 = System.currentTimeMillis();
        System.out.println("Resultado: " + produto3);
        System.out.println("Tempo gasto: " + (fim3 - inicio3) + " ms");
    }
}
