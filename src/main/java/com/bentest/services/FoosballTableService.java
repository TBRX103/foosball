/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bentest.services;

import com.bentest.model.FoosballTable;
import org.springframework.stereotype.Service;
import java.util.Set;

/**
 *
 * @author ben.schellenberger
 */
@Service( "foosballTableService" )
public interface FoosballTableService {

    public FoosballTable getGameTable( long id );

    public FoosballTable saveGameTable( FoosballTable gameTable );

    public Set<Long> getFoosballTableIds();
}
