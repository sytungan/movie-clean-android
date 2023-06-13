package com.example.moviedatabase.domain.usecase

/**
 * If Y want create something from base
 * Please code in here
 * UseCase<Type>
 */
abstract class UseCase<in Params, out T> where T : Any {

    abstract suspend fun createObservable(params: Params? = null): T

    open fun onCleared() {}
}