/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bentest.controllers;

import com.bentest.model.Player;
import com.bentest.services.PlayerService;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.pojo.ApiStage;
import org.jsondoc.core.pojo.ApiVisibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ben.schellenberger
 */
@RestController
@Api( name = "Player Services", description = "Methods for managing players", group = "Players", visibility = ApiVisibility.PUBLIC, stage = ApiStage.ALPHA )
@RequestMapping( "/players" )
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @RequestMapping( value = "/strings", method = RequestMethod.GET )
    public List<String> getStrings() {
        return Arrays.asList( new String[]{ "wsdafdasfsadfsadffasdfsadee", "pwpo" } );
    }

    @RequestMapping( value = "/getplayer/{id}", method = RequestMethod.GET )
    public ResponseEntity<Player> getPlayerById( @PathVariable( "id" ) long id ) {
        Player player = playerService.getPlayerById( id );
        if ( player == null ) {
            System.out.println( "player with id " + id + " not found" );
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        }
        return new ResponseEntity<>( player, HttpStatus.OK );
    }

    @RequestMapping( value = "/saveplayer", method = RequestMethod.POST )
    public ResponseEntity<Player> savePlayer( @RequestBody Player player, UriComponentsBuilder ucBuilder ) {

        playerService.savePlayer( player );

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation( ucBuilder.path( "/getplayer/{id}" ).buildAndExpand( player.getId() ).toUri() );
        return new ResponseEntity<>( player, HttpStatus.CREATED );
    }

    @RequestMapping( value = "/listplayers", method = RequestMethod.GET )
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> players = playerService.getAllPlayers();
        if ( players == null || players.isEmpty() ) {
            return new ResponseEntity<>( HttpStatus.NO_CONTENT );
        }
        return new ResponseEntity<>( players, HttpStatus.OK );
    }

    @RequestMapping( value = "/delete/{id}", method = RequestMethod.GET )
    public ResponseEntity<Player> deletePlayerById( @PathVariable( "id" ) long id ) {
        Player player = playerService.getPlayerById( id );
        if ( player == null ) {
            System.out.println( "player with id " + id + " not found" );
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        }
        playerService.deletePlayerById( id );
        return new ResponseEntity<>( player, HttpStatus.OK );
    }

    @RequestMapping( value = "/findplayerbyfname/{firstName}", method = RequestMethod.GET )
    public ResponseEntity<List<Player>> getFindPlayersByFirstName( @PathVariable( "firstName" ) String firstName ) {
        List<Player> players = playerService.findPlayerByFirstName( firstName );
        if ( players == null || players.isEmpty() ) {
            return new ResponseEntity<>( HttpStatus.NO_CONTENT );
        }
        return new ResponseEntity<>( players, HttpStatus.OK );
    }

    @RequestMapping( value = "/findplayerbylname/{lastName}", method = RequestMethod.GET )
    public ResponseEntity<List<Player>> getFindPlayersByLastName( @PathVariable( "lastName" ) String lastName ) {
        List<Player> players = playerService.findPlayerByLastName( lastName );
        if ( players == null || players.isEmpty() ) {
            return new ResponseEntity<>( HttpStatus.NO_CONTENT );
        }
        return new ResponseEntity<>( players, HttpStatus.OK );
    }

}
