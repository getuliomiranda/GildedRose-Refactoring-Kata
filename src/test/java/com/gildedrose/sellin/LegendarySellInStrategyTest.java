package com.gildedrose.sellin;

import com.gildedrose.Item;
import com.gildedrose.model.ItemCategory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class LegendarySellInStrategyTest {

    private SellInStrategy sellInStrategy;

    private static final ItemCategory[] ACCEPTABLE_ITEM_CATEGORIES = new ItemCategory[]{ItemCategory.LEGENDARY};
    private static final ItemCategory[] NOT_ACCEPTABLE_ITEM_CATEGORIES = new ItemCategory[]{ItemCategory.NORMAL, ItemCategory.CONJURED, ItemCategory.AGED, ItemCategory.PASS};

    @BeforeMethod
    public void setUp() {
        sellInStrategy = new LegendarySellInStrategy();
    }

    @Test
    public void shouldAccept() {
        Arrays.stream(ACCEPTABLE_ITEM_CATEGORIES).forEach(itemCategory -> assertTrue(sellInStrategy.accepts(itemCategory)));
    }

    @Test
    public void shouldNotAccept() {
        Arrays.stream(NOT_ACCEPTABLE_ITEM_CATEGORIES).forEach(itemCategory -> assertFalse(sellInStrategy.accepts(itemCategory)));
    }

    @Test
    public void shouldApplyReturnRightValues() {
        Item i = new Item("Sulfuras, Hand of Ragnaros", 0, 10);
        int result = sellInStrategy.apply(i);
        assertEquals(result, 0);
    }
}