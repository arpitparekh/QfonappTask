package com.example.qfonapptask.fragment

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.qfonapptask.adapter.ContentAdapter
import com.example.qfonapptask.api.ApiInterface
import com.example.qfonapptask.api.RetrofitService
import com.example.qfonapptask.databinding.FragmentContentBinding
import com.example.qfonapptask.listener.OnImageClickListener
import com.example.qfonapptask.model.Content
import com.example.qfonapptask.model.DataItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.ByteArrayOutputStream


class ContentFragment : Fragment(), OnImageClickListener {

    lateinit var binding : FragmentContentBinding
    lateinit var contentAdapter: ContentAdapter
    lateinit var list : ArrayList<DataItem>
    lateinit var api : ApiInterface
    lateinit var listener : OnImageClickListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listener = this
        list = ArrayList()
        contentAdapter = ContentAdapter(list,requireActivity(),listener)
        binding.rvContent.adapter = contentAdapter
        binding.rvContent.layoutManager = LinearLayoutManager(requireActivity())

        val handler = Handler(Looper.getMainLooper())

        api = RetrofitService.getInterface()
        val call =  api.getContents()


        call.enqueue(object : Callback<Content> {
            override fun onResponse(call: Call<Content>, response: Response<Content>) {
                list = response.body()?.data as ArrayList<DataItem>

                handler.post(Runnable {
                    contentAdapter = ContentAdapter(list,requireActivity(),listener)
                    binding.rvContent.adapter = contentAdapter
                    binding.animationView.visibility = View.GONE
                })
            }

            override fun onFailure(call: Call<Content>, t: Throwable) {

            }

        })

    }

    override fun onClick(position: Int) {

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(list[position].content))
        startActivity(intent)

//        //download
//        val result = lifecycleScope.async(Dispatchers.IO){
//            try {
//                val url = URL("url")
//                return@async BitmapFactory.decodeStream(url.openConnection().getInputStream())
//            } catch (e: IOException){
//                println("Error")
//            } catch (e: UnknownServiceException){
//                println("Error2")
//            } catch (e: MalformedURLException){
//                println("Error3")
//            }
//        }
//
//        lifecycleScope.launch {
//            val bitmap = result.await() as Bitmap
//            startActivity(
//                Intent(
//                    Intent.ACTION_VIEW,
//                    Uri.parse(getImageUri(requireActivity(),bitmap).toString())
//                )
//            )
//        }
    }

    fun getImageUri(inContext: Context, inImage: Bitmap): Uri? {
        val bytes = ByteArrayOutputStream()
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
        val path = MediaStore.Images.Media.insertImage(
            inContext.contentResolver,
            inImage,
            "image",
            null
        )
        return Uri.parse(path)
    }
}