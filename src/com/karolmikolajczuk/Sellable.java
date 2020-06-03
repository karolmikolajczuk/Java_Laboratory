package com.karolmikolajczuk;

import java.math.BigDecimal;

public interface Sellable {
    // add index parameter cause we have garage now
    boolean sell(Human seller, int index, Human buyer, BigDecimal price);

    boolean sell(Human seller, Human buyer, BigDecimal price);
}
