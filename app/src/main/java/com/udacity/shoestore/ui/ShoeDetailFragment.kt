package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_shoe_detail.*

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoeDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            btnSave.setOnClickListener {
                saveNewShoe()
            }

            btnCancel.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    private fun saveNewShoe() {
        val shoeName = binding.etShoeName.text.toString()
        val shoeSize = binding.etShoeSize.text.toString().toDouble()
        val shoeCompany = binding.etShoeCompany.toString()
        val shoeDescription = binding.etShoeDescription.toString()

        val newShoe = Shoe(shoeName, shoeSize, shoeCompany, shoeDescription)
        sendResultToPreviousScreen(newShoe)
        findNavController().popBackStack()
    }

    private fun sendResultToPreviousScreen(shoe: Shoe) {
        findNavController().previousBackStackEntry?.savedStateHandle?.set(SHOE, shoe)
    }

    companion object {
        const val SHOE = "shoe"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ShoeDetailFragment().apply {

            }
    }
}