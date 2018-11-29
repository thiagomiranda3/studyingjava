package br.com.tommiranda.io;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class CopiandoArquivos {

    public static void main(String[] args) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("mm-ss");
        LocalDateTime agora = LocalDateTime.now();

        List<String> linhas = Arrays.asList("Thiago Miranda", "Dayane Silva");

        Path path = Paths.get("teste-" + agora.format(fmt) + ".txt");

        try {
            Files.write(path, linhas, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
