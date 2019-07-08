package com.btpb.common.interfaces;

import com.btpb.common.exceptions.BTPBException;

/**
 * Represents a database entity.
 */
public interface DatabaseObject extends IdLoadable {

    /**
     * Saves this entity to the database.
     */
    void save() throws BTPBException;

    /**
     * Drops this entity from the database.
     */
    void remove() throws BTPBException;

    /**
     * Initializes this entity with default values.
     */
    void initialize();
}
