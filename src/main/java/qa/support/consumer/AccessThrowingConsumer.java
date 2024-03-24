package qa.support.consumer;

public interface AccessThrowingConsumer<T> {

    void accept(T t) throws IllegalAccessException;
}
