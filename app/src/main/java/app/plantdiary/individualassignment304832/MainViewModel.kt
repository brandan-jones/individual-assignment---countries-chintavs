package app.plantdiary.individualassignment304832

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.plantdiary.individualassignment304832.dto.Country
import app.plantdiary.individualassignment304832.service.CountryService
import kotlinx.coroutines.launch

/**
 *
 * This is a view model class that retrieves country data
 *
 * @property countries a list of countries.
 * @property countryService service class that fetches country data from json.
 */
class MainViewModel: ViewModel() {
    var countries: MutableLiveData<List<Country>> = MutableLiveData<List<Country>>()
    var countryService: CountryService = CountryService()

    /**
     * Launches a new background coroutine that retrieves country data from json file using [countryService]
     * Posts the retrieved data to [countries]
     */
     fun fetchCountries() {
        viewModelScope.launch {
            countries.postValue(countryService.fetchCountries())
        }
    }

}
