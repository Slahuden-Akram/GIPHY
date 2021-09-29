package com.example.giphy

import android.content.Context

import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso


class NoticeAdapter(private val dataList: ArrayList<Notice>, private val context: Context) : RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder>() {

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticeViewHolder {
//        val layoutInflater = LayoutInflater.from(parent.context)
//        val view: View = layoutInflater.inflate(R.layout.,parent,false)
//        return NoticeViewHolder(view)
////        return NoticeViewHolder(LayoutInflater.from(context).inflate(R.layout, parent, false))
//
//    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticeViewHolder {
        return NoticeViewHolder(LayoutInflater.from(context).inflate(R.layout.single_row, parent, false))
    }
lateinit var url : String
    override fun onBindViewHolder(holder: NoticeViewHolder, position: Int) {
        holder.txtNoticeTitle.setText(dataList[position].title)
url = "https://media1.giphy.com/media/"+dataList[position].id+"/giphy.gif"
        Picasso.get().load(url).into(holder.imgDShow)
//        holder.txtNoticeBrief.setText(dataList[position].brief)
//        holder.txtNoticeFilePath.setText(dataList[position].fileSource)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class NoticeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtNoticeTitle: TextView
        lateinit var imgDShow: ImageView
//        var txtNoticeBrief: TextView
//        var txtNoticeFilePath: TextView

        init {
            txtNoticeTitle = itemView.findViewById(R.id.txt_notice_title)
            imgDShow = itemView.findViewById(R.id.imgDShow)
//            txtNoticeBrief = itemView.findViewById(R.id.txt_notice_brief)
//            txtNoticeFilePath = itemView.findViewById(R.id.txt_notice_file_path)
        }
    }
}