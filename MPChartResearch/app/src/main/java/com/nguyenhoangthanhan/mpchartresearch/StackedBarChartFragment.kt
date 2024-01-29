package com.nguyenhoangthanhan.mpchartresearch

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.nguyenhoangthanhan.mpchartresearch.databinding.FragmentLineChart2Binding
import com.nguyenhoangthanhan.mpchartresearch.databinding.FragmentStackedBarChartBinding

class StackedBarChartFragment : Fragment() {

    private var _binding: FragmentStackedBarChartBinding? = null
    private val binding get() = _binding!!

    private val colors = listOf(Color.RED, Color.GREEN, Color.BLUE)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStackedBarChartBinding.inflate(inflater, container, false)
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
        val barDataSet = BarDataSet(dataValues1(), "Bar Set")
        barDataSet.colors = colors

        val barData = BarData(barDataSet)
        binding.stackedBarChart.data = barData
    }

    private fun initView() {

    }

    private fun initEvents() {

    }

    private fun dataValues1(): List<BarEntry>{
        return listOf(
            BarEntry(0f, floatArrayOf(2f, 5.5f, 4f)),
            BarEntry(1f, floatArrayOf(2f, 8f, 5.3f)),
            BarEntry(3f, floatArrayOf(2f, 3f, 8f))
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}