/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bentest.services;

import com.bentest.model.Player;
import java.util.List;

/**
 *
 * @author ben.schellenberger
 */
public interface PlayerService {

    public List<Player> getAllPlayers();

    public Player savePlayer( Player player );

    public Player getPlayerById( long id );

    public void deletePlayerById( long id );

}
