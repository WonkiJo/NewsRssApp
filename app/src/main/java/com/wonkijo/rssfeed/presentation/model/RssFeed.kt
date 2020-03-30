package com.wonkijo.rssfeed.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RssFeed(val thumbnail: String? = null,
                   val title: String? = null,
                   val link: String? = null,
                   val summary: String? = null,
                   val keywords: List<String>? = null): Parcelable