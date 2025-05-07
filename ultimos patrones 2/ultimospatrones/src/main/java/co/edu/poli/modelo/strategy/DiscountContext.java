package co.edu.poli.modelo.strategy;

public class DiscountContext {
    private DiscountStrategy strategy;

    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public double executeStrategy(double total) {
        if (strategy == null) {
            throw new IllegalStateException("No se ha definido una estrategia de descuento.");
        }
        return strategy.applyDiscount(total);
    }
}
