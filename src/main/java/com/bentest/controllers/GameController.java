/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bentest.controllers;

import com.bentest.model.FoosballGame;
import com.bentest.model.GameTeam;
import com.bentest.services.FoosballTableService;
import com.bentest.services.GameService;
import com.bentest.services.GameTeamService;
import com.bentest.services.PlayerService;
import org.apache.commons.lang.StringUtils;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

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

    @Autowired
    GameTeamService gameTeamService;

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

    @RequestMapping( value = "/gamestats/{team1}", method = RequestMethod.GET )
    @ResponseBody
    public ResponseEntity<String> getGameStatsForTeam( @PathVariable( "team1" ) long team1 ) {
        GameTeam t1 = gameTeamService.findById( team1 );
        if ( t1 == null ) {
            System.out.println( "team with id " + team1 + " not found" );
            return new ResponseEntity<>( "team with id " + team1 + " not found", HttpStatus.NOT_FOUND );
        }

        int total = 0;
        int wins = 0;
        int losses = 0;

        Set<FoosballGame> games = gameService.findAllGamesByTeam( t1 );
        List<Long> ids = new ArrayList<>();
        for ( FoosballGame game : games ) {
            ids.add( game.getId() );
            total++;
            if ( t1 == game.getWinningTeam() ) {
                wins++;
            } else {
                losses++;
            }
        }
        Collections.sort( ids );
        StringBuilder str = new StringBuilder();
        str.append( " Team " ).append( t1.getTeamName() ).append( ": " );
        str.append( "Wins: " ).append( wins ).append( " Losses: " ).append( losses ).append( " Total: " ).append( total );
        str.append( " IDs: " );
        str.append( StringUtils.join( ids, ", " ) );
        return new ResponseEntity<>( str.toString(), HttpStatus.OK );
    }

    @RequestMapping( value = "/gamestats/{team1}/{team2}", method = RequestMethod.GET )
    @ResponseBody
    public ResponseEntity<String> getGameStatsBetweenTeams( @PathVariable( "team1" ) long team1, @PathVariable( "team2" ) long team2 ) {
        GameTeam t1 = gameTeamService.findById( team1 );
        GameTeam t2 = gameTeamService.findById( team2 );
        if ( t1 == null ) {
            System.out.println( "team with id " + team1 + " not found" );
            return new ResponseEntity<>( "team with id " + team1 + " not found", HttpStatus.NOT_FOUND );
        }

        if ( t2 == null ) {
            System.out.println( "team with id " + team2 + " not found" );
            return new ResponseEntity<>( "team with id " + team2 + " not found", HttpStatus.NOT_FOUND );
        }

        int total = 0;
        int team1Wins = 0;
        int team2Wins = 0;
        List<Long> ids = new ArrayList<>();
        Set<FoosballGame> games = gameService.findAllGamesBetweeTeams( t1, t2 );
        for ( FoosballGame game : games ) {
            ids.add( game.getId() );
            total++;
            if ( t1 == game.getWinningTeam() ) {
                team1Wins++;
            } else {
                team2Wins++;
            }
        }
        Collections.sort( ids );
        StringBuilder str = new StringBuilder();
        str.append( " Team " ).append( t1.getTeamName() ).append( ": " );
        str.append( "Team 1 Wins: " ).append( team1Wins ).append( " Team 2 Wins: " ).append( team2Wins ).append( " Total: " ).append( total );
        str.append( " IDs: " );
        str.append( StringUtils.join( ids, ", " ) );
        return new ResponseEntity<>( str.toString(), HttpStatus.OK );
    }

}
