package io.github.jerrymatera.spacex.data.network

import io.github.jerrymatera.spacex.data.models.SpaceShip
import retrofit2.http.GET

interface SpaceShipAPI {
    @GET("/ships")
    suspend fun getShips(): List<SpaceShip>
}