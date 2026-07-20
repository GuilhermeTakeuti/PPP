package lab4.decorator.decorator;

public abstract class Bebida {
    protected String descricao = "Bebida";

    public String getDescricao() {
        return descricao;
    }

    public abstract double calculaCusto();
}
