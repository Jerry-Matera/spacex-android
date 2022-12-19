package io.github.jerrymatera.spacex.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.jerrymatera.spacex.data.network.SpaceShipAPI
import io.github.jerrymatera.spacex.domain.SpaceShipRepository
import io.github.jerrymatera.spacex.domain.SpaceShipRepositoryImpl
import io.github.jerrymatera.spacex.util.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideSpaceShipApi(okHttpClient: OkHttpClient, moshi: Moshi): SpaceShipAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(SpaceShipAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideSpaceShipRepository(api: SpaceShipAPI): SpaceShipRepository {
        return SpaceShipRepositoryImpl(api)
    }
}
