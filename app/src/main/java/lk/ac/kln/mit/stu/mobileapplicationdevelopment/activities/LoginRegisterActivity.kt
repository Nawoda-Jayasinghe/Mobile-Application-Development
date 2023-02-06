package lk.ac.kln.mit.stu.mobileapplicationdevelopment.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import lk.ac.kln.mit.stu.mobileapplicationdevelopment.R

class LoginRegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_introduction)

        val getStart = findViewById<Button>(R.id.btnGetStart)
        getStart.setOnClickListener{
            //we use intend to navigate form one activity to another
            // we have to give 2 arguments here. (current view, the pace we want to naigated)
            val intent = Intent(this, ShoppingActivity ::class.java) // this is an intent object

            //intent is a class in android libraries. here we have created an object from the class
            //mostly in android we create objects from andoird classes and invoke the functions.
            //but sometimes we have to create own classes and objects
            startActivity(intent) //now we navigate from one activity to another
        }
    }


    //check git branch 2
}