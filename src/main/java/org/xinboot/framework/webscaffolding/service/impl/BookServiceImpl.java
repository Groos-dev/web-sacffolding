package org.xinboot.framework.webscaffolding.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xinboot.framework.webscaffolding.common.exception.BusinessException;
import org.xinboot.framework.webscaffolding.common.message.ResultCode;
import org.xinboot.framework.webscaffolding.model.entity.BookEntity;
import org.xinboot.framework.webscaffolding.repository.BookRepository;
import org.xinboot.framework.webscaffolding.service.BookService;

import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {
  private BookRepository bookRepository;

  @Autowired
  public BookServiceImpl(BookRepository bookRepository){
    this.bookRepository = bookRepository;
  }
  @Override
  public BookEntity get(UUID id) {
    return bookRepository.findById(id).orElseThrow(() -> new BusinessException(ResultCode.BOOK_NOT_FOUND));
  }
}
