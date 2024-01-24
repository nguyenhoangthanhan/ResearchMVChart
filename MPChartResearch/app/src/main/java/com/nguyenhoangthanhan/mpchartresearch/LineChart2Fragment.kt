package com.nguyenhoangthanhan.mpchartresearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nguyenhoangthanhan.mpchartresearch.databinding.FragmentLineChart2Binding

class LineChart2Fragment : Fragment() {

    private var _binding: FragmentLineChart2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLineChart2Binding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initView()
        initEvents()
    }

    private fun initData() {

    }

    private fun initView() {

    }

    private fun initEvents() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}