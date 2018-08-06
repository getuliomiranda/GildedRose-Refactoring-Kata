package com.gildedrose.classifier;

import com.gildedrose.Item;
import com.gildedrose.model.ItemCategory;

import java.util.Arrays;
import java.util.Optional;

public class LegendaryItemCategoryClassifier implements ItemCategoryClassifier {

    private static final String[] legendaries = new String[]{"Sulfuras, Hand of Ragnaros"};

    @Override
    public boolean belongs(Item item) {
        return Arrays.stream(legendaries).anyMatch(l -> l.equals(Optional.ofNullable(item).orElseThrow(IllegalArgumentException::new).getName()));
    }

    @Override
    public ItemCategory getCategory() {
        return ItemCategory.LEGENDARY;
    }


}
