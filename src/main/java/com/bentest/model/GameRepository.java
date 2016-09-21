/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bentest.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.Set;

/**
 *
 * @author ben.schellenberger
 */
public interface GameRepository extends CrudRepository<FoosballGame, Long> {

    public FoosballGame findGameById( long id );

    @Query( value = "SELECT g FROM FoosballGame g WHERE team1 = ?1 OR team2 = ?1 " )
    public Set<FoosballGame> findAllGamesByTeam( GameTeam team );

    @Query( value = "SELECT g FROM FoosballGame g WHERE (team1 = ?1 AND team2 = ?2) OR (team1 = ?2 AND team2 = ?1) " )
    public Set<FoosballGame> findAllGamesBetweenTeams( GameTeam team1, GameTeam team2 );

}
