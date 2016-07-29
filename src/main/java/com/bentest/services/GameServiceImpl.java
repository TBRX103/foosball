/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bentest.services;

import com.bentest.model.Game;
import com.bentest.model.GameRepository;
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
    public Set<Game> getAllGames() {
        return Sets.newHashSet( gameRepository.findAll() );
    }

    @Override
    public Game getGameById( long id ) {
        return gameRepository.findGameById( id );
    }

    @Override
    public Game saveGame( Game game ) {
        return gameRepository.save( game );
    }

}
