package lab4.decorator.decorator;

public class Expresso extends Bebida {
    public Expresso() {
        descricao = "Café Expresso";
    }

    @Override
    public double calculaCusto() {
        return 5.0;
    }
}
