package com.example.qfonapptask.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.qfonapptask.R
import com.example.qfonapptask.adapter.SettingAdapter
import com.example.qfonapptask.databinding.DrawerLayoutBinding
import com.example.qfonapptask.model.Setting

class MyDialogFragment : DialogFragment() {

    lateinit var binding : DrawerLayoutBinding
    var list = ArrayList<Setting>()
    lateinit var adapter: SettingAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DrawerLayoutBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dialog?.getWindow()?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT)
        dialog?.getWindow()?.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

        binding.rvSettings.layoutManager = LinearLayoutManager(requireActivity())

        list.add(Setting(R.drawable.info,"About Us"))
        list.add(Setting(R.drawable.privacy,"Privacy Policy"))
        list.add(Setting(R.drawable.download,"My Downloads"))
        list.add(Setting(R.drawable.key,"Change Password"))
        list.add(Setting(R.drawable.group,"Discover People"))
        list.add(Setting(R.drawable.logout,"Logout"))

        adapter = SettingAdapter(list)
        binding.rvSettings.adapter = adapter

        binding.close.setOnClickListener {
            dialog?.dismiss()
        }
    }

    override fun getTheme(): Int {
        return R.style.full_screen_dialog
    }

}