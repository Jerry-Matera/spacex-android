package io.github.jerrymatera.spacex.domain

import io.github.jerrymatera.spacex.data.models.SpaceShip
import io.github.jerrymatera.spacex.data.network.SpaceShipAPI
import retrofit2.Response
import javax.inject.Inject

class SpaceShipRepository @Inject constructor(private val spaceShipAPI: SpaceShipAPI) {

    suspend fun getShips() : List<SpaceShip> {
        return spaceShipAPI.getShips()
    }
}