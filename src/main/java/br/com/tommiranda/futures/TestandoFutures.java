package br.com.tommiranda.futures;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class TestandoFutures {

    public static CompletableFuture<String> create() {
        return CompletableFuture.supplyAsync(() -> "Hello");
    }

    public static CompletableFuture<CompletableFuture<String>> createAsync() {
        return CompletableFuture.supplyAsync(() -> create());
    }

    public static void main(String[] args) {
        var future = create();

        // Quando a future completar, executa o método passado no thenAccept
        future.thenApply(s -> s + " World")
              .thenAccept(System.out::println);

        var async = createAsync();

        // Aqui não funciona, porque o que é retornado não é uma String, mas uma outra Future
        async.thenApply(s -> s + " World")
             .thenAccept(System.out::println);

        // É necessário usar o compose para pegar o resultado da outra future, e não ela mesma
        async.thenCompose(Function.identity())
             .thenApply(s -> s + " World")
             .thenAccept(System.out::println);
    }
}
