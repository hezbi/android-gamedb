package com.islamistudio.gamedb.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Platform(
    val id: Int,
    val slug: String,
    val name: String,
    val imageBackground: String
): Parcelable
