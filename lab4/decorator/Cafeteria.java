package lab4.decorator.decorator;

public class Cafeteria {
    public static void main(String[] args) {
        System.out.println("=== CAFETERIA ===\n");

        Bebida bebida1 = new Chocolate(new Leite(new Expresso()));
        System.out.println(bebida1.getDescricao());
        System.out.println("Custo: R$ " + String.format("%.2f", bebida1.calculaCusto()));
        System.out.println();

        Bebida bebida2 = new Canela(new Decaf());
        System.out.println(bebida2.getDescricao());
        System.out.println("Custo: R$ " + String.format("%.2f", bebida2.calculaCusto()));
        System.out.println();

        Bebida bebida3 = new Chocolate(new Canela(new Leite(new Expresso())));
        System.out.println(bebida3.getDescricao());
        System.out.println("Custo: R$ " + String.format("%.2f", bebida3.calculaCusto()));
    }
}
