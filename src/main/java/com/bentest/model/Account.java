/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bentest.model;

import org.jsondoc.core.annotation.ApiObject;

/**
 *
 * @author ben.schellenberger
 */
@ApiObject( description = "An object for accounts" )
public class Account {

    private int playerId;

    private String account;

    private String hashword;

    private String email;

}
