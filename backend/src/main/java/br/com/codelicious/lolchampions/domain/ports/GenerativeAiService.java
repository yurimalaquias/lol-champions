package br.com.codelicious.lolchampions.domain.ports;

public interface GenerativeAiService {
    String generateContent(String objetive, String context);
}
