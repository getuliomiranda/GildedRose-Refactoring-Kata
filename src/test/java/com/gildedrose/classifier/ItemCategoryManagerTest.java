package com.gildedrose.classifier;

import com.gildedrose.Item;
import com.gildedrose.model.ItemCategory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ItemCategoryManagerTest {

    private Item[] items;
    private CategoryManager categoryManager;

    @BeforeMethod
    public void setUp() {
        categoryManager = new CategoryManager();
        items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Conjured Mana Cake", 3, 6)
        };
    }

    @Test
    public void shouldIdentifyItems() {
        assertEquals(categoryManager.identify(items[0]), ItemCategory.NORMAL);
        assertEquals(categoryManager.identify(items[1]), ItemCategory.AGED);
        assertEquals(categoryManager.identify(items[2]), ItemCategory.NORMAL);
        assertEquals(categoryManager.identify(items[3]), ItemCategory.LEGENDARY);
        assertEquals(categoryManager.identify(items[4]), ItemCategory.PASS);
        assertEquals(categoryManager.identify(items[5]), ItemCategory.CONJURED);
    }
}