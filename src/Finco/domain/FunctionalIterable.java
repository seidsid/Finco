package Finco.domain;

import java.util.function.Consumer;
import java.util.function.Predicate;

public interface FunctionalIterable<T> {
    void doAll(Consumer<T> functor, Predicate<T> predicate);
}
