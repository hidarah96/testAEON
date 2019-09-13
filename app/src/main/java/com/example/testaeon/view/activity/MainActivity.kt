package com.example.testaeon.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testaeon.R
import com.example.testaeon.model.PhotosModel
import com.example.testaeon.presenter.implementation.PhotosPresenter
import com.example.testaeon.presenter.interfaces.PhotosResponseInterfaces
import com.example.testaeon.view.adapter.MainAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var photosPresenter: PhotosPresenter
    lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        action()
    }

    fun action(){
        initial()
        setRecyclerView()
    }

    fun initial(){
        photosPresenter = PhotosPresenter()
        adapter = MainAdapter()
    }

    fun setRecyclerView(){
        rv_main.layoutManager = LinearLayoutManager(this)
        rv_main.setHasFixedSize(true)
        rv_main.adapter = adapter
    }
}
