/*
 * Copyright (C) 2025 Baidu, Inc. All Rights Reserved.
 */
package com.ideacode.kotlinstudydemo1.bean

/**
 * Copyright (C), 2021-2025, 百度阿波罗
 * @ProjectName:    KotlinStudyDemo1
 * @Package:        com.ideacode.kotlinstudydemo1.bean
 * @ClassName:      CalentarDayBean
 * @Description:
 * @Author:         randysu
 * @CreateDate:     2025/1/28 16:27
 * @UpdateUser:
 * @UpdateDate:     2025/1/28 16:27
 * @UpdateRemark:
 * @Version:        1.0
 */
data class CalentarDayBean<T>(val reason: String,
                            val result: T,
                            val error_code: Int)
