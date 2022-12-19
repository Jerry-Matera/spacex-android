package io.github.jerrymatera.spacex.domain

import io.github.jerrymatera.spacex.data.models.SpaceShip
import io.github.jerrymatera.spacex.data.network.SpaceShipAPI
import javax.inject.Inject

class SpaceShipRepositoryImpl @Inject constructor(private val spaceShipAPI: SpaceShipAPI) : SpaceShipRepository{

    override suspend fun getShips() : List<SpaceShip> {
        return spaceShipAPI.getShips()
    }
}