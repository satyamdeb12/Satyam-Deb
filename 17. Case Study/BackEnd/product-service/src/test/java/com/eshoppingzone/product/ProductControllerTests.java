package com.eshoppingzone.product;


import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.eshoppingzone.product.controller.ProductController;
import com.eshoppingzone.product.models.Product;
import com.eshoppingzone.product.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class ProductControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductController controller;

    @Mock
    private ProductService productService;



    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new ProductController()).build();
    }

    @Test
    public void testGetProductByIds() throws Exception {
        Product p = new Product();
        p.setId("1234");
        p.setProductName("ABC");

        Mockito.when(productService.findProductById(any())).thenReturn(p);

        mockMvc.perform(get("/product/find/{id}","1234").accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
