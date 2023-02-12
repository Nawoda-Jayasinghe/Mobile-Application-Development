package lk.ac.kln.mit.stu.mobileapplicationdevelopment.fragments.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import lk.ac.kln.mit.stu.mobileapplicationdevelopment.R
import lk.ac.kln.mit.stu.mobileapplicationdevelopment.databinding.FragmentIntroductionBinding
import lk.ac.kln.mit.stu.mobileapplicationdevelopment.databinding.FragmentOrdersBinding
import lk.ac.kln.mit.stu.mobileapplicationdevelopment.databinding.FragmentProfileBinding

class SettingToAllOrders : Fragment(R.layout.fragment_profile) {
    private lateinit var binding:FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnOrderHistoryAction.setOnClickListener{
            findNavController().navigate(R.id.action_profileFragment_to_allOrdersFragment)
        }
    }
}