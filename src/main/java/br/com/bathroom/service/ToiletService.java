package br.com.bathroom.service;

import br.com.bathroom.model.Toilet;
import br.com.bathroom.request.ToiletRequest;

import java.util.List;

import javax.transaction.Transactional;

@Transactional
public interface ToiletService {

    public Toilet create(ToiletRequest tRequest);

    public List<Toilet> lisToilets();

    public Toilet findByID(Long id);

}
