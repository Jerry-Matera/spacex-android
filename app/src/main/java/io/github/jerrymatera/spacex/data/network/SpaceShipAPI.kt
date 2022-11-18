package io.github.jerrymatera.spacex.data.network

import io.github.jerrymatera.spacex.data.models.SpaceShip
import io.github.jerrymatera.spacex.util.BASE_URL
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface SpaceShipAPI {
    @GET("/ships")
    suspend fun getShips(): Response<List<SpaceShip>>

    companion object {

        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
        }
        val api: SpaceShipAPI by lazy {
            retrofit.create(SpaceShipAPI::class.java)
        }

    }
}