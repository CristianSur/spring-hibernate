package org.yourcodereview.cristian.task2.springdb.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.yourcodereview.cristian.task2.springdb.models.Product;

import java.util.List;

@Component
public class ProductDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public ProductDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Product> all()   {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select p from Product p", Product.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public Product show(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Product.class, id);
    }

    @Transactional
    public void save(Product Product) {
        Session session = sessionFactory.getCurrentSession();
        session.save(Product);
    }

    @Transactional
    public void update(int id, Product updatedProduct) {
        Session session = sessionFactory.getCurrentSession();
        Product ProductToBeUpdated = session.get(Product.class, id);

        ProductToBeUpdated.setName(updatedProduct.getName());
        ProductToBeUpdated.setQuantity(updatedProduct.getQuantity());
        ProductToBeUpdated.setPrice(updatedProduct.getPrice());
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Product.class, id));
    }

}
