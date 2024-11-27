package com.example.moviecompose.di

import com.example.moviecompose.api.ApiService
import com.example.moviecompose.repository.MovieRepository
import com.example.moviecompose.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideHeaderInterceptor(): Interceptor = Interceptor { chain ->
        val request = chain.request()
            .newBuilder()
            .addHeader("accept", "application/json")
            .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4YTY4YjI0MDdlZTdmNWEzNzFkNzI0YmE2MjFjNzI3NCIsIm5iZiI6MTcyMTMyNjE5Ny44NTIxMDEsInN1YiI6IjYwZTk5YjQyODNlZTY3MDA1ZGVlMmYwMiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.2MqsB8gSdE9_rD2f4k124k1GAwnlAsLgXlLcr_BtMJg")
            .build()
        chain.proceed(request)
    }

    @Provides
    fun provideOkHttpClient(headerInterceptor: Interceptor): OkHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(headerInterceptor)
        .build()

    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    fun provideMovieRepository(apiService: ApiService): MovieRepository = MovieRepository(apiService)

}