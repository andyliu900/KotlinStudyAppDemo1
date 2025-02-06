/*
 * Copyright (C) 2025 Baidu, Inc. All Rights Reserved.
 */
package com.ideacode.kotlinstudydemo1.api

import com.ideacode.kotlinstudydemo1.bean.CalentarDayBean
import com.ideacode.kotlinstudydemo1.bean.CalentarDayData
import com.ideacode.kotlinstudydemo1.bean.CalentarDayResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Copyright (C), 2021-2025, 无业游民
 * @ProjectName:    KotlinStudyDemo1
 * @Package:        com.ideacode.kotlinstudydemo1.api
 * @ClassName:      RetrofitService
 * @Description:
 * @Author:         randysu
 * @CreateDate:     2025/1/28 16:25
 * @UpdateUser:
 * @UpdateDate:     2025/1/28 16:25
 * @UpdateRemark:
 * @Version:        1.0
 */
interface RetrofitService {

    @GET("calendar/day")
    fun calenderDay(
        @Query("date") date: String,
        @Query("key") key: String
    ): Observable<CalentarDayBean<CalentarDayResult<CalentarDayData>>>

}