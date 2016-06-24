/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bentest.model;

/**
 *
 * @author ben.schellenberger
 */
public class Player {

    private long playerId;

    private String firstName;

    private String lastName;

    private String alias;

    private boolean displayAliasOnly;

    private String age;

    public Player() {

    }

    public Player( long playerId, String firstName, String lastName, String alias, boolean displayAliasOnly, String age ) {
        this.playerId = playerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.alias = alias;
        this.displayAliasOnly = displayAliasOnly;
        this.age = age;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId( long playerId ) {
        this.playerId = playerId;
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

    public String getAlias() {
        return alias;
    }

    public void setAlias( String alias ) {
        this.alias = alias;
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

}
