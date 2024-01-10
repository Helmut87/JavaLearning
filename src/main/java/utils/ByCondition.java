package utils;

@FunctionalInterface
public interface ByCondition<T extends Number> {
    boolean isOk(T number);
}
