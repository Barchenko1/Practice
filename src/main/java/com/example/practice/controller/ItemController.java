package com.example.practice.controller;

import com.example.practice.dto.ItemBookIdDto;
import com.example.practice.dto.ItemDto;
import com.example.practice.model.Item;
import com.example.practice.proposal.GenerateTitlePdfReport;
import com.example.practice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.ByteArrayInputStream;
import java.util.List;

import static com.example.practice.util.Constants.*;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    protected ModelAndView getTypePage() {
        ModelAndView modelAndView = new ModelAndView();
        List<ItemDto> itemDtoList = itemService.findAllItem();
        modelAndView.addObject("itemDtoList", itemDtoList);
        modelAndView.setViewName(ITEM_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createBookPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(CREATE_ITEM_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView createBook(@ModelAttribute("itemBookIdDto") ItemBookIdDto itemBookIdDto) {
        itemService.createItem(itemBookIdDto);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/item/");
        return modelAndView;
    }

    @RequestMapping(value = "/update/{book_id}/{author_id}", method = RequestMethod.GET)
    public ModelAndView updateAuthorGet(@PathVariable("book_id") int book_id,
                                        @PathVariable("author_id") int author_id) {
        Item item = itemService.findItemByBookAuthorId(book_id, author_id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(UPDATE_ITEM_PAGE);
        modelAndView.addObject("item", item);
        modelAndView.addObject("book_id", book_id);
        modelAndView.addObject("author_id", author_id);
        return modelAndView;
    }

    @RequestMapping(value = "/update/{item_id}", method = RequestMethod.POST)
    public ModelAndView updateAuthorPost(@PathVariable("item_id") int item_id,
                                         @ModelAttribute("itemBookIdDto") ItemBookIdDto itemBookIdDto) {
        itemService.updateItem(item_id, itemBookIdDto);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/item/");
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{book_id}/{author_id}", method = RequestMethod.GET)
    public ModelAndView deleteAuthor(@PathVariable("book_id") int book_id,
                                     @PathVariable("author_id") int author_id) {
        Item item = itemService.findItemByBookAuthorId(book_id, author_id);
        itemService.removeItem(item);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/item/");
        return modelAndView;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    protected ModelAndView getSearchPage(@ModelAttribute("searchString") String searchString) {
        ModelAndView modelAndView = new ModelAndView();
        List<ItemDto> itemDtoList = itemService.findSearchItem(searchString);
        modelAndView.addObject("itemDtoList", itemDtoList);
        modelAndView.setViewName(ITEM_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = "/sortAuthor", method = RequestMethod.GET)
    protected ModelAndView getSortPageAuthor() {
        ModelAndView modelAndView = new ModelAndView();
        List<ItemDto> itemDtoList = itemService.findSortedItemAuthor();
        modelAndView.addObject("itemDtoList", itemDtoList);
        modelAndView.setViewName(ITEM_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = "/sortPrice", method = RequestMethod.GET)
    protected ModelAndView getSortPageItem() {
        ModelAndView modelAndView = new ModelAndView();
        List<ItemDto> itemDtoList = itemService.findSortedItemPrice();
        modelAndView.addObject("itemDtoList", itemDtoList);
        modelAndView.setViewName(ITEM_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = "/pdfReport", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> citiesReport() {

        List<ItemDto> itemDtoList = itemService.findAllItem();

        ByteArrayInputStream bis = GenerateTitlePdfReport.pdfReport(itemDtoList);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=pdfReport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<ItemDto> findAllTitles() {
        return itemService.findAllItem();
    }
}
