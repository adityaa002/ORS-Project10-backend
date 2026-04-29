package com.rays.common;

/**
 * Interface for dropdown list support.
 * <p>
 * Provides contract methods for retrieving key-value pairs used in dropdown
 * menus or selection lists in the UI. Implementations should return meaningful
 * identifiers and display values for entities.
 * </p>
 *
 * @author Aditya
 * @version 1.0
 */
public interface DropdownList {

    /**
     * Returns the unique key for the dropdown item.
     * <p>
     * Typically the primary key (ID) of the entity.
     * </p>
     *
     * @return string representation of the key
     */
    public String getKey();

    /**
     * Returns the display value for the dropdown item.
     * <p>
     * Typically a human-readable label or name.
     * </p>
     *
     * @return string representation of the value
     */
    public String getValue();
}
