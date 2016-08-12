/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bentest.model;

import java.util.Set;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author ben.schellenberger
 */
@Entity
public class GameTeam {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;

    @ElementCollection( targetClass = Player.class )
    @OneToOne
    private Set<Player> teamPlayers;

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public Set<Player> getTeamPlayers() {
        return teamPlayers;
    }

    public void setTeamPlayers( Set<Player> teamPlayers ) {
        this.teamPlayers = teamPlayers;
    }

}
