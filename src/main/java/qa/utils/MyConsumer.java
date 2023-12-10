package qa.utils;

public interface MyConsumer<T> {

    void accept(T t) throws IllegalAccessException;
}
