package com.amartinez.bairesdev.ui.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data (
    var id: Long,
    var html_url: String
) : Parcelable