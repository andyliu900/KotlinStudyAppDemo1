/*
 * Copyright (C) 2025 Baidu, Inc. All Rights Reserved.
 */
package com.ideacode.kotlinstudydemo1.api

import android.util.Log
import com.ideacode.kotlinstudydemo1.constant.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Copyright (C), 2021-2025, 无业游民
 * @ProjectName:    KotlinStudyDemo1
 * @Package:        com.ideacode.kotlinstudydemo1.api
 * @ClassName:      RetrofitUtil
 * @Description:
 * @Author:         randysu
 * @CreateDate:     2025/1/28 16:31
 * @UpdateUser:
 * @UpdateDate:     2025/1/28 16:31
 * @UpdateRemark:
 * @Version:        1.0
 */
class RetrofitUtil {

    val retrofitService: RetrofitService?

    companion object {
        const val TAG = "RetrofitUtil"
    }

    init {
        retrofitService = createService(Constants.REQUEST_BASE_URL, RetrofitService::class.java)
    }

    fun creat(url : String): Retrofit {
        val level : HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.BODY
        val loggingInterceptor = HttpLoggingInterceptor({
            Log.e(TAG, "OkHttp:$it")
        })

        loggingInterceptor.level = level
        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.connectTimeout(60, TimeUnit.SECONDS)
        okHttpClientBuilder.readTimeout(10, TimeUnit.SECONDS)
        okHttpClientBuilder.addInterceptor(loggingInterceptor)

        return Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClientBuilder.build())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    fun <T> createService(url: String, service: Class<T>) : T {
        return creat(url).create(service)
    }

}