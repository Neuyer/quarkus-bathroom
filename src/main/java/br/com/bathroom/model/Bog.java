package br.com.bathroom.model;

import javax.persistence.*;

@Entity
public class Bog extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Boolean isFree = true;

    @ManyToOne
    private Toilet toilet;

    public Bog(){};

    public Bog( Toilet t){

        this.toilet = t;

    }
}
