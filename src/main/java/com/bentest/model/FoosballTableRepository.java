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
public interface FoosballTableRepository extends CrudRepository<FoosballTable, Long> {

    public FoosballTable findById( long tableId );

    @Query( "SELECT ft.id from FoosballTable ft" )
    public Set<Long> getFoosballTableIds();

}
