package com.udacity.shoestore

import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe

class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private val viewModel: ShoeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnShoeDetail.setOnClickListener {
            findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }
        viewModel.shoesCount.observe(viewLifecycleOwner) { newShoesCount ->
            // TODO("Quantity of elements in LinearLayout")
        }
        viewModel.shoes.observe(viewLifecycleOwner) { shoes ->
            updateView(shoes)
        }
    }

    private fun updateView(shoes: MutableList<Shoe>) {
        TODO("Show all the text views")
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ShoeListFragment().apply {

            }
    }
}