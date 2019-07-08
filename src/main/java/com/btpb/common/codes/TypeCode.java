package com.btpb.common.codes;

import com.btpb.common.interfaces.DatabaseObject;
import com.btpb.common.interfaces.KeyLoadable;

/**
 * An abstract base class for {@code TypeCode} objects in the platform.
 * Type codes are containers for type-metadata concerning other objects
 * in the database.<br/><br/>
 * For example, {@code Client} objects have a corresponding {@code ClientTypeCode}
 * which describes the type of client.
 */
public abstract class TypeCode implements DatabaseObject, KeyLoadable {

    private int id;
    private int order;
    private boolean active;
    private String title;
    private String key;

    /**
     * Constructs a blank {@code TypeCode}.
     */
    public TypeCode()
    {
        this.initialize();
    }

    /**
     * Constructs a {@code TypeCode} using an ID from the database.
     * @param id the ID to use when querying the database.
     */
    public TypeCode(int id)
    {
        this.load(id);
    }

    /**
     * Constructs a {@code TypeCode} using a key from the database
     * @param key the key to use when querying the database.
     */
    public TypeCode(String key)
    {
        this.load(key);
    }

    /**
     * Constructs a {@code TypeCode} using all values retrieved from a
     * database query. This is a lazy-loading constructor.
     * @param id the ID of the code in the database
     * @param key the key of the code in the database
     * @param title the title of the code in the database
     * @param active whether or not this code is active in the platform
     * @param order the ordering position of this code
     */
    public TypeCode(int id, String key, String title, boolean active, int order)
    {
        this.id = id;
        this.key = key;
        this.title = title;
        this.active = active;
        this.order = order;
    }

    @Override
    public final void initialize()
    {
        this.id = 0;
        this.order = 0;
        this.key = "";
        this.title = "";
        this.active = true;
    }

    public abstract void load(int id);

    public abstract void load(String key);

    public abstract void save();

    public abstract void remove();
}
