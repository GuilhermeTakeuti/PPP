package lab4.decorator.decorator;

public class Pizzaria {
    public static void main(String[] args) {
        System.out.println("=== PIZZARIA ===\n");

        Pizza marguerita = new Queijo(new Tomate(new MassaFinaPizza()));
        System.out.println("Pizza: " + marguerita.getDescricao());
        System.out.println("Custo: R$ " + String.format("%.2f", marguerita.custo()));
        System.out.println();

        Pizza portuguesa = new Queijo(new Ovo(new Tomate(new MassaEspessaPizza())));
        System.out.println("Pizza: " + portuguesa.getDescricao());
        System.out.println("Custo: R$ " + String.format("%.2f", portuguesa.custo()));
        System.out.println();

        Pizza personalizada = new Queijo(new Ovo(new MassaFinaPizza()));
        System.out.println("Pizza: " + personalizada.getDescricao());
        System.out.println("Custo: R$ " + String.format("%.2f", personalizada.custo()));
    }
}
