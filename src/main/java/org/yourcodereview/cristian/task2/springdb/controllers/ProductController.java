package org.yourcodereview.cristian.task2.springdb.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.yourcodereview.cristian.task2.springdb.dao.CommentDao;
import org.yourcodereview.cristian.task2.springdb.dao.ProductDao;
import org.yourcodereview.cristian.task2.springdb.models.Comment;
import org.yourcodereview.cristian.task2.springdb.models.Product;

@Controller
@RequestMapping()
public class ProductController {

    private final ProductDao productDao;
    private final CommentDao commentDao;
    static Logger logger = Logger.getLogger(ProductController.class);

    @Autowired
    public ProductController(ProductDao productDao, CommentDao commentDao) {
        this.productDao = productDao;
        this.commentDao = commentDao;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Product product, Model model) {
        logger.debug("Added a product from UI : " + product.toString());
        productDao.save(product);
        model.addAttribute("product", product);
        return "product_info";
    }

    @GetMapping("/all")
    public String getAllProducts(Model model) {
        System.out.println("dadada");

        model.addAttribute("products", productDao.all());
        return "all_products";
    }

    @GetMapping("/all/{id}")
    public String findProduct(@PathVariable int id, Model model) {
        System.out.println("dadada");
        model.addAttribute("product", productDao.show(id));
        return "product";
    }

    @RequestMapping("/delete/{id}")
    public String remove(@PathVariable int id) {
        productDao.delete(id);
        logger.debug("Product with ID " + id + " was deleted");
        return "redirect:/all";
    }

    @GetMapping()
    public String home() {
        return "index";
    }

    @PostMapping("/blog/save")
    public String saveComment(@ModelAttribute Comment comment, Model model) {
        commentDao.save(comment);
        model.addAttribute("comment", comment);
        return "redirect:/blog";
    }

    @GetMapping("/blog")
    public String blog(Model model) {
        model.addAttribute("comments", commentDao.findAll());
        return "blog";
    }

    @RequestMapping("/delete/comment/{id}")
        public String removeComment(@PathVariable int id) {
        commentDao.deleteComment(id);
        return "redirect:/blog";
    }

    @GetMapping("/comment/{id}")
    public String findComment(@PathVariable int id, Model model) {
        model.addAttribute("comment", commentDao.findCommentById(id));
        return "comment_info";
    }

    @GetMapping("/admin")
    public String admin(Model model) {

        return "all_products";
    }
}
