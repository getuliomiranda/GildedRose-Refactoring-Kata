package com.gildedrose.sellin;

import com.gildedrose.Item;
import com.gildedrose.model.ItemCategory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class SellInManagerTest {

    private SellInManager sellInManager;

    @BeforeMethod
    public void setUp() {
        sellInManager = new SellInManager(Arrays.asList(new DefaultSellInStrategy(), new LegendarySellInStrategy()));
    }

    @Test
    public void shouldUpdateSellInValues() {
        Item i = new Item("Aged Brie", 10, 10);
        sellInManager.update(i, ItemCategory.AGED);
        assertEquals(i.getSellIn(), 9);

        i = new Item("Sulfuras, Hand of Ragnaros", 0, 10);
        sellInManager.update(i, ItemCategory.LEGENDARY);
        assertEquals(i.getSellIn(), 0);
    }
}