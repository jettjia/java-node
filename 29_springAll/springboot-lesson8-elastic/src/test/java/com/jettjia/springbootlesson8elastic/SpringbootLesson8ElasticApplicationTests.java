package com.jettjia.springbootlesson8elastic;

import com.jettjia.springbootlesson8elastic.bean.Article;
import com.jettjia.springbootlesson8elastic.bean.Book;
import com.jettjia.springbootlesson8elastic.bean.Employee;
import com.jettjia.springbootlesson8elastic.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ResultsMapper;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootLesson8ElasticApplicationTests {

    @Autowired
    JestClient jestClient;

    /**
     * 添加
     */
    @Test
    public void contextLoads() {

        Article article = new Article();
        article.setId(1);
        article.setTitle("好消息!");
        article.setAuthor("zhangsan");
        article.setContent("Hello World");

        // 构建一个索引功能
        Index index = new Index.Builder(article).index("atguigu").type("news").build();
        try {
            // 执行
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void search() {
        // 查询表达式
        String json = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"hello\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        //构建搜索功能
        Search search = new Search.Builder(json).addIndex("atguigu").addType("news").build();
        try {
            SearchResult result = jestClient.execute(search);
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    BookRepository bookRepository;

    @Test
    public void testRepository() {
        Book book = new Book();
        book.setId(1);
        book.setBookName("西游记");
        book.setAuthor("吴承恩");
        bookRepository.index(book);
    }

    @Test
    public void find() {
        List<Book> books = bookRepository.findByBookNameLike("游");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void testElasticsearchTemplate() {
        String documentId = "123456";
        Employee employee = new Employee();
        employee.setId(documentId);
        employee.setName("jett");
        employee.setAge(25);
        IndexQuery indexQuery = new IndexQueryBuilder().withId(employee.getId()).withObject(employee).build();
        elasticsearchTemplate.index(indexQuery);
    }

    /**
     * 查询
     */
    @Test
    public void testElasticsearchTemplateQuery() {
        String documentId = "123456";
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(matchAllQuery())
                .withIndices("atguigu")
                .withTypes("employee")
                .withPageable(new PageRequest(0,1))
                .build();
        String scrollId = elasticsearchTemplate.scan(searchQuery,1000,false);
        System.out.println(scrollId);
    }

}
