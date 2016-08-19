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
import javax.persistence.ManyToOne;

/**
 *
 * @author ben.schellenberger
 */
@Entity
public class FoosballGame {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private long id;

    @ManyToOne
    GameTeam team1;

    @ManyToOne
    GameTeam team2;

    @ManyToOne
    FoosballTable foosballTable;

    int player1Score;

    int player2Score;

    public FoosballGame() {

    }

    public long getId() {
        return id;
    }

    public void setId( long id ) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + (int) ( this.id ^ ( this.id >>> 32 ) );
        return hash;
    }

    @Override
    public boolean equals( Object obj ) {
        if ( obj == null ) {
            return false;
        }
        if ( getClass() != obj.getClass() ) {
            return false;
        }
        final FoosballGame other = (FoosballGame) obj;
        if ( this.id != other.id ) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return new StringBuilder().append( "Game #:" ).append( id ).append( " Team 1: " ).append( team1.getTeamName() ).append( " Team 2: " ).append( team2.getTeamName() ).toString();
    }

    public GameTeam getTeam1() {
        return team1;
    }

    public void setTeam1( GameTeam team1 ) {
        this.team1 = team1;
    }

    public GameTeam getTeam2() {
        return team2;
    }

    public void setTeam2( GameTeam team2 ) {
        this.team2 = team2;
    }

    public FoosballTable getFoosballTable() {
        return foosballTable;
    }

    public void setFoosballTable( FoosballTable foosballTable ) {
        this.foosballTable = foosballTable;
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public void setPlayer1Score( int player1Score ) {
        this.player1Score = player1Score;
    }

    public int getPlayer2Score() {
        return player2Score;
    }

    public void setPlayer2Score( int player2Score ) {
        this.player2Score = player2Score;
    }

}
