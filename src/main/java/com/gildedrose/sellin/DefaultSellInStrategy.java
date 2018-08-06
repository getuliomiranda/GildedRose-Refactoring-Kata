package com.gildedrose.sellin;

import com.gildedrose.Item;
import com.gildedrose.model.ItemCategory;

import java.util.Arrays;

public class DefaultSellInStrategy implements SellInStrategy {

    private static final ItemCategory[] SUPPORTED_CATEGORIES = {ItemCategory.PASS, ItemCategory.AGED, ItemCategory.CONJURED, ItemCategory.NORMAL};

    @Override
    public boolean accepts(ItemCategory itemCategory) {
        return Arrays.stream(SUPPORTED_CATEGORIES).anyMatch(c -> c == itemCategory);
    }

    @Override
    public int apply(Item item) {
        return item.getSellIn() - 1;
    }
}
