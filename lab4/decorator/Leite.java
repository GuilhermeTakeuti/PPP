package lab4.decorator.decorator;

public class Leite extends CondimentoDecorator {
    private Bebida bebida;

    public Leite(Bebida bebida) {
        this.bebida = bebida;
    }

    @Override
    public String getDescricao() {
        return bebida.getDescricao() + ", com leite";
    }

    @Override
    public double calculaCusto() {
        return bebida.calculaCusto() + 1.5;
    }
}
