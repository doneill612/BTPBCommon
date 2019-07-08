package com.btpb.common.interfaces;

/**
 * Represents a database entity.
 */
public interface DatabaseObject extends IdLoadable {

    /**
     * Saves this entity to the database.
     */
    void save();

    /**
     * Drops this entity from the database.
     */
    void remove();

    /**
     * Initializes this entity with default values.
     */
    void initialize();
}
