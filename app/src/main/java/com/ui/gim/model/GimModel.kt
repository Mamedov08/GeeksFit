package com.ui.gim.model

import java.io.Serializable

data class GimModel(
    var title: String,

    val imageA: Int? = null,
    val titleA: String,

    val imageB: Int? = null,
    val titleB: String,

    val imageC: Int? = null,
    val titleC: String,

    val imageD: Int? = null,
    val titleD: String,

    val imageE: Int? = null,
    val titleE: String

) : Serializable

