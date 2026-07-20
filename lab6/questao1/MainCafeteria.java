package lab6.questao1;

public class MainCafeteria {
    public static void main(String[] args) {
        System.out.println("=== TEMPLATE METHOD - CAFETERIA ===\n");

        BebidaTemplate cafe = new Cafe();
        cafe.prepararBebida();

        BebidaTemplate capuccino = new Capuccino();
        capuccino.prepararBebida();

        BebidaTemplate cha = new Cha();
        cha.prepararBebida();
    }
}
