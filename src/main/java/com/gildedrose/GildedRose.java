package com.gildedrose;

import com.gildedrose.classifier.CategoryManager;
import com.gildedrose.model.ItemCategory;

public class GildedRose {

    private Item[] items;
    private CategoryManager categoryManager;

    public GildedRose(Item[] items, CategoryManager categoryManager) {
        this.items = items;
        this.categoryManager = categoryManager;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            ItemCategory itemCategory = categoryManager.identify(item);
            if (itemCategory != ItemCategory.AGED && itemCategory != ItemCategory.PASS) {
                if (item.getQuality() > 0) {
                    if (itemCategory != ItemCategory.LEGENDARY) {
                        item.setQuality(item.getQuality() - 1);
                        if (itemCategory == ItemCategory.CONJURED && item.getQuality() > 0) {
                            item.setQuality(item.getQuality() - 1);
                        }
                    }
                }
            } else {
                if (item.getQuality() < 50) {
                    item.setQuality(item.getQuality() + 1);

                    if (itemCategory == ItemCategory.PASS) {
                        if (item.getSellIn() < 11) {
                            if (item.getQuality() < 50) {
                                item.setQuality(item.getQuality() + 1);
                            }
                        }

                        if (item.getSellIn() < 6) {
                            if (item.getQuality() < 50) {
                                item.setQuality(item.getQuality() + 1);
                            }
                        }
                    }
                }
            }

            if (itemCategory != ItemCategory.LEGENDARY) {
                item.setSellIn(item.getSellIn() - 1);
            }

            if (item.getSellIn() < 0) {
                if (itemCategory != ItemCategory.AGED) {
                    if (itemCategory != ItemCategory.PASS) {
                        if (item.getQuality() > 0) {
                            if (itemCategory != ItemCategory.LEGENDARY) {
                                item.setQuality(item.getQuality() - 1);
                            }
                        }
                    } else {
                        item.setQuality(item.getQuality() - item.getQuality());
                    }
                } else {
                    if (item.getQuality() < 50) {
                        item.setQuality(item.getQuality() + 1);
                    }
                }
            }
        }
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }
}
