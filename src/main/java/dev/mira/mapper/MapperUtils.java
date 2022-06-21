package dev.mira.mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * MapperUtils
 */
public class MapperUtils {

    /**
     * Make dto list array list.
     *
     * @param <E>    the type parameter
     * @param <T>    the type parameter
     * @param list   the list
     * @param mapper the mapper
     * @return the array list
     */
    public static <E, T> ArrayList<T>
    makeDTOList(List<? extends E> list, Mapper<E, T> mapper)
    {
        var listDTO = new ArrayList<T>();
        var iter = list.iterator();

        while (iter.hasNext()) {
            var next = iter.next();
            listDTO.add(mapper.toDTO(next));
        }

        return listDTO;
    }
}
