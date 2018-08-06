package com.gildedrose.classifier;

import com.gildedrose.Item;
import com.gildedrose.model.ItemCategory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class AgedItemCategoryClassifierTest {

    private ItemCategoryClassifier classifier;

    private Item[] agedItems;
    private Item[] nonAgedItems;

    @BeforeMethod
    public void setUp() {
        classifier = new AgedItemCategoryClassifier();
        agedItems = new Item[]{
                new Item("Aged Brie", 10, 10),
                new Item("Aged Pasta", 8, 13),
                new Item("Aged Pizza", 5, 50) //#whynot?
        };

        nonAgedItems = new Item[]{
                new Item("Fresh Brie", 5, 9),
                new Item("Fresh Pasta", 10, 3),
                new Item("Fresh Pizza", 15, 20)
        };
    }

    @Test
    public void shouldBelong() {
        Arrays.stream(agedItems).forEach(item -> assertTrue(classifier.belongs(item)));
    }

    @Test
    public void shouldNotBelong() {
        Arrays.stream(nonAgedItems).forEach(item -> assertFalse(classifier.belongs(item)));
    }

    @Test
    public void testGetCategory() {
        assertEquals(classifier.getCategory(), ItemCategory.AGED);
    }
}