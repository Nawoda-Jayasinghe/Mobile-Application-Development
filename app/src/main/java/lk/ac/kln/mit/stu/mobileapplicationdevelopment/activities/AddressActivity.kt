package lk.ac.kln.mit.stu.mobileapplicationdevelopment.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import lk.ac.kln.mit.stu.mobileapplicationdevelopment.R
import lk.ac.kln.mit.stu.mobileapplicationdevelopment.databinding.ActivityShoppingBinding
import lk.ac.kln.mit.stu.mobileapplicationdevelopment.databinding.FragmentAddressBinding

class AddressActivity : AppCompatActivity() {
    private lateinit var binding : FragmentAddressBinding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentAddressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener{

            var edFullName = binding.edFullName.text.toString()
            var edMobile = binding.edMobile.text.toString()
            var edHomeNumber = binding.edHomeNumber.text.toString()
            var edStreet = binding.edStreet.text.toString()
            var edCity = binding.edCity.text.toString()
            var edProvince = binding.edProvince.text.toString()

            database = FirebaseDatabase.getInstance().getReference("Address")
            val Address = Address(edFullName,edMobile,edHomeNumber,edStreet,edCity,edProvince)
            database.child(edFullName).setValue(Address).addOnSuccessListener {

                binding.edFullName.text.clear()
                binding.edMobile.text.clear()
                binding.edHomeNumber.text.clear()
                binding.edStreet.text.clear()
                binding.edCity.text.clear()
                binding.edProvince.text.clear()

                Toast.makeText(this,"Successfully Saved",Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
            }

        }
    }
}