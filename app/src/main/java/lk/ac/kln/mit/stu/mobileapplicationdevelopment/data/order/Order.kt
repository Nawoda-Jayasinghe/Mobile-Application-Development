package lk.ac.kln.mit.stu.mobileapplicationdevelopment.data.order

import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random.Default.nextLong

class Order {
    val orderStatus : String = ""
    val totalPrice : Float = 0f
    val products: List<CartProducts> = emptyList()
    val date: String = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(Date())
    val orderId: Long = nextLong(0 ,100_000_000_000) + totalPrice.toLong()
}