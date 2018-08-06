package com.gildedrose;

import com.gildedrose.classifier.CategoryManager;
import com.gildedrose.sellin.SellInManager;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.StringJoiner;

import static org.testng.Assert.assertEquals;

public class GildedRoseTest {

    @Test
    public void testUpdateQuality() {

        Item[] items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Conjured Mana Cake", 3, 6)
        };
        GildedRose app = new GildedRose(items, new CategoryManager(), new SellInManager());
        app.updateQuality();

        StringJoiner sj = new StringJoiner("\n");
        Arrays.stream(app.getItems()).forEach(item -> sj.add(item.toString()));
        String expected = "+5 Dexterity Vest, 9, 19\n" +
                "Aged Brie, 1, 1\n" +
                "Elixir of the Mongoose, 4, 6\n" +
                "Sulfuras, Hand of Ragnaros, 0, 80\n" +
                "Backstage passes to a TAFKAL80ETC concert, 14, 21\n" +
                "Conjured Mana Cake, 2, 4";
        assertEquals(sj.toString(), expected);
    }
}