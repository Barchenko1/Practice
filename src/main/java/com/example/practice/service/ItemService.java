package com.example.practice.service;

import com.example.practice.dto.ItemBookIdDto;
import com.example.practice.dto.ItemDto;
import com.example.practice.model.Item;

import java.util.List;

public interface ItemService {

    void createItem(ItemBookIdDto title);

    void updateItem(int id, ItemBookIdDto title);

    void removeItem(Item item);

    Item findItemByBookAuthorId(int book_id, int author_id);

    List<ItemDto> findAllItem();

    List<ItemDto> findSearchItem(String searchString);

    List<ItemDto> findSortedItemAuthor();

    List<ItemDto> findSortedItemPrice();
}
