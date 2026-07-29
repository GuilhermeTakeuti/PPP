package lab4.decorator.decorator;

public class Canela extends CondimentoDecorator {
    private Bebida bebida;

    public Canela(Bebida bebida) {
        this.bebida = bebida;
    }

    @Override
    public String getDescricao() {
        return bebida.getDescricao() + ", com canela";
    }

    @Override
    public double calculaCusto() {
        return bebida.calculaCusto() + 1.0;
    }
}
