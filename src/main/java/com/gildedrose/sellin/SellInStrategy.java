package com.gildedrose.sellin;

import com.gildedrose.Item;
import com.gildedrose.model.ItemCategory;

public interface SellInStrategy {

    boolean accepts(ItemCategory itemCategory);
    int apply(Item item);

}
