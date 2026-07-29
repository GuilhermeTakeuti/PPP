package lab6.questao2;

import java.util.Arrays;
import java.util.List;

/*
 * QUESTÃO 2B - DIFERENÇA ENTRE TEMPLATE METHOD E DECORATOR
 * 
 * TEMPLATE METHOD: Padrão comportamental que define o esqueleto de um algoritmo,
 * delegando alguns passos para as subclasses. Usa herança. Alteração em tempo de compilação.
 * 
 * DECORATOR: Padrão estrutural que adiciona responsabilidades a objetos dinamicamente.
 * Usa composição. Alteração em tempo de execução.
 */

public class MainPedido {
    public static void main(String[] args) {
        System.out.println("=== TEMPLATE METHOD - PEDIDOS ===");

        List<Double> itens = Arrays.asList(25.90, 14.50, 32.00, 8.75);

        PedidoTemplate pedidoOnline = new PedidoOnline(itens, 
            "Rua das Flores, 123 - Uberlândia/MG");
        pedidoOnline.processarPedido();

        PedidoTemplate pedidoLoja = new PedidoLoja(itens);
        pedidoLoja.processarPedido();

        PedidoTemplate pedidoCripto = new PedidoCripto(itens, 
            "0x7F4e2B3C9A1D5E8F6G2H3J4K5L6M7N8P9Q0R1S2T");
        pedidoCripto.processarPedido();
    }
}
