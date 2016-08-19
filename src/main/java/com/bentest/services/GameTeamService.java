/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bentest.services;

import com.bentest.model.GameTeam;
import com.bentest.model.Player;

/**
 *
 * @author ben.schellenberger
 */
public interface GameTeamService {

    public GameTeam findGameTeamByPlayers( Player player1, Player player2 );

    public GameTeam saveGameTeam( GameTeam team );

    public GameTeam findById( long id );

}
