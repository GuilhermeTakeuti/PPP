package lab4.decorator.decorator;

public class Ovo extends ToppingDecorator {
    private Pizza pizza;

    public Ovo(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescricao() {
        return pizza.getDescricao() + ", ovo";
    }

    @Override
    public double custo() {
        return pizza.custo() + 2.0;
    }
}
