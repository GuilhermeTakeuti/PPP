package lab7.questao1;

public interface VeiculoVisitor {
    void visitar(Carro carro);
    void visitar(Onibus onibus);
    void visitar(Bicicleta bicicleta);
}
