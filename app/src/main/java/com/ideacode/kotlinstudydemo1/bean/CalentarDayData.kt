/*
 * Copyright (C) 2025 Baidu, Inc. All Rights Reserved.
 */
package com.ideacode.kotlinstudydemo1.bean

/**
 * Copyright (C), 2021-2025, 百度阿波罗
 * @ProjectName:    KotlinStudyDemo1
 * @Package:        com.ideacode.kotlinstudydemo1.bean
 * @ClassName:      CalentarDayData
 * @Description:
 * @Author:         randysu
 * @CreateDate:     2025/1/28 16:29
 * @UpdateUser:
 * @UpdateDate:     2025/1/28 16:29
 * @UpdateRemark:
 * @Version:        1.0
 */
data class CalentarDayData(
    val date: String,
    val weekdayval : String,
    val animalsYear : String,
    val suit: String,
    val avoid: String,
    val yearMonth: String,
    val holiday: String,
    val lunar: String,
    val lunarYear: String,
    val desc: String
)
