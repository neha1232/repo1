package com.sample1.sample1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

@Service 

public class ItemService { 
	private Set<Item> items = new TreeSet<>();

	public void addItem(Item item) {
		items.add(item);
	}

	public void addItems(List<Item> item) {
		items.addAll(item); 
		System.out.println(items.size());
	}

	public List<Item> getItems() { 
		Date date = getMinusTwoSecondTime(); 
		List<Item> itemsAddedinLast2Seconds = new ArrayList<>();
		List<Item> nonMatchedItems = new ArrayList<>();
		for (Item item : items) 
		{
			// if(date.before(item.getTimestamp()));
			if (item.getTimestamp().after(date) || item.getTimestamp().equals(date)) { 
				itemsAddedinLast2Seconds.add(item);
			} else {
				nonMatchedItems.add(item); 
			}
		}
		if (itemsAddedinLast2Seconds.size() < 100) {
			//NavigableSet<Item> sortedNonMatchedItems= nonMatchedItems.descendingSet(); 
			Comparator<Item> comparator = Comparator.comparing(Item::getTimestamp); 
			Collections.sort(nonMatchedItems, comparator.reversed());
			int size = itemsAddedinLast2Seconds.size();
			for (Item item : nonMatchedItems) {
				if (size == 100)
					break;
				itemsAddedinLast2Seconds.add(item);
				size++;

			}
		}
		return itemsAddedinLast2Seconds;
		//return new ArrayList<>(itemsAddedinLast2Seconds);
	}

	private Date getMinusTwoSecondTime() {
		Date currentDate = new Date();

		
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);

		
		c.add(Calendar.SECOND, -2);

		
		return c.getTime();
	}
}
