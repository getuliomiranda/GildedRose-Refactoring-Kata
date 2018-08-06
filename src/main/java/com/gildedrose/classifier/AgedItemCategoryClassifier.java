package com.gildedrose.classifier;

import com.gildedrose.Item;
import com.gildedrose.model.ItemCategory;

import java.util.Optional;

public class AgedItemCategoryClassifier implements ItemCategoryClassifier {
    @Override
    public boolean belongs(Item item) {
        return Optional.ofNullable(item).orElseThrow(IllegalArgumentException::new).getName().contains("Aged");
    }

    @Override
    public ItemCategory getCategory() {
        return ItemCategory.AGED;
    }
}
