package questao2;

public class Main {
    public static void main(String[] args) {

        // Cliente utiliza apenas a interface CalculadoraDecimal,
        // sem saber que, internamente, quem faz o trabalho é uma
        // CalculadoraBinaria.
        CalculadoraDecimal calculadora = new CalculadoraAdapter(new CalculadoraBinaria());

        int a = 12;
        int b = 5;

        System.out.println("a = " + a + ", b = " + b);
        System.out.println("Soma: " + calculadora.somar(a, b));
        System.out.println("Subtração: " + calculadora.subtrair(a, b));
        System.out.println("Multiplicação: " + calculadora.multiplicar(a, b));

        System.out.println("-----------------------------");

        int c = -4;
        int d = 6;
        System.out.println("c = " + c + ", d = " + d);
        System.out.println("Multiplicação com número negativo: " + calculadora.multiplicar(c, d));
    }
}
