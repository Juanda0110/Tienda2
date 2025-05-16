package co.edu.poli.modelo.strategy;

public class FixedDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double total) {
        return total - 10;
    }
}
