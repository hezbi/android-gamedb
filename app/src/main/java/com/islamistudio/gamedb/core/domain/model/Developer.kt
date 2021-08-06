package com.islamistudio.gamedb.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Developer(
    val id: Int,
    val name: String
): Parcelable
