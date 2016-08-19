/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bentest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author ben.schellenberger
 */
@Entity
public class FoosballTable {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private long id;

    private String description;
    private String name;

    private String team1;
    private String team2;

    public FoosballTable() {

    }

    public long getId() {
        return id;
    }

    public void setId( long id ) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1( String team1 ) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2( String team2 ) {
        this.team2 = team2;
    }

}
