/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bentest.services;

import com.bentest.model.GameTable;
import org.springframework.stereotype.Service;

/**
 *
 * @author ben.schellenberger
 */
@Service( "gameTableService" )
public interface GameTableService {

    public GameTable getGameTable( long id );

    public GameTable saveGameTable( GameTable gameTable );
}
