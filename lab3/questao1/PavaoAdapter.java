package questao1;

/**
 * Adapter que converte a interface de Pavao (Adaptee) para a
 * interface Ave (Target), esperada pelo cliente.
 *
 * Como o Pavão não é capaz de voar, o método voar() apenas
 * informa essa limitação, em vez de delegar para um método inexistente.
 */
public class PavaoAdapter implements Ave {

    private final Pavao pavao;

    public PavaoAdapter(Pavao pavao) {
        this.pavao = pavao;
    }

    @Override
    public void voar() {
        System.out.println("O pavão não é capaz de voar.");
    }

    @Override
    public void emitirSom() {
        pavao.cantar();
    }
}
