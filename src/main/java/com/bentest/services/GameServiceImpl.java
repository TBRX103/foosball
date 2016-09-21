/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bentest.services;

import com.bentest.model.FoosballGame;
import com.bentest.model.GameRepository;
import com.bentest.model.GameTeam;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;

/**
 *
 * @author ben.schellenberger
 */
@Service( "gameService" )
public class GameServiceImpl implements GameService {

    @Autowired
    GameRepository gameRepository;

    public GameServiceImpl() {

    }

    @Override
    public Set<FoosballGame> getAllGames() {
        return Sets.newHashSet( gameRepository.findAll() );
    }

    @Override
    public FoosballGame getGameById( long id ) {
        return gameRepository.findGameById( id );
    }

    @Override
    public FoosballGame saveGame( FoosballGame game ) {
        return gameRepository.save( game );
    }

    @Override
    public Set<FoosballGame> findAllGamesByTeam( GameTeam team ) {
        return gameRepository.findAllGamesByTeam( team );
    }

    @Override
    public Set<FoosballGame> findAllGamesBetweeTeams( GameTeam team1, GameTeam team2 ) {
        return gameRepository.findAllGamesBetweenTeams( team1, team2 );
    }

}
