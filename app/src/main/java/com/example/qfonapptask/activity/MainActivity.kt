package com.example.qfonapptask.activity

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.qfonapptask.R
import com.example.qfonapptask.adapter.MyPagerAdapter
import com.example.qfonapptask.api.ApiInterface
import com.example.qfonapptask.api.RetrofitService
import com.example.qfonapptask.databinding.ActivityMainBinding
import com.example.qfonapptask.fragment.MyDialogFragment
import com.example.qfonapptask.model.Content
import com.example.qfonapptask.model.DataItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var api : ApiInterface
    lateinit var pageAdapter : MyPagerAdapter
    lateinit var list : ArrayList<DataItem>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        list = ArrayList()
        pageAdapter = MyPagerAdapter(supportFragmentManager,lifecycle)
        binding.viewPager.adapter = pageAdapter
        binding.viewPager.isUserInputEnabled = false

        val w: Window = window
        w.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){

                R.id.action_home ->{
                    binding.viewPager.currentItem = 0
                }
                R.id.action_feed ->{
                    binding.viewPager.currentItem = 1
                }
                R.id.action_add ->{

                }
                R.id.action_video ->{

                }
                R.id.action_profile ->{

                }

            }
            true
        }

        binding.toolbar.setNavigationOnClickListener {
            val dialogFragment = MyDialogFragment()
            dialogFragment.show(supportFragmentManager,"Mydialog")
        }

    }
}