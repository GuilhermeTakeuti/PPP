package lab4.decorator.decorator;

public class MassaFinaPizza extends Pizza {
    public MassaFinaPizza() {
        descricao = "Massa fina";
    }

    @Override
    public double custo() {
        return 15.0;
    }
}
