package lab7.questao1;

public class ImprimirVisitor implements VeiculoVisitor {
    @Override
    public void visitar(Carro carro) {
        System.out.println("CARRO:");
        System.out.println("  Cor: " + carro.getCor());
        System.out.println("  Marca: " + carro.getMarca());
        System.out.println("  Modelo: " + carro.getModelo());
    }

    @Override
    public void visitar(Onibus onibus) {
        System.out.println("ÔNIBUS:");
        System.out.println("  Quantidade de lugares: " + onibus.getQuantidadeLugares());
        System.out.println("  Ano de fabricação: " + onibus.getAnoFabricacao());
    }

    @Override
    public void visitar(Bicicleta bicicleta) {
        System.out.println("BICICLETA:");
        System.out.println("  Cor: " + bicicleta.getCor());
    }
}
