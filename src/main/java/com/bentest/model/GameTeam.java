/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bentest.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
    @OneToMany
    private List<Player> teamPlayers = new ArrayList<>();

    //   @Column( unique = true )
    private String teamName = "Unnamed Team";

    private String teamLogoUrl;

    private int teamSize = 2;

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public List<Player> getTeamPlayers() {
        return new ArrayList( teamPlayers );
    }

    public void setTeamPlayers( ArrayList<Player> teamPlayers ) {
        if ( teamPlayers.size() > teamSize ) {
            throw new IllegalArgumentException( "Too many players" );
        }
        this.teamPlayers = teamPlayers;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName( String teamName ) {
        this.teamName = teamName;
    }

    public boolean addTeamPlayer( Player player ) {
        if ( teamPlayers.size() >= teamSize ) {
            return false;
        }
        return teamPlayers.add( player );
    }

    public void removeTeamPlayer( Player player ) {
        teamPlayers.remove( player );
    }

}
