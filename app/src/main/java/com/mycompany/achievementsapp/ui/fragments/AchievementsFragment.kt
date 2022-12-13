package com.mycompany.achievementsapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mycompany.achievementsapp.R
import com.mycompany.achievementsapp.api.Api
import com.mycompany.achievementsapp.data.Achievements
import com.mycompany.achievementsapp.databinding.FragmentAchievementBinding
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class AchievementsFragment : Fragment(R.layout.fragment_achievement) {


    private val viewModel by viewModels<AchievementsViewModel>()

    private val TAG = "AchievementsFragment"
    lateinit var binding: FragmentAchievementBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAchievementBinding.bind(view)

        getMyData()

    }

    fun getMyData() {
        val retrofit =
            Retrofit.Builder()
                .baseUrl("https://786b905e-735c-4be6-adfb-949d5dadee32.mock.pstmn.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Api::class.java)
        val achievements = retrofit.getAchievements()

        achievements.enqueue(object : Callback<Achievements?> {
            override fun onResponse(
                call: Call<Achievements?>,
                response: Response<Achievements?>
            ) {
                val responseBody=response.body()
                val myStringBuilder=StringBuilder()
                val title1=myStringBuilder.append(responseBody!!.data[1].title)
                binding.tvTitle1.text=title1
            }

            override fun onFailure(call: Call<Achievements?>, t: Throwable) {
                Log.d(TAG, "onFailure: kazim ${t.message}")
            }
        })

    }

}