package co.edu.poli.modelo.strategy;

public class PercentageDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double total) {
        return total * 0.90; // 10% de descuento
    }
}
