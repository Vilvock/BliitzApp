package com.bliitz.app.global_model

import com.google.gson.annotations.SerializedName
import com.bliitz.app.global_model.GlobalModel
import java.io.Serializable

class Photo (

    @field:SerializedName("foto")
    var photo: String? = null,

): GlobalModel(), Serializable{


}