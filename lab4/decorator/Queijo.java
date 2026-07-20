package lab4.decorator.decorator;

public class Queijo extends ToppingDecorator {
    private Pizza pizza;

    public Queijo(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescricao() {
        return pizza.getDescricao() + ", queijo";
    }

    @Override
    public double custo() {
        return pizza.custo() + 3.0;
    }
}
