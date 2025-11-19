package com.example.inventory.DAO;

import java.util.List;
import java.util.Optional;

import com.example.inventory.model.Item;

public interface InventoryDao {
	
	//List of all methods that should be implemented for inventory managemet

	
	Long create(Item item);	// create new item of type Item and return Long
	
	Optional<Item>	findById(Long id);	//result or you get null if no such id
	//	if not found -> return an empty optional of type item instead of null
	
	List<Item> findAll(int offset, int limit);
	
	int update(Item item);
	
	int delete(Long id);
	
	boolean reduceQuantity(Long id, int quantityToReduce);
}
