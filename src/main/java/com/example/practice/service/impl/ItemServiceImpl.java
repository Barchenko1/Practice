package com.example.practice.service.impl;

import com.example.practice.dao.ItemDao;
import com.example.practice.dto.ItemBookIdDto;
import com.example.practice.dto.ItemDto;
import com.example.practice.model.*;
import com.example.practice.service.AuthorService;
import com.example.practice.service.BookService;
import com.example.practice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import static java.util.Objects.isNull;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Override
    public void createItem(ItemBookIdDto titleBookIdDto) {
        Book book = bookService.findById(titleBookIdDto.getBook_id());
        Author author = authorService.findById(titleBookIdDto.getAuthor_id());
        Item item = new Item();
        item.setBook(book);
        item.setAuthor(author);
        itemDao.createItem(item);
    }

    @Override
    public void updateItem(int id, ItemBookIdDto titleBookIdDto) {
        Book book = bookService.findById(titleBookIdDto.getBook_id());
        Author author = authorService.findById(titleBookIdDto.getAuthor_id());
        Item item = new Item();
        item.setItem_id((long) id);
        item.setBook(book);
        item.setAuthor(author);
        itemDao.updateItem(item);
    }

    @Override
    public void removeItem(Item item) {
        itemDao.removeItem(item);
    }

    @Override
    public Item findItemByBookAuthorId(int book_id, int author_id) {
        return itemDao.findItemByBookAuthorId(book_id, author_id);
    }

    @Override
    public List<ItemDto> findAllItem() {
        return itemDao.findAuthorItemBook();
    }

    @Override
    public List<ItemDto> findSearchItem(String searchString) {
        List<ItemDto> itemDtoList = itemDao.findSearchItem(searchString);
        if (isNull(itemDtoList)) {
            return Collections.emptyList();
        }
        return itemDtoList;
    }

    @Override
    public List<ItemDto> findSortedItemAuthor() {
        return itemDao.findSortedItemAuthor();
    }

    @Override
    public List<ItemDto> findSortedItemPrice() {
        return itemDao.findSortedItemPrice();
    }
}
