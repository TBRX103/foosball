/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bentest.controllers;

import com.bentest.model.FoosballGame;
import com.bentest.services.GameService;
import com.bentest.services.FoosballTableService;
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

/**
 *
 * @author ben.schellenberger
 */
@RestController
@Api( name = "Game Services", description = "Methods for managing games", group = "Players", visibility = ApiVisibility.PUBLIC, stage = ApiStage.ALPHA )
@RequestMapping( "/game" )
public class GameController {

    @Autowired
    GameService gameService;

    @Autowired
    PlayerService playerService;

    @Autowired
    FoosballTableService gameTableService;

    @RequestMapping( value = "/save", method = RequestMethod.POST )
    public ResponseEntity<FoosballGame> saveGame( @RequestBody FoosballGame game, UriComponentsBuilder ucBuilder ) {
        FoosballGame savedGame = gameService.saveGame( game );
        HttpHeaders headers = new HttpHeaders();
        if ( savedGame != null ) {
            headers.setLocation( ucBuilder.path( "/game/{id}" ).buildAndExpand( savedGame.getId() ).toUri() );
            return new ResponseEntity<>( savedGame, HttpStatus.CREATED );
        } else {
            return new ResponseEntity<>( headers, HttpStatus.BAD_REQUEST );
        }
    }

    @RequestMapping( value = "/game/{id}", method = RequestMethod.GET )
    public ResponseEntity<FoosballGame> getGameById( @PathVariable( "id" ) long id ) {
        FoosballGame game = gameService.getGameById( id );
        if ( game == null ) {
            System.out.println( "game with id " + id + " not found" );
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        }
        return new ResponseEntity<>( game, HttpStatus.OK );
    }

}
