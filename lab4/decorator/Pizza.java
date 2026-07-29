package lab4.decorator.decorator;

public abstract class Pizza {
    protected String descricao = "Pizza";

    public String getDescricao() {
        return descricao;
    }

    public abstract double custo();
}
