package lab4.decorator.decorator;

public class Tomate extends ToppingDecorator {
    private Pizza pizza;

    public Tomate(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescricao() {
        return pizza.getDescricao() + ", tomate";
    }

    @Override
    public double custo() {
        return pizza.custo() + 2.5;
    }
}
