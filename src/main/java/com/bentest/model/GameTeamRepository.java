/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bentest.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ben.schellenberger
 */
public interface GameTeamRepository extends CrudRepository<GameTeam, Long> {

    @Query( "select gt from GameTeam gt where ?1 member of gt.teamPlayers AND ?2 member of gt.teamPlayers" )
    public GameTeam findTeamByPlayers( Player player1, Player player2 );

}
