package com.btpb.common.interfaces;

/**
 * Represents an entity that can be loaded from the
 * database using an ID. Entities that implement this
 * interface usually have an integer-valued primary key.
 */
public interface IdLoadable {

    /**
     * Load the entity using the database ID provided.
     * @param id the ID to use when querying the database.
     */
    void load(int id);

}