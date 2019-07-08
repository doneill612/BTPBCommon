package com.btpb.common.interfaces;

import com.btpb.common.exceptions.BTPBException;

/**
 * Represents an entity that can be loaded from the
 * database using a key. Entities that implement this
 * interface usually have an string-valued column which
 * can be used to refine DB queries.
 */
public interface KeyLoadable {

    /**
     * Loads the entity using the database key provided.
     * @param key the key to use when querying the database.
     */
    void load(String key) throws BTPBException;
}
