/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bentest;

import com.bentest.model.Player;
import com.bentest.model.PlayerRepository;
import com.bentest.services.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RepoApplication {

    @Autowired
    PlayerService playerService;
    private static final Logger log = LoggerFactory.getLogger( RepoApplication.class );

    public static void main( String[] args ) {
        SpringApplication.run( RepoApplication.class );
    }

    @Bean
    public CommandLineRunner demo( PlayerRepository repository ) {
        return (args) -> {
            // save a couple of customers

            for ( Player player : playerService.getAllPlayers() ) {
                repository.save( player );
            }

            // fetch all customers
            log.info( "Players found with getAll():" );
            log.info( "-------------------------------" );
            for ( Player player : playerService.getAllPlayers() ) {
                log.info( player.toString() );
            }
            log.info( "" );

            // fetch an individual customer by ID
            Player player = repository.findOne( 1L );
            log.info( "Players found with findOne(1L):" );
            log.info( "--------------------------------" );
            log.info( player.toString() );
            log.info( "" );

            // fetch customers by last name
            log.info( "Customer found with findByLastName('Bauer'):" );
            log.info( "--------------------------------------------" );
            for ( Player morris : repository.findByLastName( "Morris" ) ) {
                log.info( morris.toString() );
            }
            log.info( "" );
        };
    }

}
