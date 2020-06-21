package com.example.practice.dao;

import com.example.practice.dto.ItemDto;
import com.example.practice.model.Item;

import java.util.List;

public interface ItemDao {
    void createItem(Item item);

    void updateItem(Item item);

    void removeItem(Item item);

    Item findItemByBookAuthorId(int book_id, int author_id);

    List<ItemDto> findAuthorItemBook();

    List<ItemDto> findSearchItem(String searchString);

    List<ItemDto> findSortedItemAuthor();

    List<ItemDto> findSortedItemPrice();
}
