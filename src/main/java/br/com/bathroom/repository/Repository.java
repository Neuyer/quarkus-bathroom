package br.com.bathroom.repository;

import java.util.List;

import br.com.bathroom.model.Model;
import br.com.bathroom.model.Toilet;

public abstract class Repository  {

    public abstract void create(Model obj);

    public abstract List<?> findAll();

    public abstract Model findById(Long id);

}