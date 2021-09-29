package com.example.giphy

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
class Notice(
    @SerializedName("id")
    @Expose
    var id: String,
    @SerializedName("title")
    @Expose
    var title: String,
//    @SerializedName("brief")
//    @Expose
//    var brief: String,
//    @SerializedName("filesource")
//    @Expose
//    var fileSource: String
)