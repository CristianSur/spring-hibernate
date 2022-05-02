package org.yourcodereview.cristian.task2.springdb.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.yourcodereview.cristian.task2.springdb.models.Comment;
import org.yourcodereview.cristian.task2.springdb.models.Product;

import java.util.List;

@Component
public class CommentDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public CommentDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void save(Comment comment) {
        Session session = sessionFactory.getCurrentSession();
        session.save(comment);
    }

    @Transactional(readOnly = true)
    public List<Comment> findAll() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select c from Comment c", Comment.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public Comment findCommentById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Comment.class, id);
    }

    @Transactional
    public void deleteComment(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Comment.class, id));
    }
}
