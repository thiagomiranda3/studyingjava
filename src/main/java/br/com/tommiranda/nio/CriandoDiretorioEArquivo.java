package br.com.tommiranda.nio;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class CriandoDiretorioEArquivo {

    public static void main(String[] args) {
        var minsecFmt = DateTimeFormatter.ofPattern("mm-ss");
        var diamesFmt = DateTimeFormatter.ofPattern("dd-MM");
        var agora = LocalDateTime.now();

        var linhas = Arrays.asList("Thiago Miranda", "Dayane Silva");

        var path = Paths.get("teste-" + agora.format(minsecFmt) + ".txt");

        try {
            var dir = Files.createDirectories(Paths.get(agora.format(diamesFmt)));
            Files.write(dir.resolve(path), linhas, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
