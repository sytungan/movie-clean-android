package com.example.moviedatabase.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviedatabase.data.remote.exception.RetrofitException
import com.example.moviedatabase.domain.usecase.UseCase
import com.example.moviedatabase.util.SingleLiveData
import timber.log.Timber
import java.net.ConnectException
import java.net.HttpURLConnection
import java.net.SocketTimeoutException
import java.net.UnknownHostException

abstract class BaseViewModel constructor(
    private vararg val useCases: UseCase<*, *>?
) : ViewModel() {

    val httpUnauthorized = SingleLiveData<Unit>()

    val unexpectedError = SingleLiveData<Unit>()

    val httpUnavailableError = SingleLiveData<Unit>()

    val rxMapperError = SingleLiveData<Unit>()

    val httpForbiddenError = SingleLiveData<Unit>()

    val httpGatewayTimeoutError = SingleLiveData<Unit>()

    val errorMessage = SingleLiveData<String>()

    val isLoading = MutableLiveData<Boolean>().apply { value = false }

    fun showLoading() {
        isLoading.value = true
    }

    fun hideLoading() {
        isLoading.value = false
    }

    fun setThrowable(throwable: Throwable) {
        when (throwable) {
            is RetrofitException -> {
                when (throwable.getKind()) {

                    RetrofitException.Kind.NETWORK -> {
                        handleNetworkError(throwable)
                        Timber.i("Network error")
                    }

                    RetrofitException.Kind.HTTP -> {
                        handleHttpError(throwable)
                        Timber.i("HTTP error")
                    }

                    RetrofitException.Kind.HTTP_422_WITH_DATA -> {
                        throwable.getServerErrorResponse()?.message?.let {
                            errorMessage.value = it
                            Timber.i("HTTP error with response data: $it")
                        }
                    }

                    RetrofitException.Kind.UNEXPECTED -> {
                        unexpectedError.call()
                        Timber.i("Unexpected error")
                    }
                }
            }
            else -> {
                val rxMapperNullErrorMessage = "The mapper function returned a null value."
                val message = throwable.message
                when {
                    message?.contains(rxMapperNullErrorMessage) == true -> {
                        rxMapperError.call()
                    }
                    else -> {
                        unexpectedError.call()
                    }
                }
            }
        }
    }

    private fun handleNetworkError(retrofitException: RetrofitException) {
        when (retrofitException.cause) {
            is UnknownHostException -> {
                httpGatewayTimeoutError.call()
            }
            is ConnectException -> {
                httpGatewayTimeoutError.call()
            }
            is SocketTimeoutException -> {
                httpGatewayTimeoutError.call()
            }
        }
    }

    private fun handleHttpError(retrofitException: RetrofitException) {
        when (retrofitException.getHttpCode()) {
            HttpURLConnection.HTTP_BAD_REQUEST -> {
                unexpectedError.call()
            }
            HttpURLConnection.HTTP_UNAVAILABLE -> {
                httpUnavailableError.call()
            }
            HttpURLConnection.HTTP_UNAUTHORIZED -> {
                httpUnauthorized.call()
            }
            HttpURLConnection.HTTP_FORBIDDEN -> {
                httpForbiddenError.call()
            }
            HttpURLConnection.HTTP_GATEWAY_TIMEOUT -> {
                httpGatewayTimeoutError.call()
            }
        }
    }

    override fun onCleared() {
        useCases.let { userCases ->
            if (userCases.isNotEmpty()) userCases.forEach { it?.onCleared() }
        }
        super.onCleared()
    }
}
