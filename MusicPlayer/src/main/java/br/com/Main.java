package br.com;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Função para carregar e abrir uma música
    public static Clip carregarMusica(String caminho)
            throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        File file = new File(caminho);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);

        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        return clip;
    }

    public static void main(String[] args) {

        // LISTA DE MÚSICAS ----------------------------------------------
        List<String> playlist = new ArrayList<>();
        playlist.add("src/musicas/POISON-Apricot.wav");
        playlist.add("src/musicas/Every-Baby-Needs-A-Da-Da-Daddy-Marilyn-Monroe-「-Cover-by-Michi-Mochievee-」.wav");
        playlist.add("src/musicas/I-Hate-Everything-About-You-__-Female-Cover-_1.wav");
        playlist.add("src/musicas/【MV】Rainy-Day-Apricot-ft.-Zentreya【COVER】.wav");
        // adicione quantas quiser

        int index = 0; // música atual
        Clip clip = null;

        try (Scanner sc = new Scanner(System.in)) {

            clip = carregarMusica(playlist.get(index));

            String response = "";

            while (!response.equals("Q")) {

                System.out.println("\nMúsica atual: " + playlist.get(index));
                System.out.println("P = Play");
                System.out.println("S = Stop");
                System.out.println("R = Reset");
                System.out.println("N = Next");
                System.out.println("B = Back");
                System.out.println("Q = Quit");
                System.out.print("Escolha a opção: ");
                response = sc.nextLine().toUpperCase();

                switch (response) {
                    case "P" -> clip.start();
                    case "S" -> clip.stop();
                    case "R" -> clip.setMicrosecondPosition(0);

                    case "N" -> { // próxima música
                        clip.stop();
                        clip.close();
                        index = (index + 1) % playlist.size(); // loop infinito
                        clip = carregarMusica(playlist.get(index));
                        clip.start();
                    }

                    case "B" -> { // música anterior
                        clip.stop();
                        clip.close();
                        index = (index - 1 + playlist.size()) % playlist.size(); // evita número negativo
                        clip = carregarMusica(playlist.get(index));
                        clip.start();
                    }

                    case "Q" -> {
                        clip.stop();
                        clip.close();
                    }

                    default -> System.out.println("Opção inválida!");
                }
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("Fim do programa.");
    }
}
