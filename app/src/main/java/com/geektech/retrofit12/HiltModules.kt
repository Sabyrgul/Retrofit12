package com.geektech.retrofit12

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class HiltModules {

    @Provides
    fun getApi():CalculateAPI{

        return getRetrofit().create(CalculateAPI::class.java)
    }

    @Provides
    fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(getClient())
            .build()
    }

    @Provides
    fun getClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(getInterceptor())
            .build()
    }

    @Provides
    fun getInterceptor(): HttpLoggingInterceptor {
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY
        return logger
    }

    @Provides
    @Singleton
    fun getString():java.lang.StringBuilder{
        return StringBuilder("Hello")
    }

    @Provides
    @Singleton
    fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("utils", Context.MODE_PRIVATE)
    }
    @Provides
    fun providePrefs(sharedPreferences: SharedPreferences) = Preference(sharedPreferences)


    @Provides
    fun getDao(dataBase: CalculateDataBase):CalculateDao{
        return dataBase.getCalculateDao()
    }
}