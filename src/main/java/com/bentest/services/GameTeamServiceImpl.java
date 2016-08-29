/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bentest.services;

import com.bentest.model.GameTeam;
import com.bentest.model.GameTeamRepository;
import com.bentest.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;

/**
 *
 * @author ben.schellenberger
 */
@Service( "gameTeamService" )
public class GameTeamServiceImpl implements GameTeamService {

    @Autowired
    GameTeamRepository gameTeamRepository;

    @Override
    public GameTeam findGameTeamByPlayers( Player player1, Player player2 ) {
        GameTeam team = gameTeamRepository.findTeamByPlayers( player1, player2 );
        if ( team == null ) {
            team = new GameTeam();
            team.addTeamPlayer( player1 );
            team.addTeamPlayer( player2 );
            team = gameTeamRepository.save( team );
        }
        return team;
    }

    @Override
    public GameTeam saveGameTeam( GameTeam team ) {
        return gameTeamRepository.save( team );
    }

    @Override
    public GameTeam findById( long id ) {
        return gameTeamRepository.findOne( id );
    }

    @Override
    public Set<Long> getAllTeamIds() {
        return gameTeamRepository.getAllTeamIds();
    }

}
