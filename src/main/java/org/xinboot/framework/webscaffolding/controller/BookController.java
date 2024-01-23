package org.xinboot.framework.webscaffolding.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xinboot.framework.webscaffolding.common.util.BeanUtils;
import org.xinboot.framework.webscaffolding.model.entity.BookEntity;
import org.xinboot.framework.webscaffolding.model.response.GetBookResponse;
import org.xinboot.framework.webscaffolding.service.BookService;

import java.util.UUID;

/**
 * @author zengxin
 */
@RestController
@RequestMapping("books")
public class BookController {

  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }


  @GetMapping("{id}")
  public GetBookResponse get(@PathVariable("id") UUID id) {
    BookEntity book = bookService.get(id);

    GetBookResponse response = new GetBookResponse();
    BeanUtils.copyBean(response, book);
    return response;
  }
}
