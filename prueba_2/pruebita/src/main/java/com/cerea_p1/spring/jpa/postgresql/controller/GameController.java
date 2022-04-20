package com.cerea_p1.spring.jpa.postgresql.controller;

//import ex.com.challenge.dto.ConnectRequest;
import com.cerea_p1.spring.jpa.postgresql.exception.GameException;
import com.cerea_p1.spring.jpa.postgresql.model.game.*;
import com.cerea_p1.spring.jpa.postgresql.payload.request.game.CreateGameRequest;
import com.cerea_p1.spring.jpa.postgresql.payload.request.game.ConnectRequest;
import com.cerea_p1.spring.jpa.postgresql.security.services.GameService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.*;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/game")
public class GameController {
    private final GameService gameService = new GameService();
    private final SimpMessagingTemplate simpMessagingTemplate = null ;

    private static final Logger logger = Logger.getLogger("MyLog");

    @PostMapping("/create")
    public ResponseEntity<Partida> crear(@RequestBody CreateGameRequest request) {
        logger.info("create game request by " + request.getPlayerName());
        return ResponseEntity.ok(gameService.crearPartida(new Jugador(request.getPlayerName())));
    }

    @PostMapping("/connect")
    public ResponseEntity<Partida> connect(@RequestBody ConnectRequest request) throws GameException {
        logger.info("connect request by " + request.getPlayerName());
        return ResponseEntity.ok(gameService.connectToGame(new Jugador(request.getPlayerName()), request.getGameId()));
    }

    /*@PostMapping("/connect/random")
    public ResponseEntity<Game> connectRandom(@RequestBody Player player) throws GameException{
        log.info("connect random {}", player);
        return ResponseEntity.ok(gameService.connectToRandomGame(player));
    }*/

  /*  @PostMapping("/sow")
    public ResponseEntity<Partida> sow(@RequestBody Sow sow) throws GameException {
        logger.info("sow: {}", sow);
        Partida game = gameService.sow(sow);

        simpMessagingTemplate.convertAndSend("/topic/game-progress/" + game.getId(), game);
        return ResponseEntity.ok(game);
    }*/
}