package lk.ac.kln.mit.stu.mobileapplicationdevelopment.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import lk.ac.kln.mit.stu.mobileapplicationdevelopment.R

class ViewOrderActivity : AppCompatActivity() {

    private lateinit var dbref : DatabaseReference
    private lateinit var userRecyclerView: RecyclerView
    private lateinit var userArrayList: ArrayList<lk.ac.kln.mit.stu.mobileapplicationdevelopment.data.OrderDetail>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_order)

        userRecyclerView = findViewById(R.id.orderDetails)
        userRecyclerView.layoutManager = LinearLayoutManager(this)
        userRecyclerView.setHasFixedSize(true)

        userArrayList = arrayListOf<lk.ac.kln.mit.stu.mobileapplicationdevelopment.data.OrderDetail>()
        getUserData()

    }

    private fun getUserData() {
        dbref = FirebaseDatabase.getInstance().getReference("Orders")

        dbref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (userSnapshot in snapshot.children){
                        val user = userSnapshot.getValue(lk.ac.kln.mit.stu.mobileapplicationdevelopment.data.OrderDetail::class.java)
                        userArrayList.add(user!!)
                    }
                    userRecyclerView.adapter = lk.ac.kln.mit.stu.mobileapplicationdevelopment.adapter.DataAdapter(userArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}