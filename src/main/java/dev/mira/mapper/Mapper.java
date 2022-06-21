package dev.mira.mapper;


/**
 * Mapper
 */
public interface Mapper<S, T> {

    public T toDTO(S domainObj);

    // public List<T> toDTO(List<S> src);
}
