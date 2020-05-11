package com.karolmikolajczuk;

import java.math.BigDecimal;

public interface Sellable {
    boolean sell(Human seller, Human buyer, BigDecimal price);
}
