package lk.ac.kln.mit.stu.mobileapplicationdevelopment.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.inflate
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import lk.ac.kln.mit.stu.mobileapplicationdevelopment.R
import lk.ac.kln.mit.stu.mobileapplicationdevelopment.databinding.ActivityShoppingBinding

@AndroidEntryPoint
class ShoppingActivity : AppCompatActivity() {

//    private lateinit var binding: ActivityShoppingBinding

    val binding by lazy{
        ActivityShoppingBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_shopping)
//        binding = ActivityShoppingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.shoppingHostFragment)
        binding.bottomNavigation.setupWithNavController(navController)

//        reffer to https://www.geeksforgeeks.org/view-binding-with-fragments-in-android-jetpack/ of get back any error in futre

    }
}


