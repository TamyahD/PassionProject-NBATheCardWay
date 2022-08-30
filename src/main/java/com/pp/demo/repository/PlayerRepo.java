package com.pp.demo.repository;

import com.pp.demo.data.NBAPlayer;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepo extends CrudRepository<NBAPlayer, Integer> {

}
