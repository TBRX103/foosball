/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bentest.controllers;

import com.bentest.model.FoosballGame;
import com.bentest.model.GameTeam;
import com.bentest.model.Player;
import com.bentest.services.FoosballTableService;
import com.bentest.services.GameService;
import com.bentest.services.GameTeamService;
import com.bentest.services.PlayerService;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.pojo.ApiStage;
import org.jsondoc.core.pojo.ApiVisibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author ben.schellenberger
 */
@RestController
@Api( name = "Demonstration Services", description = "Methods for creating demonstration and testing", group = "Demo", visibility = ApiVisibility.PUBLIC, stage = ApiStage.ALPHA )
@RequestMapping( "/demo" )
public class DemoController {

    private static boolean randomDataInitialized = false;
    private static final int DEMO_PLAYER_COUNT = 50;

    private static Random random = new Random();
    @Autowired
    GameService gameService;

    @Autowired
    ResourceLoader resourceLoader;

    @Autowired
    PlayerService playerService;

    @Autowired
    FoosballTableService gameTableService;

    @Autowired
    GameTeamService gameTeamService;

    @RequestMapping( value = "/makegame", method = RequestMethod.GET )
    public ResponseEntity<Void> makeTestGame( UriComponentsBuilder ucBuilder ) {
        FoosballGame game = new FoosballGame();
        Player pl = playerService.getPlayerById( 1 );
        Player p2 = playerService.getPlayerById( 2 );
        Player p3 = playerService.getPlayerById( 3 );
        Player p4 = playerService.getPlayerById( 4 );

        GameTeam team1 = gameTeamService.findGameTeamByPlayers( pl, p2 );
        GameTeam team2 = gameTeamService.findGameTeamByPlayers( p3, p4 );

        game.setTeam1( team1 );
        game.setTeam2( team2 );
        game.setFoosballTable( gameTableService.getGameTable( 1 ) );

        FoosballGame savedGame = gameService.saveGame( game );
        HttpHeaders headers = new HttpHeaders();
        if ( savedGame != null ) {
            headers.setLocation( ucBuilder.path( "/game/{id}" ).buildAndExpand( savedGame.getId() ).toUri() );
            return new ResponseEntity<>( headers, HttpStatus.CREATED );
        } else {
            return new ResponseEntity<>( headers, HttpStatus.BAD_REQUEST );
        }
    }

    @RequestMapping( value = "/createRandomizedData", method = RequestMethod.GET )
    public ResponseEntity<Void> createRandomizedData() {
        if ( !randomDataInitialized ) {
            random = new Random();
            //Create 50 players.

            List<String> firstNames = getDemoNames( DEMO_PLAYER_COUNT, FirstName.getNames() );
            List<String> lastNames = getDemoNames( DEMO_PLAYER_COUNT, LastName.getNames() );

            randomDataInitialized = true;
        }
        return new ResponseEntity<>( HttpStatus.CREATED );
    }

    private List<String> getDemoNames( int count, List<String> nameList ) {
        List<String> newList = new ArrayList<>();

        int maxSize = nameList.size();
        while ( newList.size() < count ) {
            int location = random.nextInt( maxSize + 1 );
            String name = nameList.get( location );
            if ( name == null || name.trim().isEmpty() ) {
                continue;
            }
            newList.add( name.trim() );
        }

        return newList;

    }

}
