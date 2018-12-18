package com.sample1.sample1;

import java.util.Date;

public class Item implements Comparable<Item>{
	private int id;
	private final Date timestamp; 

	public Item() {
		this.timestamp = new Date();
	}

	public int getId() { 
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	@Override
	public int compareTo(Item o) {
		
		//return this.getTimestamp().compareTo(o.getTimestamp()); 
		return this.getId()-o.getId();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (id != other.id)
			return false;
		return true;
	}

	// public void setTimestamp(Date timestamp) {
	// this.timestamp = timestamp;
	// }
	
}
