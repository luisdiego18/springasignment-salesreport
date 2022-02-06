package edu.wctc;

import edu.wctc.Interfaces.ShippingPolicy;

public class FlatRateShipping implements ShippingPolicy {
    @Override
    public void applyShipping(Sale sale) {
        sale.setShipping(sale.getAmount() * 0.20);
    }
}