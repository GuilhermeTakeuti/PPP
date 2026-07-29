package lab4.decorator.decorator;

public class MassaEspessaPizza extends Pizza {
    public MassaEspessaPizza() {
        descricao = "Massa espessa";
    }

    @Override
    public double custo() {
        return 18.0;
    }
}
