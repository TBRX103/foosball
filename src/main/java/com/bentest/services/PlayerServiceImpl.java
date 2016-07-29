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
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author ben.schellenberger
 */
@Service( "playerService" )
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @PostConstruct
    private void populateDummyPlayers() {
        playerRepository.save( new Player( "Barry", "Morris", "BMoore", false, "26" ) );
        playerRepository.save( new Player( "Phillip", "Morris", "Cancer Man", false, "48" ) );
        playerRepository.save( new Player( "Jerry", "Stamos", "SuperMan", false, "38" ) );
        playerRepository.save( new Player( "Peter", "Lancaster", "Slick Texas Pete", false, "55" ) );
        playerRepository.save( new Player( "Sneaky", "Snarfer", "SNARF!", false, "14" ) );
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
        return playerRepository.findOne( id );
//        for ( Player player : getAllPlayers() ) {
//            if ( player.getId() == id ) {
//                return player;
//            }
//        }
//        return null;
    }

    @Override
    public void deletePlayerById( long id ) {
        playerRepository.delete( id );
    }

    @Override
    public List<Player> findPlayerByFirstName( String firstName ) {
        return playerRepository.findByFirstName( firstName );
    }

    @Override
    public List<Player> findPlayerByLastName( String lastName ) {
        return playerRepository.findByLastName( lastName );
    }

}
