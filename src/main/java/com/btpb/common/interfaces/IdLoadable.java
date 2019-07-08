package com.btpb.common.interfaces;

import com.btpb.common.exceptions.BTPBException;

/**
 * Represents an entity that can be loaded from the
 * database using an ID. Entities that implement this
 * interface usually have an integer-valued primary key.
 */
public interface IdLoadable {

    /**
     * Loads the entity using the database ID provided.
     * @param id the ID to use when querying the database.
     */
    void load(int id) throws BTPBException;

}
