package com.example.projectandroid

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

class Reserve (
    @Expose
    @SerializedName("Reserve_ID") val Reserve_ID: Int,
    @Expose
    @SerializedName("Cus_ID") val Cus_ID: Int,
    @Expose
    @SerializedName("Reserve_Date") val Reserve_Date: Date,
    @Expose
    @SerializedName("Check_In_Date") val Check_In_Date: String,
    @Expose
    @SerializedName("Check_Out_Date") val Check_Out_Date: String,
    @Expose
    @SerializedName("Total_Price") val Total_Price: Int,
    @Expose
    @SerializedName("Room_Type") val Room_Type:Int)
{}