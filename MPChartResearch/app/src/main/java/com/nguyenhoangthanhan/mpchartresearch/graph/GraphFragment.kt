package com.nguyenhoangthanhan.mpchartresearch.graph

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import com.nguyenhoangthanhan.mpchartresearch.BarChart2Fragment
import com.nguyenhoangthanhan.mpchartresearch.BarChartFragment
import com.nguyenhoangthanhan.mpchartresearch.LineChart1Fragment
import com.nguyenhoangthanhan.mpchartresearch.PieChartFragment
import com.nguyenhoangthanhan.mpchartresearch.R
import com.nguyenhoangthanhan.mpchartresearch.StackedBarChartFragment
import com.nguyenhoangthanhan.mpchartresearch.databinding.FragmentGraphBinding
import com.nguyenhoangthanhan.mpchartresearch.databinding.FragmentHomeBinding

class GraphFragment : Fragment() {

    private var _binding: FragmentGraphBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGraphBinding.inflate(inflater, container, false)
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