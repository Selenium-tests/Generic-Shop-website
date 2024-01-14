package qa.utils;

public interface AccessThrowingConsumer<T> {

    void accept(T t) throws IllegalAccessException;
}
