package br.com.tommiranda.reactive;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.stream.Stream;

public class EnviadorData {

    public static Observable<LocalDateTime> getTempos(Stream<LocalDate> datas) {
        return Observable.create(emitter -> enviaDatas(emitter, datas));
    }

    private static void enviaDatas(ObservableEmitter<LocalDateTime> emitter, Stream<LocalDate> datas) {
        datas.map(data -> LocalDateTime.of(data, LocalTime.now()))
             .forEach(emitter::onNext);
    }

    public static void main(String[] args) {
        var dataStream = Stream.iterate(LocalDate.now(), data -> data.plusDays(1));

        Observable<LocalDateTime> observable = getTempos(dataStream);

        // Me inscrevo para receber os dados que chegam do emitter
        observable.subscribe(System.out::println);
    }
}
