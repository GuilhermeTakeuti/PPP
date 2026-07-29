package lab5.strategy.strategy;

public class FreteSedex implements FreteStrategy {
    private static final double TAXA_POR_KM = 1.5;
    private static final double TAXA_POR_KG = 2.0;

    @Override
    public double calcularFrete(double peso, double distancia) {
        return (peso * TAXA_POR_KG) + (distancia * TAXA_POR_KM);
    }
}
