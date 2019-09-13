package com.example.testaeon.presenter.interfaces

import com.example.testaeon.model.PhotosModel

interface PhotosResponseInterfaces {
    fun onSuccess(response: List<PhotosModel>)
    fun onFailed(response: String)
}