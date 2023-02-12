package lk.ac.kln.mit.stu.mobileapplicationdevelopment.util

//generic class which can receive any data type
sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    //sub classes defined here
    class Success<T>(data: T): Resource<T>(data)
    class Error<T>(message: String): Resource<T>(message = message)
    class Loading<T>: Resource<T>()
    class Unspecified<T> : Resource<T>()
}