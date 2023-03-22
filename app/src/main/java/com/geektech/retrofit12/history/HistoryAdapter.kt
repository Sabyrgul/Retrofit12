package com.geektech.retrofit12.history

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.geektech.retrofit12.ActivityViewModel
import com.geektech.retrofit12.App
import com.geektech.retrofit12.CalculateModel
import com.geektech.retrofit12.databinding.HistoryItemsBinding

class HistoryAdapter(private var calculateModels: MutableList<CalculateModel> = ArrayList(),val listener:IItemClick): RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    fun renew(list: List<CalculateModel>) {
        calculateModels = list.toMutableList()
        notifyDataSetChanged()
    }

    fun delete(position: Int){
        App.db.getCalculateDao().deleteCalculateModel(calculateModels[position])
    }


   inner class ViewHolder (private val binding: HistoryItemsBinding)
       :RecyclerView.ViewHolder(binding.root){

       fun bind(calculateModel: CalculateModel) {
           binding.tvMe.text=calculateModel.firstName
           binding.tvYou.text=calculateModel.secondName
           binding.tvPercentage.text=calculateModel.percentage+"%"
           binding.historyItems.setOnClickListener {
               listener.delete(adapterPosition)
           }
       }

   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            HistoryItemsBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(calculateModels[position])
    }

    override fun getItemCount()=calculateModels.size
}