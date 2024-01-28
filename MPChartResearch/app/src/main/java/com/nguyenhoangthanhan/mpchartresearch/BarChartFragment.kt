package com.nguyenhoangthanhan.mpchartresearch

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.nguyenhoangthanhan.mpchartresearch.databinding.FragmentLineChart2Binding

class BarChartFragment : Fragment() {

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
        val barDataSet1 = BarDataSet(dataValues1(), "Data set 1").also { it.color = Color.GREEN }
        val barDataSet2 = BarDataSet(dataValues2(), "Data set 2").also { it.color = Color.RED }
        val barData = BarData().also {
            it.addDataSet(barDataSet1)
            it.addDataSet(barDataSet2)
        }

        binding.mpBarChart.data = barData
        binding.mpBarChart.invalidate()
    }

    private fun initView() {

    }

    private fun initEvents() {

    }

    private fun dataValues1(): MutableList<BarEntry>? {
        return mutableListOf(
            BarEntry(0f, 20f),
            BarEntry(1f, 24f),
            BarEntry(2f, 2f),
            BarEntry(3f, 10f),
            BarEntry(4f, 20f),
        )
    }

    private fun dataValues2(): MutableList<BarEntry>? {
        return mutableListOf(
            BarEntry(1.8f, 2f),
            BarEntry(2f, 6f),
            BarEntry(3.6f, 8f),
            BarEntry(3f, 18f),
            BarEntry(4f, 9f),
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}