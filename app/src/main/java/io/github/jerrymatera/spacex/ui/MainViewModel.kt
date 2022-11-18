package io.github.jerrymatera.spacex.ui

import android.util.Log
import androidx.lifecycle.*
import io.github.jerrymatera.spacex.data.models.SpaceShip
import io.github.jerrymatera.spacex.domain.SpaceShipRepository
import kotlinx.coroutines.launch

const val TAG = "NetResponse"
class MainViewModel(private val spaceShipRepository: SpaceShipRepository) : ViewModel() {
    private val _spaceShips = MutableLiveData<List<SpaceShip>>()
    val spaceShips: LiveData<List<SpaceShip>>
        get() = _spaceShips

    init {
        getShips()
    }

    private fun getShips(){
        viewModelScope.launch {
            val response = spaceShipRepository.getShips()
            if (response.isSuccessful){
                _spaceShips.value = response.body()
            } else {
                Log.e(TAG, response.message())
            }
        }
    }
}

class MainViewModelFactory(private val spaceShipRepository: SpaceShipRepository) :
    ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(spaceShipRepository) as T
        }
        throw IllegalArgumentException("UNKNOWN VIEW MODEL CLASS")
    }
}