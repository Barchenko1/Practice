package com.example.practice.dao.impl;

import com.example.practice.dao.ItemDao;
import com.example.practice.dto.ItemDto;
import com.example.practice.model.Item;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;

import static java.util.Objects.isNull;

@Repository
@Transactional
public class ItemDaoImpl implements ItemDao {

    private static final String FIND_ALL_TITLES = "SELECT * from Items";
    private static final String FIND_JOINER_BOOKS_AUTHORS_ITEMS = "SELECT b.book_id, a.author_id, b.title, b.price, b.circulation, a.f_name, a.l_name, a.author_pay, b.price * b.circulation as income\n" +
            "FROM Items i\n" +
            "  JOIN Books b ON i.book_id=b.book_id\n" +
            "  JOIN Authors a ON i.author_id=a.author_id";
    private static final String FIND_ALL_ITEMS_BOOK_AUTHOR_ID = "SELECT * from Items where book_id=? and author_id=?";
    private static final String FIND_JOINER_BOOKS_AUTHORS_ITEMS_SEARCH = "SELECT b.book_id, a.author_id, b.title, b.price, b.circulation, a.f_name, a.l_name, a.author_pay, b.price * b.circulation as income\n" +
            "FROM Items i\n" +
            "  JOIN Books b ON i.book_id=b.book_id\n" +
            "  JOIN Authors a ON i.author_id=a.author_id where b.title = ?";
    private static final String FIND_JOINER_BOOKS_AUTHORS_ITEMS_SORT_AUTHOR = "SELECT b.book_id, a.author_id, b.title, b.price, b.circulation, a.f_name, a.l_name, a.author_pay, b.price * b.circulation as income\n" +
            "FROM Items i\n" +
            "  JOIN Books b ON i.book_id=b.book_id\n" +
            "  JOIN Authors a ON i.author_id=a.author_id order by a.f_name";
    private static final String FIND_JOINER_BOOKS_AUTHORS_ITEMS_SORT_PRICE = "SELECT b.book_id, a.author_id, b.title, b.price, b.circulation, a.f_name, a.l_name, a.author_pay, b.price * b.circulation as income\n" +
            "FROM Items i\n" +
            "  JOIN Books b ON i.book_id=b.book_id\n" +
            "  JOIN Authors a ON i.author_id=a.author_id order by b.price";

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createItem(Item item) {
        if (isNull(item)) {
            throw new IllegalArgumentException("item is null");
        }
        try {
            sessionFactory.getCurrentSession()
                    .save(item);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateItem(Item item) {
        if (isNull(item)) {
            throw new IllegalArgumentException("item is null");
        }
        try {
            sessionFactory.getCurrentSession()
                    .update(item);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeItem(Item item) {
        if (isNull(item)) {
            throw new IllegalArgumentException("item is null");
        }
        try {
            sessionFactory.getCurrentSession()
                    .remove(item);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Item findItemByBookAuthorId(int book_id, int author_id) {
        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(FIND_ALL_ITEMS_BOOK_AUTHOR_ID);
        query.setParameter(1, book_id);
        query.setParameter(2, author_id);
        Item item = null;
        try {
            item = (Item) query.addEntity(Item.class).getSingleResult();
        } catch (NoResultException ex) {

        }
        return item;
    }

    @Override
    public List<ItemDto> findAuthorItemBook() {
        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(FIND_JOINER_BOOKS_AUTHORS_ITEMS);
        query.setResultTransformer(Transformers.aliasToBean(ItemDto.class));
        List<ItemDto> authorItemBookList = query.getResultList();
        if (authorItemBookList.isEmpty()) {
            return null;
        }
        return authorItemBookList;
    }

    @Override
    public List<ItemDto> findSearchItem(String searchString) {
        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(FIND_JOINER_BOOKS_AUTHORS_ITEMS_SEARCH);
        query.setParameter(1, searchString);
        query.setResultTransformer(Transformers.aliasToBean(ItemDto.class));
        List<ItemDto> itemDtoList = null;
        try {
            itemDtoList = (List<ItemDto>) query.getResultList();
        } catch (NoResultException ex) {

        }
        return itemDtoList;
    }

    @Override
    public List<ItemDto> findSortedItemAuthor() {
        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(FIND_JOINER_BOOKS_AUTHORS_ITEMS_SORT_AUTHOR);
        query.setResultTransformer(Transformers.aliasToBean(ItemDto.class));
        List<ItemDto> authorItemBookList = query.getResultList();
        if (authorItemBookList.isEmpty()) {
            return null;
        }
        return authorItemBookList;
    }

    @Override
    public List<ItemDto> findSortedItemPrice() {
        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(FIND_JOINER_BOOKS_AUTHORS_ITEMS_SORT_PRICE);
        query.setResultTransformer(Transformers.aliasToBean(ItemDto.class));
        List<ItemDto> authorItemBookList = query.getResultList();
        if (authorItemBookList.isEmpty()) {
            return null;
        }
        return authorItemBookList;
    }
}
