package com.example.ozinsheapp.domain.entity.profile

import androidx.annotation.Keep

@Keep
data class ChangePasswordBody(
    val password: String
)