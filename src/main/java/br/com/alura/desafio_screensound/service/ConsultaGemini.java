package br.com.alura.desafio_screensound.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

public class ConsultaGemini {
    private static final String CHAVE = System.getenv("GEMINI_APIKEY");

    public static String obterInformacao(String texto) {
        Client client = Client.builder().apiKey(CHAVE).build();

        GenerateContentResponse response =
                client.models.generateContent(
                        "gemini-2.0-flash",
                        "Me fale sobre o artista em um texto de um parágrafo: " + texto,
                        null);

        return response.text();
    }
}