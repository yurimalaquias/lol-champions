package br.com.codelicious.lolchampions.application;

import br.com.codelicious.lolchampions.domain.model.Champions;
import br.com.codelicious.lolchampions.domain.ports.ChampionsRepository;

import java.util.List;

public record ListChampionsUseCase(ChampionsRepository repository) {
    public List<Champions> findAll() {
        return repository.findAll();
    }
}
