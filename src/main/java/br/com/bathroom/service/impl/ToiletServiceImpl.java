package br.com.bathroom.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.bathroom.model.Bog;
import br.com.bathroom.model.Toilet;
import br.com.bathroom.repository.BogRepository;
import br.com.bathroom.repository.ToiletRepository;
import br.com.bathroom.request.ToiletRequest;
import br.com.bathroom.service.ToiletService;

@ApplicationScoped
@Transactional
public class ToiletServiceImpl implements ToiletService {

    @Inject
    BogRepository bogRepository;

    @Inject
    ToiletRepository toiletRepository;

    @Override
    public Toilet create(ToiletRequest tRequest) {

        Toilet toilet = new Toilet();
        List<Bog> bogs = new ArrayList<>();

        for (int i = 0; i < tRequest.getQuantity(); i++) {

            Bog bog = new Bog(toilet);

           bogRepository.create(bog);
            bogs.add(bog);
        }

        toilet.setBathroomName(tRequest.getName());
        toilet.setBogs(bogs);

        toiletRepository.create(toilet);

        return toilet;

    }

    @Override
    public List<Toilet> lisToilets() {

        return toiletRepository.findAll();

    }

    @Override
    public Toilet findByID(Long id) {
        // TODO Auto-generated method stub
        
        Toilet t = toiletRepository.findById(id);

        return t;
    }

}
