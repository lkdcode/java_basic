package day12.lambda;

import java.util.List;

public interface GenericFunction<T, E> {

    // X를 주면 Y를 리턴
    E apply(T t);
}
