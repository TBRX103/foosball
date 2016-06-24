/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bentest.services;

import com.bentest.model.Player;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author ben.schellenberger
 */
@Service( "playerService" )
public class PlayerServiceImpl implements PlayerService {

    private static final AtomicLong counter = new AtomicLong();
    private static final List<Player> players;

    static {
        players = populateDummyPlayers();
    }

    private static List<Player> populateDummyPlayers() {
        List<Player> list = new ArrayList<>();

        list.add( new Player( counter.incrementAndGet(), "Barry", "Morris", "BMoore", false, "26" ) );
        list.add( new Player( counter.incrementAndGet(), "Phillip", "Morris", "Cancer Man", false, "48" ) );
        list.add( new Player( counter.incrementAndGet(), "Jerry", "Stamos", "SuperMan", false, "38" ) );
        list.add( new Player( counter.incrementAndGet(), "Peter", "Lancaster", "Slick Texas Pete", false, "55" ) );
        list.add( new Player( counter.incrementAndGet(), "Sneaky", "Snarfer", "SNARF!", false, "14" ) );

        return list;
    }

    @Override
    public List<Player> getAllPlayers() {
        return players;
    }

    @Override
    public void savePlayer( Player player ) {
        player.setPlayerId( counter.incrementAndGet() );
        players.add( player );
    }

    @Override
    public Player getPlayerById( long id ) {
        for ( Player player : players ) {
            if ( player.getPlayerId() == id ) {
                return player;
            }
        }
        return null;
    }

    @Override
    public void deletePlayerById( long id ) {
        players.remove( getPlayerById( id ) );

    }

}
