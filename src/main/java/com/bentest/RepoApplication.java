/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bentest;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RepoApplication {
//
//    @Autowired
//    PlayerService playerService;
//
//    @Autowired
//    GameService gameService;
//    private static final Logger log = LoggerFactory.getLogger( RepoApplication.class );
//
//    public static void main( String[] args ) {
//        SpringApplication.run( RepoApplication.class );
//    }
//
//    @Bean
//    public CommandLineRunner demo() {
//        return (args) -> {
//            {
//
//                Game g = new Game();
//                g.setPlayer1( playerService.getPlayerById( 1 ) );
//                g.setPlayer2( playerService.getPlayerById( 2 ) );
//                g.setGameTable( new GameTable() );
//
//                gameService.saveGame( g );
//            }
//            Set<Game> games = gameService.getAllGames();
//
//            for ( Game g : games ) {
//                System.out.println( g );
//            }
//
//        };
//    }
//
//    @Bean
//    public CommandLineRunner demo( PlayerRepository repository ) {
//        return (args) -> {
//            // save a couple of customers
//
//            for ( Player player : playerService.getAllPlayers() ) {
//                repository.save( player );
//            }
//
//            // fetch all customers
//            log.info( "Players found with findAll():" );
//            log.info( "-------------------------------" );
//            for ( Player player : repository.findAll() ) {
//                log.info( player.toString() );
//            }
//            log.info( "" );
//
//            // fetch an individual customer by ID
//            Player player = repository.findOne( 1L );
//            log.info( "Players found with findOne(1L):" );
//            log.info( "--------------------------------" );
//            log.info( player.toString() );
//            log.info( "" );
//
//            // fetch customers by last name
//            log.info( "Customer found with findByLastName('Morris'):" );
//            log.info( "--------------------------------------------" );
//            for ( Player morris : repository.findByLastName( "Morris" ) ) {
//                log.info( morris.toString() );
//            }
//            log.info( "" );
//
//            // fetch customers by last name
//            log.info( "Customer found with searchByLastName('ri'):" );
//            log.info( "--------------------------------------------" );
//            for ( Player ri : repository.searchByLastName( "%ri%" ) ) {
//                log.info( ri.toString() );
//            }
//            log.info( "" );
//        };
//    }
}
