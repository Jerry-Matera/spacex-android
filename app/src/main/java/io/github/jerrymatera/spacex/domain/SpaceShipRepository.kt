package io.github.jerrymatera.spacex.domain

import io.github.jerrymatera.spacex.data.models.SpaceShip

interface SpaceShipRepository {

    suspend fun getShips() : List<SpaceShip>
}