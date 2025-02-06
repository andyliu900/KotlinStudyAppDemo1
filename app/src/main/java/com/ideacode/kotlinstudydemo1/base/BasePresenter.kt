/*
 * Copyright (C) 2025 Baidu, Inc. All Rights Reserved.
 */
package com.ideacode.kotlinstudydemo1.base

/**
 * Copyright (C), 2021-2025, 无业游民
 * @ProjectName:    KotlinStudyDemo1
 * @Package:        com.ideacode.kotlinstudydemo1.base
 * @ClassName:      BasePresenter
 * @Description:
 * @Author:         randysu
 * @CreateDate:     2025/1/28 16:46
 * @UpdateUser:
 * @UpdateDate:     2025/1/28 16:46
 * @UpdateRemark:
 * @Version:        1.0
 */
interface BasePresenter {

    /**
     * 开启订阅
     */
    fun subscribe()

    /**
     * 结束订阅
     */
    fun unsubscribe()

}