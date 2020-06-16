package com.example.practice.controller;

import com.example.practice.dto.TitleBookIdDto;
import com.example.practice.dto.TitleDto;
import com.example.practice.model.Title;
import com.example.practice.proposal.GenerateTitlePdfReport;
import com.example.practice.service.TitleService;
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
@RequestMapping("/title")
public class TitleController {
    @Autowired
    private TitleService titleService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    protected ModelAndView getTypePage() {
        ModelAndView modelAndView = new ModelAndView();
        List<TitleDto> titleDtoList = titleService.findAllTitles();
        modelAndView.addObject("titleDtoList", titleDtoList);
        modelAndView.setViewName(TITLE_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createBookPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(CREATE_TITLE_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView createBook(@ModelAttribute("titleBookIdDto") TitleBookIdDto titleBookIdDto) {
        titleService.createTitle(titleBookIdDto);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/title/");
        return modelAndView;
    }

    @RequestMapping(value = "/update/{book_id}/{author_id}", method = RequestMethod.GET)
    public ModelAndView updateAuthorGet(@PathVariable("book_id") int book_id,
                                        @PathVariable("author_id") int author_id) {
        Title title = titleService.findTitleByBookAuthorId(book_id, author_id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(UPDATE_TITLE_PAGE);
        modelAndView.addObject("title", title);
        modelAndView.addObject("book_id", book_id);
        modelAndView.addObject("author_id", author_id);
        return modelAndView;
    }

    @RequestMapping(value = "/update/{title_id}", method = RequestMethod.POST)
    public ModelAndView updateAuthorPost(@PathVariable("title_id") int title_id,
                                         @ModelAttribute("titleBookIdDto") TitleBookIdDto titleBookIdDto) {
        titleService.updateTitle(title_id, titleBookIdDto);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/title/");
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{book_id}/{author_id}", method = RequestMethod.GET)
    public ModelAndView deleteAuthor(@PathVariable("book_id") int book_id,
                                     @PathVariable("author_id") int author_id) {
        Title title = titleService.findTitleByBookAuthorId(book_id, author_id);
        titleService.removeTitle(title);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/title/");
        return modelAndView;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    protected ModelAndView getSearchPage(@ModelAttribute("searchString") String searchString) {
        ModelAndView modelAndView = new ModelAndView();
        List<TitleDto> titleDtoList = titleService.findSearchTitle(searchString);
        modelAndView.addObject("titleDtoList", titleDtoList);
        modelAndView.setViewName(TITLE_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    protected ModelAndView getSortPage() {
        ModelAndView modelAndView = new ModelAndView();
        List<TitleDto> titleDtoList = titleService.findSortedTitle();
        modelAndView.addObject("titleDtoList", titleDtoList);
        modelAndView.setViewName(TITLE_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = "/pdfReport", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> citiesReport() {

        List<TitleDto> titleDtoList = titleService.findAllTitles();

        ByteArrayInputStream bis = GenerateTitlePdfReport.pdfReport(titleDtoList);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=pdfReport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<TitleDto> findAllTitles() {
        return titleService.findAllTitles();
    }
}
