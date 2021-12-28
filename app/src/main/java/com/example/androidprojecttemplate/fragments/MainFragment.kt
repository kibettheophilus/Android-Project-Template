package com.example.androidprojecttemplate.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidprojecttemplate.adapters.MainAdapter
import com.example.androidprojecttemplate.databinding.FragmentMainBinding
import com.example.androidprojecttemplate.viewmodels.MainViewModel
import com.example.domain.utils.Status
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {
    private val viewModel: MainViewModel by viewModel()
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: MainAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi()
        setupAdapterClick()
        setupObservers()
    }

    private fun setupUi() {
        adapter = MainAdapter()
        progressBar = binding.mainProgressbar
        recyclerView = binding.mainRecyclerview
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }

    private fun setupAdapterClick() {
        adapter.setOnItemClickListener {
            val action = MainFragmentDirections.actionMainFragmentToDetailsFragment(it.id)
            findNavController().navigate(action)
        }
    }

    private fun setupObservers() {
        viewModel.getDummyDataStatus.observe(viewLifecycleOwner, {
            when (it.status) {
                Status.SUCCESS -> {
                    progressBar.isVisible = false
                    adapter.differ.submitList(it.data)
                }
                Status.LOADING -> {
                    progressBar.isVisible = true
                }
                Status.ERROR -> {
                    progressBar.isVisible = false
                    Toast.makeText(context, "${it.message}", Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}