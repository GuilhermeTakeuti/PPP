package lab4.decorator.decorator;

public class Chocolate extends CondimentoDecorator {
    private Bebida bebida;

    public Chocolate(Bebida bebida) {
        this.bebida = bebida;
    }

    @Override
    public String getDescricao() {
        return bebida.getDescricao() + ", com chocolate";
    }

    @Override
    public double calculaCusto() {
        return bebida.calculaCusto() + 2.0;
    }
}
