/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bentest.services;

import com.bentest.model.Game;
import java.util.Set;

/**
 *
 * @author ben.schellenberger
 */
public interface GameService {

    public Set<Game> getAllGames();

    public Game getGameById( long id );

    public Game saveGame( Game game );

}
