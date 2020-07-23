package br.com.bathroom.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.bathroom.model.Model;
import br.com.bathroom.model.Toilet;

@ApplicationScoped
public class ToiletRepository extends Repository {

    @Inject
    EntityManager em;

    @Override
   public List<Toilet> findAll() {
        // TODO Auto-generated method stub
        return em.createQuery("SELECT t FROM Toilet t", Toilet.class).getResultList();
    }

    @Override
    public Toilet findById(Long id) {
        // TODO Auto-generated method stub
        return em.createQuery("SELECT DISTINCT t FROM Toilet t where t.id =" + id + "", Toilet.class).getSingleResult();
    }

    @Override
    public void create(Model obj) {
        // TODO Auto-generated method stub
         em.persist(obj);
    }

}