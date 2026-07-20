package lab5.strategy.strategy;

public class FreteNormal implements FreteStrategy {
    private static final double TAXA_POR_KM = 0.8;
    private static final double TAXA_POR_KG = 1.0;

    @Override
    public double calcularFrete(double peso, double distancia) {
        return (peso * TAXA_POR_KG) + (distancia * TAXA_POR_KM);
    }
}
