package com.example.inventory.app;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.inventory.config.AppConfig;
import com.example.inventory.model.Item;
import com.example.inventory.service.InventoryService;

public class InventoryApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext con = new AnnotationConfigApplicationContext(AppConfig.class);
		InventoryService service = con.getBean(InventoryService.class);

		System.out.println("Inventory Management using JDBC Template");

		// create new item
//		Item newitem = new Item("ASUS Laptop ", "Ryzen 9", new
//		BigDecimal("70000.00"), 50);
//		Long id = service.addItem(newitem);
//		System.out.println("Item created with id : " + id + "successfully");

		// fetch item by id
		// Long id2 = 3L;
		// Optional<Item> fetched_item = service.getById(id2);
		// fetched_item.ifPresent(i-> System.out.println("Fetched item is : " +i));

		// Delete item
		// Long idDel = 6L;
		// Optional<Item> fetched_item = service.getById(idDel);
		// fetched_item.ifPresent(i-> System.out.println("Fetched item is : " +i));
		// service.deleteItem(idDel);
		// System.out.println("Item has deleted whose id is : " + idDel);

		// update item
		Long upId = 7L;
//		Optional<Item> fetched_item = service.getById(upId);
//		if (fetched_item.isPresent()) {
//			Item item = fetched_item.get();
//			item.setUnitPrice(new BigDecimal("400.00"));
//			item.setName("Water Bottle");
//
//			int updated = service.updateItem(item);
//			System.out.println("Item updated. Rows affected : " + updated);
//		}
//		
//		//list all items
//		System.out.println("List of all Items");
//		List<Item> items = service.listItems(1, 4);
//		items.forEach(System.out::println);
//		
//		//reduce item quantity
		boolean reduced = service.reduceQuantity(upId, 10);
		System.out.println("Item quantity reduced " + reduced);
	}
}
