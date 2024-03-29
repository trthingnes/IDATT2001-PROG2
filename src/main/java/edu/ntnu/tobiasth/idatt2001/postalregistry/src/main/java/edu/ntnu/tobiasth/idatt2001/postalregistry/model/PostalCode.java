package edu.ntnu.tobiasth.idatt2001.postalregistry.model;

/**
 * Interface for postal codes.
 *
 * <p>Many countries use combinations of letters and numbers. Interface therefore uses string type
 *
 * @author trthingnes
 */
public interface PostalCode {
  /**
   * Gets the postal code as a string.
   *
   * @return Postal code as string.
   */
  String getCode();

  /**
   * Gets the postal code location name.
   *
   * @return Location name.
   */
  String getLocationName();

  /**
   * Gets the postal code province code.
   *
   * @return Province code.
   */
  String getProvinceCode();

  /**
   * Gets the postal code province name.
   *
   * @return Province name.
   */
  String getProvinceName();

  /**
   * Gets a print friendly postal code country name.
   *
   * @return Country name.
   */
  String getCountryName();

  /**
   * Gets a string describing what the postal code is used for.
   *
   * @return Type description.
   */
  String getTypeDescription();

  /**
   * Get whether or not two postal codes are equal.
   *
   * @param other Other postal code.
   * @return True if the postal codes are equal, false if not.
   */
  boolean equals(Object other);
}
