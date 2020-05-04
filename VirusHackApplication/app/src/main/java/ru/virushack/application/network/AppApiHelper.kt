package ru.virushack.application.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class AppApiHelper @Inject constructor(): ApiHelper {


    private val service: ApiService

    init {

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY


        val buildClient = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .addInterceptor(logging)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("http:192.168.0.1/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(buildClient)
            .build()

        service = retrofit.create(ApiService::class.java)
    }


}