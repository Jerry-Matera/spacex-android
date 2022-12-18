package io.github.jerrymatera.spacex.data.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.github.jerrymatera.spacex.data.models.SpaceShip
import io.github.jerrymatera.spacex.util.BASE_URL
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface SpaceShipAPI {
    @GET("/ships")
    suspend fun getShips(): List<SpaceShip>

    companion object {

        private val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
        }
        val api: SpaceShipAPI by lazy {
            retrofit.create(SpaceShipAPI::class.java)
        }

    }
}