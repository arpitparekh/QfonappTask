package com.example.qfonapptask.model

import com.google.gson.annotations.SerializedName

data class Content(

    @field:SerializedName("data")
	val data: List<DataItem?>? = null,

    @field:SerializedName("message")
	val message: String? = null,

    @field:SerializedName("status")
	val status: Boolean? = null
)

data class DataItem(

	@field:SerializedName("comments")
	val comments: String? = null,

	@field:SerializedName("thumb")
	val thumb: String? = null,

	@field:SerializedName("caption")
	val caption: String? = null,

	@field:SerializedName("userName")
	val userName: String? = null,

	@field:SerializedName("content")
	val content: String? = null,

	@field:SerializedName("userImage")
	val userImage: String? = null,

	@field:SerializedName("size")
	val size: String? = null,

	@field:SerializedName("posttype")
	val posttype: Int? = null,

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("blurImage")
	val blurImage: String? = null,

	@field:SerializedName("likes")
	val likes: String? = null,

	@field:SerializedName("height")
	val height: Int? = null
)
