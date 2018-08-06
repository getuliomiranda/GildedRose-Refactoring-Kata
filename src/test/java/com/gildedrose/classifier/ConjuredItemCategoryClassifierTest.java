package com.gildedrose.classifier;

import com.gildedrose.Item;
import com.gildedrose.model.ItemCategory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class ConjuredItemCategoryClassifierTest {

    private ItemCategoryClassifier classifier;

    private Item[] conjuredItems;
    private Item[] nonConjuredItems;

    @BeforeMethod
    public void setUp() {
        classifier = new ConjuredItemCategoryClassifier();
        conjuredItems = new Item[]{
                new Item("Conjured Brie", 10, 10),
                new Item("Conjured Pasta", 8, 13),
                new Item("Conjured Pizza", 5, 50)
        };

        nonConjuredItems = new Item[]{
                new Item("Aged Brie", 5, 9),
                new Item("Pasta", 10, 3),
                new Item("Pizza, +5 Strength", 15, 20)
        };
    }

    @Test
    public void shouldBelong() {
        Arrays.stream(conjuredItems).forEach(item -> assertTrue(classifier.belongs(item)));
    }

    @Test
    public void shouldNotBelong() {
        Arrays.stream(nonConjuredItems).forEach(item -> assertFalse(classifier.belongs(item)));
    }

    @Test
    public void testGetCategory() {
        assertEquals(classifier.getCategory(), ItemCategory.CONJURED);
    }

}