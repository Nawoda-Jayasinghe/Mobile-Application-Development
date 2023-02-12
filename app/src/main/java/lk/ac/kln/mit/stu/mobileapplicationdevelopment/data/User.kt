package lk.ac.kln.mit.stu.mobileapplicationdevelopment.data

data class User(
    val firstName: String,
    val lastName: String,
    val email: String,
    var imagePath: String = ""
){
    constructor(): this("","","","")
}
