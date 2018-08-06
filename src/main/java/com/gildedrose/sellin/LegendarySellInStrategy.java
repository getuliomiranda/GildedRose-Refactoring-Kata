package com.gildedrose.sellin;

import com.gildedrose.Item;
import com.gildedrose.model.ItemCategory;

public class LegendarySellInStrategy implements SellInStrategy {
    @Override
    public boolean accepts(ItemCategory itemCategory) {
        return itemCategory == ItemCategory.LEGENDARY;
    }

    @Override
    public int apply(Item item) {
        return 0;
    }
}
