//package org.yourcodereview.cristian.task2.springdb;
//
//import org.apache.log4j.Logger;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.util.Assert;
//import org.yourcodereview.cristian.task2.springdb.controllers.ProductController;
//import org.yourcodereview.cristian.task2.springdb.dao.ProductDao;
//import org.yourcodereview.cristian.task2.springdb.models.Product;
//
//import java.util.*;
//
//@SpringBootTest(classes = SpringDbApplication.class)
//class SpringDbApplicationTests {
//
//    private final ProductDao productDao;
//    static Logger logger = Logger.getLogger(ProductController.class);
//
//    @Autowired
//    public SpringDbApplicationTests(ProductDao productDao) {
//        this.productDao = productDao;
//    }
//
//    @Test
//    void removingFromDatabaseTest() {
//        List<Product> testList  = new ProductDao(jdbcTemplate()).all();
//        Product product = new Product(150, "test", 0, 0);
//
//        productDao.save(product);
//
//        Assert.isTrue(new ProductDao(jdbcTemplate()).all().size() == testList.size()+1, "Object was not saved");
//
//        productDao.delete(150);
//
//        Assert.isTrue(new ProductDao(jdbcTemplate()).all().size() == testList.size(), "Object was not eliminated");
//
//    }
//}
