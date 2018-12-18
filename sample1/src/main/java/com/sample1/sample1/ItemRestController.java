package com.sample1.sample1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class ItemRestController {

	@Autowired 
	private ItemService itemService; 

	@PostMapping(value = "/item") // for a single item at a time, not used
	public ResponseEntity<Void> saveItem(@RequestBody Item item) {
		itemService.addItem(item);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@PostMapping(value = "/items") // multiple items
	public ResponseEntity<Void> saveItems(@RequestBody List <Item> item) {
		itemService.addItems(item); 
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/items") 
	public ResponseEntity<List<Item>> getItems() {
		return new ResponseEntity<>(itemService.getItems(),HttpStatus.OK);
	}
}
