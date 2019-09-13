package com.example.testaeon.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.testaeon.R
import com.example.testaeon.Tools.app
import com.example.testaeon.database.DBLocal
import com.example.testaeon.model.PhotosModel
import com.example.testaeon.presenter.implementation.PhotosPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainAdapter(): RecyclerView.Adapter<MainAdapter.viewHolder>(){

    var dataList:ArrayList<PhotosModel> = ArrayList()
    var db = DBLocal(app().context)

    init {
        var presenter = PhotosPresenter()
        db = DBLocal(app().context)
        presenter.photo().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { succsess ->
                    this.dataList = succsess
                    Log.d("xxx1","${this.dataList}")
                },{ error ->
                }
            )
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false))
    }

    override fun getItemCount(): Int {
        //karena data terlalu banyak maka saya hanya set 10 saja
        return dataList.size - 4990
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        db.insertData(dataList[position].title,dataList[position].thumbnailUrl)
        Glide.with(app().context).load(dataList[position].thumbnailUrl).diskCacheStrategy(DiskCacheStrategy.DATA).into(holder.iv_item)
        holder.tv_item.text = dataList[position].title
    }


    class viewHolder(itemView: View?): RecyclerView.ViewHolder(itemView!!){
        val tv_item = itemView!!.findViewById<TextView>(R.id.tv_item)
        val iv_item = itemView!!.findViewById<ImageView>(R.id.iv_item)
    }
}