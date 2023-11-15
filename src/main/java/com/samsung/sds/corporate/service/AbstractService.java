package com.samsung.sds.corporate.service;

import java.util.Collections;
import java.util.List;

public interface AbstractService<E, P, ID> {

    default List<E> findAll() {
        return Collections.emptyList();
    }

    default E findById(ID id) {
        return null;
    }

    default ID save(P p) {
        return null;
    }

    default void update(ID id, P p) {

    }

    default void delete(ID id) {

    }
}
