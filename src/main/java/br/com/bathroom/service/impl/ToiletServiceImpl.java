package br.com.bathroom.service.impl;

import br.com.bathroom.model.Bog;
import br.com.bathroom.model.Toilet;
import br.com.bathroom.request.ToiletRequest;
import br.com.bathroom.service.ToiletService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Transactional
public class ToiletServiceImpl implements ToiletService {

    @Inject
    EntityManager em;

    @Override
    public Toilet create(ToiletRequest tRequest) {

        Toilet toilet = new Toilet();
        List<Bog> bogs = new ArrayList<>();

        for (int i = 0; i < tRequest.getQuantity(); i++) {

            Bog bog = new Bog(toilet);

            em.persist(bog);
            bogs.add(bog);
        }

        toilet.setBathroomName(tRequest.getName());
        toilet.setBogs(bogs);

        em.persist(toilet);

        return toilet;

    }

    @Override
    @Transactional
    public List<Toilet> lisToilets() {

        List<Toilet> list = em.createQuery("SELECT t FROM Toilet t", Toilet.class).getResultList();

        return list;
    }

    @Override
    public Toilet findByID(Long id) {
        // TODO Auto-generated method stub
        return em.createQuery("SELECT DISTINCT t FROM Toilet t where t.id =" + id + "", Toilet.class).getSingleResult();
    }
}
