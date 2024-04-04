package br.com.codelicious.lolchampions.domain.ports;

import br.com.codelicious.lolchampions.domain.model.Champions;

import java.util.List;
import java.util.Optional;

public interface ChampionsRepository {
    List<Champions> findAll();
    Optional<Champions> findOne(Long id);
}
