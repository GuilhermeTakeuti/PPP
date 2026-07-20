package questao2;

/**
 * Adapter que permite usar a CalculadoraBinaria (Adaptee) através
 * da interface CalculadoraDecimal (Target), esperada pelo cliente.
 *
 * Observação: por depender da conversão para String binária via
 * Integer.toBinaryString/parseInt, este adapter foi projetado para
 * trabalhar com números inteiros não-negativos nas operações somar()
 * e subtrair() (onde o resultado também deve ser não-negativo).
 * A operação multiplicar() não existe na CalculadoraBinaria, então o
 * Adapter a implementa reaproveitando somente o método somar() já
 * disponível no objeto adaptado (soma sucessiva), tratando o sinal
 * separadamente para funcionar também com números negativos.
 */
public class CalculadoraAdapter implements CalculadoraDecimal {

    private final CalculadoraBinaria calculadoraBinaria;

    public CalculadoraAdapter(CalculadoraBinaria calculadoraBinaria) {
        this.calculadoraBinaria = calculadoraBinaria;
    }

    @Override
    public int somar(int a, int b) {
        String binA = Integer.toBinaryString(a);
        String binB = Integer.toBinaryString(b);
        String resultadoBinario = calculadoraBinaria.somar(binA, binB);
        return Integer.parseInt(resultadoBinario, 2);
    }

    @Override
    public int subtrair(int a, int b) {
        String binA = Integer.toBinaryString(a);
        String binB = Integer.toBinaryString(b);
        String resultadoBinario = calculadoraBinaria.subtrair(binA, binB);
        return Integer.parseInt(resultadoBinario, 2);
    }

    @Override
    public int multiplicar(int a, int b) {
        int resultado = 0;
        int vezes = Math.abs(b);

        // Multiplicação implementada a partir de somas sucessivas,
        // reutilizando o método somar() já adaptado acima.
        for (int i = 0; i < vezes; i++) {
            resultado = somar(resultado, Math.abs(a));
        }

        boolean sinaisDiferentes = (a < 0) ^ (b < 0);
        return sinaisDiferentes ? -resultado : resultado;
    }
}
