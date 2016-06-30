/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bentest.services;

import com.bentest.model.Player;
import com.bentest.model.PlayerRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ben.schellenberger
 */
@Service( "playerService" )
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    static PlayerRepository playerRepository;

    static {
        populateDummyPlayers();
    }

    private static List<Player> populateDummyPlayers() {
        List<Player> list = new ArrayList<>();

        playerRepository.save( new Player( "Barry", "Morris", "BMoore", false, "26" ) );
        playerRepository.save( new Player( "Phillip", "Morris", "Cancer Man", false, "48" ) );
        playerRepository.save( new Player( "Jerry", "Stamos", "SuperMan", false, "38" ) );
        playerRepository.save( new Player( "Peter", "Lancaster", "Slick Texas Pete", false, "55" ) );
        playerRepository.save( new Player( "Sneaky", "Snarfer", "SNARF!", false, "14" ) );

        return list;
    }

    @Override
    public List<Player> getAllPlayers() {
        return Lists.newArrayList( playerRepository.findAll() );
    }

    @Override
    public Player savePlayer( Player player ) {
        return playerRepository.save( player );
    }

    @Override
    public Player getPlayerById( long id ) {
        for ( Player player : getAllPlayers() ) {
            if ( player.getId() == id ) {
                return player;
            }
        }
        return null;
    }

    @Override
    public void deletePlayerById( long id ) {
        playerRepository.delete( id );

    }

}
