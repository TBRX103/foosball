/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bentest.services;

import com.bentest.model.GameTable;
import com.bentest.model.GameTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

/**
 *
 * @author ben.schellenberger
 */
@Service( "gameTableService" )
public class GameTableServiceImpl implements GameTableService {

    @Autowired
    GameTableRepository gameTableRepository;

    @Override
    public GameTable getGameTable( long id ) {
        return gameTableRepository.findById( id );
    }

    @Override
    public GameTable saveGameTable( GameTable gameTable ) {
        return gameTableRepository.save( gameTable );
    }

    @PostConstruct
    private void populateDemoData() {
        GameTable table = new GameTable();
        table.setDescription( "The main foosball table made of real wood and features a red and blue team." );
        table.setName( "Main Foosball Table" );
        gameTableRepository.save( table );

        table = new GameTable();
        table.setDescription( "The secondary foosball table made of particle board and features a silver and black team." );
        table.setName( "Secondary Foosball Table" );
        gameTableRepository.save( table );
    }

}
