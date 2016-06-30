/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bentest.model;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ben.schellenberger
 */
public interface GameTableRepository extends CrudRepository<GameTable, Long> {

    public GameTable findById( long tableId );

}
