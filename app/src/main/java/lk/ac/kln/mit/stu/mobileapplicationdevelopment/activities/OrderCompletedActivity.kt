package lk.ac.kln.mit.stu.mobileapplicationdevelopment.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import lk.ac.kln.mit.stu.mobileapplicationdevelopment.R

class OrderCompletedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_completed)
        val viewOrderButton = findViewById<Button>(R.id.btnViewOrder)
        viewOrderButton.setOnClickListener {
            val intent = Intent(this, ViewOrderActivity::class.java)
            startActivity(intent)
        }
    }
}