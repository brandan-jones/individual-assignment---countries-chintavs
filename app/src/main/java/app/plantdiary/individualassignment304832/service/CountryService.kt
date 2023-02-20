package app.plantdiary.individualassignment304832.service

import app.plantdiary.individualassignment304832.RetrofitClientInstance
import app.plantdiary.individualassignment304832.dao.ICountryDAO
import app.plantdiary.individualassignment304832.dto.Country
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import retrofit2.awaitResponse

/**
 * A service class that fetches country data from an online json file
 *
 */

class CountryService {
    /**
     * fetches country data from an online json file
     * @return a list of countries.
     */
    suspend fun fetchCountries(): List<Country>? {

        return withContext(Dispatchers.IO) {
            val service = RetrofitClientInstance.retrofitInstance?.create(ICountryDAO::class.java)
            val countries = async {service?.getAllCountries()}
            return@withContext countries.await()?.awaitResponse()?.body()
        }
    }

}
