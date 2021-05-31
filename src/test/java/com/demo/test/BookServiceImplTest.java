package com.demo.test;


import com.demo.api.review.BookService;
import com.demo.api.review.BookServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class BookServiceImplTest {

    @Mock
    private BookService bookService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        bookService = new BookServiceImpl();
    }

    @Test
    public void doNotTransactionAction() {
        bookService.doNotTransactionAction();
    }

    @Test
    public void doTransactionAction() {
        bookService.doTransactionAction();
    }

}