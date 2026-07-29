package lab4.decorator.decorator;

public class Decaf extends Bebida {
    public Decaf() {
        descricao = "Café Descafeinado";
    }

    @Override
    public double calculaCusto() {
        return 6.0;
    }
}
