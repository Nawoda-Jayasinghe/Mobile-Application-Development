package lk.ac.kln.mit.stu.mobileapplicationdevelopment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import lk.ac.kln.mit.stu.mobileapplicationdevelopment.data.Product
import lk.ac.kln.mit.stu.mobileapplicationdevelopment.util.Resource
import javax.inject.Inject


@HiltViewModel
class MainCategoryViewModel @Inject constructor(
private val firestore: FirebaseFirestore
): ViewModel(){

    private val _specialProducts = MutableStateFlow<Resource<List<Product>>>(Resource.Unspecified())
    val specialProducts: StateFlow<Resource<List<Product>>> = _specialProducts

    private val _bestDealsProducts = MutableStateFlow<Resource<List<Product>>>(Resource.Unspecified())
    val bestDealsProducts: StateFlow<Resource<List<Product>>> = _bestDealsProducts

    private val _bestProducts = MutableStateFlow<Resource<List<Product>>>(Resource.Unspecified())
    val bestProducts: StateFlow<Resource<List<Product>>> = _bestProducts

    init {
        fetchSpecialProducts()
        fetchBestProducts()
        fetchBestDealsProducts()
    }

    fun fetchSpecialProducts(){
        viewModelScope.launch {
            _specialProducts.emit(Resource.Loading())
        }
        firestore.collection("Products").whereEqualTo("category", "Special Products").get().addOnSuccessListener { result ->
            val specialProductsList = result.toObjects(Product::class.java)
            viewModelScope.launch {
                _specialProducts.emit(Resource.Success(specialProductsList))
            }
        }.addOnFailureListener {
            viewModelScope.launch {
                _specialProducts.emit(Resource.Error(it.message.toString()))
            }
        }
    }

    fun fetchBestDealsProducts(){
        viewModelScope.launch {
            _bestDealsProducts.emit(Resource.Loading())
        }
        firestore.collection("Products").whereEqualTo("category", "Best Deals").get().addOnSuccessListener { result ->
            val bestDealsProducts = result.toObjects(Product::class.java)
            viewModelScope.launch {
                _bestDealsProducts.emit(Resource.Success(bestDealsProducts))
            }
        }.addOnFailureListener {
            viewModelScope.launch {
                _bestDealsProducts.emit(Resource.Error(it.message.toString()))
            }
        }
    }


    fun fetchBestProducts(){
        viewModelScope.launch {
            _bestProducts.emit(Resource.Loading())
        }
        firestore.collection("Products").get().addOnSuccessListener { result ->
            val bestProducts = result.toObjects(Product::class.java)
            viewModelScope.launch {
                _bestProducts.emit(Resource.Success(bestProducts))
            }
        }.addOnFailureListener {
            viewModelScope.launch {
                _bestProducts.emit(Resource.Error(it.message.toString()))
            }
        }
    }


}