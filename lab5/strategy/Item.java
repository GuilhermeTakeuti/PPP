package lab5.strategy.strategy;

public class Item {
    private String nome;
    private double preco;
    private double peso;

    public Item(String nome, double preco, double peso) {
        this.nome = nome;
        this.preco = preco;
        this.peso = peso;
    }

    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public double getPeso() { return peso; }
}
