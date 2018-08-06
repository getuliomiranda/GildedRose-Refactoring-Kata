package com.gildedrose.sellin;

import com.gildedrose.Item;
import com.gildedrose.model.ItemCategory;

import java.util.Arrays;
import java.util.List;

public class SellInManager {

    private List<SellInStrategy> sellInStrategies;

    public SellInManager(List<SellInStrategy> sellInStrategies) {
        this.sellInStrategies = sellInStrategies;
    }

    public SellInManager() {
        sellInStrategies = Arrays.asList(new DefaultSellInStrategy(), new LegendarySellInStrategy());
    }

    public void update(Item item, ItemCategory itemCategory) {
        sellInStrategies.stream().filter(sellInStrategy -> sellInStrategy.accepts(itemCategory)).forEach(sellInStrategy -> item.setSellIn(sellInStrategy.apply(item)));
    }
}
