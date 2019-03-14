package com.company;

import java.util.Comparator;

class sortByAmountComparator implements Comparator<Item> {
    public int compare(Item item1, Item item2)
    {
        if (item1.count == item2.count)
            return 0;
        else if (item1.count > item2.count)
            return 1;
        else
            return -1;
    }
}