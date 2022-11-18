package io.github.jerrymatera.spacex.domain

import io.github.jerrymatera.spacex.data.models.SpaceShip
import io.github.jerrymatera.spacex.data.network.SpaceShipAPI
import retrofit2.Response

class SpaceShipRepository(private val spaceShipAPI: SpaceShipAPI) {

    suspend fun getShips() : Response<List<SpaceShip>> {
        return spaceShipAPI.getShips()
    }
}