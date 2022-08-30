package com.pp.demo.controller;

import com.pp.demo.data.NBAPlayer;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.pp.demo.service.PlayerService;

import java.util.ArrayList;
import java.util.List;

//@CrossOrigin(origins="https://balldontlie.io/api/v1")
//@CrossOrigin(allowedHeaders ="true")
@RestController
@RequestMapping("/players")
public class PlayerController {
    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService=playerService;
    }

//    @CrossOrigin(origins = "http://localhost:8080", allowedHeaders ="true")
    @GetMapping("/list")
    public Iterable<NBAPlayer> playersList() {
        return playerService.list();
    }

//    @ModelAttribute
//    public void getPlayerList(Model model) {
//        List<NBAPlayer> nbaPlayerList = new ArrayList<>();
//
//    }
}
