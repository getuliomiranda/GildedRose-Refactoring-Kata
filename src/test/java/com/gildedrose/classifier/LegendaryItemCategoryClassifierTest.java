package com.gildedrose.classifier;

import com.gildedrose.Item;
import com.gildedrose.model.ItemCategory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class LegendaryItemCategoryClassifierTest {

    private ItemCategoryClassifier classifier;

    private Item[] legendaryItems;
    private Item[] nonLegendaryItems;

    @BeforeMethod
    public void setUp() {
        classifier = new LegendaryItemCategoryClassifier();
        legendaryItems = new Item[]{
                new Item("Sulfuras, Hand of Ragnaros", 0, 80)
        };

        nonLegendaryItems = new Item[]{
                new Item("Aged Brie", 5, 9),
                new Item("Pasta", 10, 3),
                new Item("Pizza, +5 Strength", 15, 20)
        };
    }

    @Test
    public void shouldBelong() {
        Arrays.stream(legendaryItems).forEach(item -> assertTrue(classifier.belongs(item)));
    }

    @Test
    public void shouldNotBelong() {
        Arrays.stream(nonLegendaryItems).forEach(item -> assertFalse(classifier.belongs(item)));
    }

    @Test
    public void testGetCategory() {
        assertEquals(classifier.getCategory(), ItemCategory.LEGENDARY);
    }

}