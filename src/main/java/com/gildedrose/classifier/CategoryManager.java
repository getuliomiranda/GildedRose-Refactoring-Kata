package com.gildedrose.classifier;

import com.gildedrose.Item;
import com.gildedrose.model.ItemCategory;

import java.util.Arrays;
import java.util.List;

public class CategoryManager {

    private List<ItemCategoryClassifier> categoryIdentifiers;

    public CategoryManager(List<ItemCategoryClassifier> categoryIdentifiers) {
        this.categoryIdentifiers = categoryIdentifiers;
    }

    public CategoryManager() {
        categoryIdentifiers = Arrays.asList(
                new AgedItemCategoryClassifier(),
                new ConjuredItemCategoryClassifier(),
                new LegendaryItemCategoryClassifier(),
                new PassItemCategoryClassifier()
        );
    }

    public ItemCategory identify(Item item) {
        return categoryIdentifiers.stream()
                .filter(categoryIdentifier -> categoryIdentifier.belongs(item))
                .findAny()
                .map(categoryIdentifier -> categoryIdentifier.getCategory())
                .orElse(ItemCategory.NORMAL);
    }
}
