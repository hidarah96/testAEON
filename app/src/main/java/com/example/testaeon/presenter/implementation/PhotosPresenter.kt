package com.example.testaeon.presenter.implementation

import android.annotation.SuppressLint
import android.util.Log
import com.example.testaeon.connection.ApiConfig
import com.example.testaeon.connection.service.PhotoService
import com.example.testaeon.model.PhotosModel
import com.example.testaeon.presenter.interfaces.PhotosInterfaces
import com.example.testaeon.presenter.interfaces.PhotosResponseInterfaces
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class PhotosPresenter {

    fun photo(): Observable<ArrayList<PhotosModel>> {
        var dataList:ArrayList<PhotosModel> = ArrayList()
        val service = ApiConfig().retrofit.create(PhotoService::class.java)

        return service.getPhotos()
    }
}