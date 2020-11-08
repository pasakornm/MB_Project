package com.example.projectandroid

import retrofit2.Call
import retrofit2.http.*
import java.util.*

interface ClientAPI {

    @FormUrlEncoded
    @POST("customer")
    fun insertCustomer(
        @Field("Cus_username") Cus_username: String,
        @Field("Cus_password") Cus_password: String,
        @Field("Cus_email") Cus_email: String
    ): Call<Customer>

    @FormUrlEncoded
    @POST("login")
    fun login123(
        @Field("Cus_username") Cus_username: String,
        @Field("Cus_password") Cus_password: String
    ): Call<Customer>

    @FormUrlEncoded
    @PUT("edit/{Cus_ID}")
    fun editinfo(
        @Path("Cus_ID") Cus_ID: Int,
        @Field("Cus_username") Cus_username: String,
        @Field("Cus_password") Cus_password: String,
        @Field("Cus_Tel") Cus_tel: String,
        @Field("Cus_email") Cus_email: String,
        @Field("Cus_address") Cus_address: String
    ): Call<Customer>


    @FormUrlEncoded
    @POST("reserve")
    fun reservepayment(
        @Field("Cus_ID") Cus_ID: Int,
        @Field("Check_In_Date") Check_In_Date: String,
        @Field("Check_Out_Date") Check_Out_Date: String,
        @Field("Total_Price") Total_Price: Int,
        @Field("Room_Type") Room_Type: Int
    ): Call<Reserve>

    @DELETE("roomcancle/{Reserve_ID}")
    fun roomcancle(
        @Path("Reserve_ID") Reserve_ID: Int
    ): Call<Reserve>

    @GET("serchall")
    fun serchall(): Call<List<Reserve>>

    @GET("serch/{Reserve_ID}")
    fun serch(
      @Path("Reserve_ID") Reserve_ID: Int
    ): Call<List<Reserve>>

    /*companion object {
        fun create(): API{
            val cusClient: API = Retrofit.Builder()
                .baseUrl("http://10.0.2.0:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(API::class.java)
            return cusClient
        }
    }*/

}
