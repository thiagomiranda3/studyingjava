package br.com.tommiranda.nio;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class CriandoDiretorioEArquivo {

    public static void main(String[] args) {
        DateTimeFormatter minsecFmt = DateTimeFormatter.ofPattern("mm-ss");
        DateTimeFormatter diamesFmt = DateTimeFormatter.ofPattern("dd-MM");
        LocalDateTime agora = LocalDateTime.now();

        List<String> linhas = Arrays.asList("Thiago Miranda", "Dayane Silva");

        Path path = Paths.get("teste-" + agora.format(minsecFmt) + ".txt");

        try {
            Path dir = Files.createDirectories(Paths.get(agora.format(diamesFmt)));
            Files.write(dir.resolve(path), linhas, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
