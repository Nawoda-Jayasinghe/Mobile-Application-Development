package lk.ac.kln.mit.stu.mobileapplicationdevelopment.data

import com.bumptech.glide.load.engine.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import lk.ac.kln.mit.stu.mobileapplicationdevelopment.fragments.shopping.CartFragment

data class CartProduct(
    val product: Product,
    val quantity: Int,
    val selectedColor: Int? = null,
    val selectedSize: String? = null
){
    constructor(): this(Product(), 1, null, null)
}





//DetailsViewModel

class DetailViewModel @Inject constructor(
    private val firestore: FirebaseFirestore,
    val auth: FirebaseAuth
): ViewModel(){
    private  val _addToCrat = MutableStateFlow<Resource<CartProduct>>(Resource.unspecified())
    val addToCart = _addToCart.asStateFlow()


}