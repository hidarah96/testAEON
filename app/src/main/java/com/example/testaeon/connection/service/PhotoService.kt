package com.example.testaeon.connection.service

import com.example.testaeon.model.PhotosModel
import io.reactivex.Observable
import retrofit2.http.GET

interface PhotoService {

    @GET("photos")
    fun getPhotos(): Observable<ArrayList<PhotosModel>>

}