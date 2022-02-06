package edu.wctc.Interfaces;

import edu.wctc.Sale;

public interface ShippingPolicy {
    void applyShipping(Sale sale);
}