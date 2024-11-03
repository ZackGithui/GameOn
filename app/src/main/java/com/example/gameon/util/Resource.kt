package com.example.gameon.util

sealed class Resource <T>(
    var data: T?=null,
    var message :String?=null,
){
    class Loading <T>(val isLoading:Boolean=true):Resource<T>(null)
     class Error <T>( message: String?):Resource<T>(message=message)
    class Success <T> (data: T?):Resource<T>(data=data)
}