package br.com.codelicious.lolchampions.application;

import br.com.codelicious.lolchampions.domain.exception.ChampionNotFoundException;
import br.com.codelicious.lolchampions.domain.model.Champions;
import br.com.codelicious.lolchampions.domain.ports.ChampionsRepository;
import br.com.codelicious.lolchampions.domain.ports.GenerativeAiService;

public record AskChampionUseCase(ChampionsRepository repository, GenerativeAiService genAiService) {
    public String askChampion(Long championId, String question) {
        Champions champion = repository.findOne(championId)
                .orElseThrow(() -> new ChampionNotFoundException(championId));

        String championContext = champion.generateContextByQuestion(question);
        String objective = """
                Atue como um assistente com a habilidade de se comportar como os Champeões do League of Legends.
                Responda perguntas incorporando a personalidade e estilo de um determinado Campeão.
                Segue a pergunta, o nome do Campeão e sua respectiva lore:
                 
                """;

        return genAiService.generateContent(objective, championContext);
    }
}
