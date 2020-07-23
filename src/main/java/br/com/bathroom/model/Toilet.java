package br.com.bathroom.model;

import javax.json.bind.annotation.JsonbTypeSerializer;
import javax.persistence.*;

import java.util.List;

@Entity
public class Toilet extends Model{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String bathroomName;

    private Boolean isFull = false;

    @OneToMany(mappedBy = "toilet", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Bog> bogs;

    public Toilet() {
    }

    public Toilet(String bathroomName, List<Bog> bogs) {
        this.bathroomName = bathroomName;
        this.bogs = bogs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBathroomName() {
        return bathroomName;
    }

    public void setBathroomName(String bathroomName) {
        this.bathroomName = bathroomName;
    }

    public Boolean getFull() {
        return isFull;
    }

    public void setFull(Boolean full) {
        isFull = full;
    }

    public List<Bog> getBogs() {
        return bogs;
    }

    public void setBogs(List<Bog> bogs) {
        this.bogs = bogs;
    }
}
