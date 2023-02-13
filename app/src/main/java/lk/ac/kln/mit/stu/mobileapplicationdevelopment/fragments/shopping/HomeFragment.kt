package lk.ac.kln.mit.stu.mobileapplicationdevelopment.fragments.shopping

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import lk.ac.kln.mit.stu.mobileapplicationdevelopment.R
import lk.ac.kln.mit.stu.mobileapplicationdevelopment.adapter.HomeViewpagerAdapter
import lk.ac.kln.mit.stu.mobileapplicationdevelopment.databinding.FragmentHomeBinding
import lk.ac.kln.mit.stu.mobileapplicationdevelopment.fragments.categories.*

class HomeFragment: Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoriesFragments = arrayListOf<Fragment>(
            MainCategoryFragment(),
            BedroomFragment(),
            BathroomFragment(),
            DiningroomFragment(),
            KitchenroomFragment(),
            LivingroomFragment()
        )

        binding.viewpagerHome.isUserInputEnabled =false

        val viewpagerAdapter = HomeViewpagerAdapter(categoriesFragments, childFragmentManager,lifecycle)
        binding.viewpagerHome.adapter = viewpagerAdapter
        TabLayoutMediator(binding.tabLayout,binding.viewpagerHome){ tab, position ->
            when(position){
                0 -> tab.text = "All Products"
                1 -> tab.text = "Bedroom Products"
                2 -> tab.text = "Bathroom Products"
                3 -> tab.text = "Diningroom Products"
                4 -> tab.text = "Kitchenroom Products"
                5 -> tab.text = "Livingroom Products"
            }
        }.attach()
    }
}