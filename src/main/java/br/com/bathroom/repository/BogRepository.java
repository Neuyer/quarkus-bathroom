package br.com.bathroom.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.bathroom.model.Bog;
import br.com.bathroom.model.Model;

@ApplicationScoped
public class BogRepository extends Repository {

    @Inject
    EntityManager em;

    @Override
    public List<Bog> findAll() {
        // TODO Auto-generated method stub
        return em.createQuery("SELECT b FROM Bog b", Bog.class).getResultList();
    }

    @Override
    public Bog findById(Long id) {
        // TODO Auto-generated method stub
        return em.createQuery("SELECT DISTINCT b FROM Bog b WHERE b.id =" + id + "", Bog.class).getSingleResult();
    }

    public List<Bog> findByToiletId(Long id) {

        return em.createQuery("SELECT b FROM Bog b WHERE b.toilet.id = " + id + "", Bog.class).getResultList();
    }

    @Override
    public void create(Model obj) {
        // TODO Auto-generated method stub
         em.persist(obj);
    }

}