package lk.ac.kln.mit.stu.mobileapplicationdevelopment.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.inflate
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import lk.ac.kln.mit.stu.mobileapplicationdevelopment.R



class ShoppingActivity : AppCompatActivity() {





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)


        val navController = findNavController(R.id.shoppingHostFragment)
    }
}


