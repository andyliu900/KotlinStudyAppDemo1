/*
 * Copyright (C) 2025 Baidu, Inc. All Rights Reserved.
 */
package com.ideacode.kotlinstudydemo1.mvp.contract

import com.ideacode.kotlinstudydemo1.base.BasePresenter
import com.ideacode.kotlinstudydemo1.base.BaseView
import com.ideacode.kotlinstudydemo1.bean.CalentarDayBean
import com.ideacode.kotlinstudydemo1.bean.CalentarDayData
import com.ideacode.kotlinstudydemo1.bean.CalentarDayResult

/**
 * Copyright (C), 2021-2025, 百度阿波罗
 * @ProjectName:    KotlinStudyDemo1
 * @Package:        com.ideacode.kotlinstudydemo1.mvp.contract
 * @ClassName:      CalentarContract
 * @Description:
 * @Author:         randysu
 * @CreateDate:     2025/1/28 16:45
 * @UpdateUser:
 * @UpdateDate:     2025/1/28 16:45
 * @UpdateRemark:
 * @Version:        1.0
 */
interface CalentarContract {

    interface View : BaseView<Presenter> {
        fun showDayCalentarData(calentarDayData: CalentarDayBean<CalentarDayResult<CalentarDayData>>)
        fun showError(errorMsg: String)
    }

    interface Presenter : BasePresenter {
        fun getDayCalentarData(data: String)
    }

}