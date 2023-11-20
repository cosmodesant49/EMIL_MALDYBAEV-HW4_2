package com.geeks.emil_maldybaev_hw4_2.ui.onBoardinag.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.geeks.emil_maldybaev_hw4_2.databinding.FragmentOnBoardingBinding
import com.geeks.emil_maldybaev_hw4_2.databinding.ItemOnboardingBinding
import com.geeks.emil_maldybaev_hw4_2.model.OnBoarding

class OnBoardingAdapter(private val onClick: () -> Unit) :
    Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {
    private val list = arrayListOf<OnBoarding>(
        OnBoarding(
            "https://goods-photos.static1-sima-land.com/items/1879617/0/700-nw.jpg",
            "Gtx 1050ti",
            "видеокарта для пк бюджета до 25 000, тянет большенство игр до 2020 года"
        ),
        OnBoarding(
            "https://m.media-amazon.com/images/I/71M4pG5B6zS.jpg",
            "Gtx 1660 super/ti",
            "видеокарта для пк бюджета до 50 000, тянет большенство игр до 2023 года"
        ),
        OnBoarding(
            "https://www.digitaltrends.com/wp-content/uploads/2022/10/12-pin.00_00_03_05.Still003.jpg?fit=720%2C404&p=1",
            "Rtx 4090",
            "видеокарта для пк c большим бюджетом, тянет все игры и будет тянуть еще несколько лет"
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnboardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
                return list.size

        }

        override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
            holder.bind((list.get(position)))
        }

        inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding) :
            ViewHolder(binding.root) {
            fun bind(boarding: OnBoarding) {
                binding.tvTitle.text = boarding.title
                binding.tvDesc.text = boarding.desc

                Glide.with(binding.ivBoard.context).load(boarding.image).into(binding.ivBoard)
                binding.btnStart.isVisible = adapterPosition == list.lastIndex
                binding.tvSkip.isVisible = adapterPosition != list.lastIndex
                binding.tvSkip.setOnClickListener { onClick() }
                binding.btnStart.setOnClickListener { onClick() }
            }
        }

    }
