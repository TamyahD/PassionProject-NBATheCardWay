package com.pp.demo.service;

import com.pp.demo.data.NBAPlayer;
import com.pp.demo.repository.PlayerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    private PlayerRepo playerRepo;

    public PlayerService(PlayerRepo playerRepo) {
        this.playerRepo=playerRepo;
    }

    public Iterable<NBAPlayer> list() {
        return playerRepo.findAll();
    }

    public NBAPlayer save(NBAPlayer player) {
        return playerRepo.save(player);
    }

    public Iterable<NBAPlayer> save(List<NBAPlayer> players) {
        return playerRepo.saveAll(players);
    }
}
