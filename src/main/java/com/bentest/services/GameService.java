/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bentest.services;

import com.bentest.model.FoosballGame;
import java.util.Set;

/**
 *
 * @author ben.schellenberger
 */
public interface GameService {

    public Set<FoosballGame> getAllGames();

    public FoosballGame getGameById( long id );

    public FoosballGame saveGame( FoosballGame game );

}
