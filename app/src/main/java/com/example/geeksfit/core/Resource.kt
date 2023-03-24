package com.example.geeksfit.core


data class Resource<T>(val status: Status, val data: T?, val message: String?, val code: Int?) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null, null)
        }

        fun <T> error(msg: String, data: T?, code: Int?): Resource<T> {
            return Resource(Status.ERROR, data, msg, code)
        }

        fun <T> loading(): Resource<T> {
            return Resource(Status.LOADING, null, null, null)
        }
    }
}

enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}