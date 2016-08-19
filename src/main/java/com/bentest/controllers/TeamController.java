/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bentest.controllers;

import com.bentest.model.GameTeam;
import com.bentest.services.GameTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ben.schellenberger
 */
@RequestMapping( "/team" )
public class TeamController {

    @Autowired
    GameTeamService gameTeamService;

    @RequestMapping( value = "/{id}", method = RequestMethod.GET )
    public ResponseEntity<GameTeam> getTeamById( @PathVariable( "id" ) long id ) {
        GameTeam team = gameTeamService.findById( id );
        if ( team == null ) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        } else {
            return new ResponseEntity<>( team, HttpStatus.OK );
        }
    }

    @RequestMapping( value = "/{id}/setTitle/{name}", method = RequestMethod.GET )
    public ResponseEntity<GameTeam> setTeamName( @PathVariable( "id" ) long id, @PathVariable( "name" ) String name ) {
        GameTeam team = gameTeamService.findById( id );
        if ( team == null ) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        } else {
            team.setTeamName( name );
            gameTeamService.saveGameTeam( team );
            return new ResponseEntity<>( team, HttpStatus.OK );
        }
    }

}
