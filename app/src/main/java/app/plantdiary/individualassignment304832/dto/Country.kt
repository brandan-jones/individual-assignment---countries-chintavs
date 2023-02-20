package app.plantdiary.individualassignment304832.dto

import com.google.gson.annotations.SerializedName

/**
 *
 * This is a data class for Country.
 *
 * Contains the country code and name.
 *
 * @property code two-letter country code.
 * @property name name of the country.
 */

data class Country(@SerializedName("Code") var code: String,@SerializedName("Name") var name: String) {

    override fun toString(): String {
        return "$name $code"
    }
}
