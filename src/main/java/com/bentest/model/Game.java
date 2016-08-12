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
public class Game {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private long id;

    @ManyToOne
    Player player1;

    @ManyToOne
    Player player2;

    @ManyToOne
    GameTable gameTable;

    int player1Score;

    int player2Score;

    public Game() {

    }

    public long getId() {
        return id;
    }

    public void setId( long id ) {
        this.id = id;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1( Player player1 ) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2( Player player2 ) {
        this.player2 = player2;
    }

    public GameTable getGameTable() {
        return gameTable;
    }

    public void setGameTable( GameTable gameTable ) {
        this.gameTable = gameTable;
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
        final Game other = (Game) obj;
        if ( this.id != other.id ) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return new StringBuilder().append( "Game #:" ).append( id ).append( " Player 1: " ).append( player1.toString() ).append( " Player 2: " ).append( player2.toString() ).toString();
    }

}
