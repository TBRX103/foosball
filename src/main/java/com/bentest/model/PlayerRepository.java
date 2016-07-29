/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bentest.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 *
 * @author ben.schellenberger
 */
public interface PlayerRepository extends CrudRepository<Player, Long> {

    @Query( value = "SELECT p FROM Player p WHERE UPPER(p.lastName) = UPPER(?1) " )
    List<Player> findByLastName( String lastName );

    @Query( value = "SELECT p FROM Player p WHERE UPPER(p.firstName) = UPPER(?1) " )
    List<Player> findByFirstName( String firstName );

}
