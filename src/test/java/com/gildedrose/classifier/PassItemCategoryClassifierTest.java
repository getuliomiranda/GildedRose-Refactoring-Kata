package com.gildedrose.classifier;

import com.gildedrose.Item;
import com.gildedrose.model.ItemCategory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class PassItemCategoryClassifierTest {

    private ItemCategoryClassifier classifier;

    private Item[] passItems;
    private Item[] nonPassItems;

    @BeforeMethod
    public void setUp() {
        classifier = new PassItemCategoryClassifier();
        passItems = new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)
        };

        nonPassItems = new Item[]{
                new Item("Aged Brie", 5, 9),
                new Item("Pasta", 10, 3),
                new Item("Pizza, +5 Strength", 15, 20)
        };
    }

    @Test
    public void shouldBelong() {
        Arrays.stream(passItems).forEach(item -> assertTrue(classifier.belongs(item)));
    }

    @Test
    public void shouldNotBelong() {
        Arrays.stream(nonPassItems).forEach(item -> assertFalse(classifier.belongs(item)));
    }

    @Test
    public void testGetCategory() {
        assertEquals(classifier.getCategory(), ItemCategory.PASS);
    }

}