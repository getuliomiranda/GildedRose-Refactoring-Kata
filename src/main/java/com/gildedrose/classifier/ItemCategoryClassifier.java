package com.gildedrose.classifier;

import com.gildedrose.Item;
import com.gildedrose.model.ItemCategory;

public interface ItemCategoryClassifier {

    boolean belongs(Item item);
    ItemCategory getCategory();

}
