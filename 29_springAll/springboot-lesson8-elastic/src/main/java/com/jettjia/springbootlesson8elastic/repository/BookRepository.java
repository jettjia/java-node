package com.jettjia.springbootlesson8elastic.repository;

import com.jettjia.springbootlesson8elastic.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BookRepository extends ElasticsearchRepository<Book, Integer> {

    public List<Book> findByBookNameLike(String bookName);
}
