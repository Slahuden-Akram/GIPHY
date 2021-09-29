package com.example.giphy

import com.google.gson.annotations.SerializedName


class NoticeList {
//    @SerializedName("notice_list")
    @SerializedName("data")
    var noticeArrayList: ArrayList<Notice>? = null
}