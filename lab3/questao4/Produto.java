package questao4;

/**
 * Classe simples de modelo, usada apenas para representar
 * o dado retornado pelo repositório de produtos.
 */
public class Produto {

    private final String codigo;
    private final String nome;
    private final double preco;

    public Produto(String codigo, String nome, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{codigo='" + codigo + "', nome='" + nome + "', preco=" + preco + "}";
    }
}
