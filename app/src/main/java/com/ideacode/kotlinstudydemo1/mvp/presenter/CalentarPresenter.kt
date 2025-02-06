/*
 * Copyright (C) 2025 Baidu, Inc. All Rights Reserved.
 */
package com.ideacode.kotlinstudydemo1.mvp.presenter

import android.util.Log
import com.ideacode.kotlinstudydemo1.api.RetrofitUtil
import com.ideacode.kotlinstudydemo1.mvp.contract.CalentarContract
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Copyright (C), 2021-2025, 无业游民
 * @ProjectName:    KotlinStudyDemo1
 * @Package:        com.ideacode.kotlinstudydemo1.mvp.presenter
 * @ClassName:      CalentarPresenter
 * @Description:
 * @Author:         randysu
 * @CreateDate:     2025/1/28 16:44
 * @UpdateUser:
 * @UpdateDate:     2025/1/28 16:44
 * @UpdateRemark:
 * @Version:        1.0
 */
class CalentarPresenter(val view: CalentarContract.View) : CalentarContract.Presenter {

    var compositeDispose: CompositeDisposable
    val retrofitUtil: RetrofitUtil

    companion object {
        const val TAG = "CalentarPresenter"
    }

    init {
        view.presenter = this
        compositeDispose = CompositeDisposable()
        retrofitUtil = RetrofitUtil()
    }

    override fun getDayCalentarData(date: String) {
        val disposable = retrofitUtil.retrofitService?.let {
            it.calenderDay(date, "933dc930886c8c0717607f9f8bae0b48")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.showDayCalentarData(it)
                    Log.e(TAG, it.toString())
                }, {
                    view.showError(it.message.toString())
                    Log.e(TAG, it.message.toString())
                })
        }

        compositeDispose.add(disposable ?: return)

    }

    override fun subscribe() {

    }

    override fun unsubscribe() {
        compositeDispose.clear()
    }
}