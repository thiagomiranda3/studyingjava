package br.com.tommiranda.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

public class ListaArvoreDiretorios {

    public static void main(String[] args) {
        DateTimeFormatter minsecFmt = DateTimeFormatter.ofPattern("mm-ss");
        LocalDateTime agora = LocalDateTime.now();

        Path path = Paths.get("C:\\Windows");

        plotarArvoreArquivos(path, 0);
    }

    private static void plotarArvoreArquivos(Path path, int espacos) {
        try (Stream<Path> paths = Files.walk(path, 1)) {
            paths.forEach(p -> {
                if(p == path) {
                    return;
                }

                if(Files.isDirectory(p)) {
                    darEspacos(espacos);
                    System.out.println(p.getName(p.getNameCount() - 1));
                    plotarArvoreArquivos(p, espacos + 1);
                }

                darEspacos(espacos);
                System.out.println(p.getName(p.getNameCount() - 1));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void darEspacos(int espacos) {
        for (int i = 0; i < espacos; i++) {
            System.out.print("   ");
        }
    }
}
