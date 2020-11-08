package com.example.projectandroid

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Customer (
    @Expose
    @SerializedName("Cus_ID") val Cus_ID: Int,
    @Expose
    @SerializedName("Cus_username") val Cus_username: String,
    @Expose
    @SerializedName("Cus_password") val Cus_password: String,
    @Expose
    @SerializedName("Cus_address") val Cus_address: String,
    @Expose
    @SerializedName("Cus_Tel") val Cus_Tel: String,
    @Expose
    @SerializedName("Cus_email") val Cus_email: String,
    @Expose
    @SerializedName("Cus_type") val Cus_type: Int
) {
}