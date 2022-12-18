package io.github.jerrymatera.spacex.ui

import android.util.Log
import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.jerrymatera.spacex.data.models.SpaceShip
import io.github.jerrymatera.spacex.domain.SpaceShipRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

const val TAG = "NetResponse"
@HiltViewModel
class MainViewModel @Inject constructor(private val spaceShipRepository: SpaceShipRepository) : ViewModel() {
    private val _spaceShips = MutableLiveData<List<SpaceShip>>()
    val spaceShips: LiveData<List<SpaceShip>>
        get() = _spaceShips

    init {
        getShips()
    }

    private fun getShips(){
        viewModelScope.launch {
            val response = spaceShipRepository.getShips()
            _spaceShips.value = response
        }
    }
}
