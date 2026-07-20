package lab7.questao1;

import java.util.ArrayList;
import java.util.List;

public class MainVeiculo {
    public static void main(String[] args) {
        System.out.println("=== VISITOR - VEÍCULOS ===\n");

        List<Veiculo> veiculos = new ArrayList<>();
        veiculos.add(new Carro("Vermelho", "Fiat", "Uno"));
        veiculos.add(new Carro("Prata", "Honda", "Civic"));
        veiculos.add(new Onibus(45, 2020));
        veiculos.add(new Onibus(30, 2018));
        veiculos.add(new Bicicleta("Azul"));
        veiculos.add(new Bicicleta("Verde"));

        ImprimirVisitor imprimirVisitor = new ImprimirVisitor();
        MensagemVisitor mensagemVisitor = new MensagemVisitor();

        System.out.println("=== IMPRIMINDO DADOS DOS VEÍCULOS ===\n");
        for (Veiculo veiculo : veiculos) {
            veiculo.aceitar(imprimirVisitor);
            System.out.println();
        }

        System.out.println("=== ENVIANDO MENSAGENS PARA DONOS ===\n");
        for (Veiculo veiculo : veiculos) {
            veiculo.aceitar(mensagemVisitor);
            System.out.println();
        }
    }
}
