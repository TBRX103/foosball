/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bentest.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author ben.schellenberger
 */
@Entity
public class Player implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private long id;

    private String firstName;

    private String lastName;

    private String playerAlias;

    private boolean displayAliasOnly;

    private String age;

    public Player() {

    }

    public Player( String firstName, String lastName, String alias, boolean displayAliasOnly, String age ) {
        this.id = -1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.playerAlias = alias;
        this.displayAliasOnly = displayAliasOnly;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId( long id ) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName( String firstName ) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName( String lastName ) {
        this.lastName = lastName;
    }

    public String getPlayerAlias() {
        return playerAlias;
    }

    public void setPlayerAlias( String playerAlias ) {
        this.playerAlias = playerAlias;
    }

    public boolean isDisplayAliasOnly() {
        return displayAliasOnly;
    }

    public void setDisplayAliasOnly( boolean displayAliasOnly ) {
        this.displayAliasOnly = displayAliasOnly;
    }

    public String getAge() {
        return age;
    }

    public void setAge( String age ) {
        this.age = age;
    }

    @Override
    public String toString() {
        return new StringBuilder().append( firstName ).append( " " ).append( lastName ).append( " Age:" ).append( age ).toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (int) ( this.id ^ ( this.id >>> 32 ) );
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
        final Player other = (Player) obj;
        if ( this.id != other.id ) {
            return false;
        }
        return true;
    }

}
