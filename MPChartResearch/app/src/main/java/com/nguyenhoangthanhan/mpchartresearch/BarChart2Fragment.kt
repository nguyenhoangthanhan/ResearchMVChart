package com.nguyenhoangthanhan.mpchartresearch

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.nguyenhoangthanhan.mpchartresearch.databinding.FragmentBarChart2Binding

class BarChart2Fragment : Fragment() {

    private var _binding: FragmentBarChart2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBarChart2Binding.inflate(inflater, container, false)
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
        val barDataSet1 = BarDataSet(barEntries1(), "Data Set 1").also { it.color = Color.RED }
        val barDataSet2 = BarDataSet(barEntries2(), "Data Set 2").also { it.color = Color.BLUE }
        val barDataSet3 = BarDataSet(barEntries3(), "Data Set 3").also { it.color = Color.MAGENTA }
        val barDataSet4 = BarDataSet(barEntries4(), "Data Set 4").also { it.color = Color.GREEN }

        val data = BarData(barDataSet1, barDataSet2, barDataSet3, barDataSet4)

        val days = listOf("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
        val barSpace = 0.05f
        val groupSpace = 0.16f
        data.barWidth = 0.16f

        binding.mpBarChart.apply {
            this.data = data
            this.xAxis.apply {
                valueFormatter = IndexAxisValueFormatter(days)
                setCenterAxisLabels(true)
                position = XAxis.XAxisPosition.BOTTOM
                granularity = 1f
                isGranularityEnabled = true
                axisMinimum = 0f
                axisMaximum = 0 + binding.mpBarChart.barData.getGroupWidth(groupSpace, barSpace) * 7
            }
            isDragEnabled = true
            setVisibleXRangeMaximum(3f)
            axisLeft.axisMinimum = 0f
            groupBars(0f, groupSpace, barSpace)
            invalidate()
        }


    }

    private fun initView() {

    }

    private fun initEvents() {

    }

    private fun barEntries1(): MutableList<BarEntry>? {
        return mutableListOf(
            BarEntry(0f, 2000f),
            BarEntry(1f, 791f),
            BarEntry(2f, 630f),
            BarEntry(3f, 458f),
            BarEntry(4f, 2724f),
            BarEntry(3f, 500f),
            BarEntry(4f, 2173f),
        )
    }

    private fun barEntries2(): MutableList<BarEntry>? {
        return mutableListOf(
            BarEntry(0f, 900f),
            BarEntry(1f, 631f),
            BarEntry(2f, 1040f),
            BarEntry(3f, 382f),
            BarEntry(4f, 2614f),
            BarEntry(3f, 5000f),
            BarEntry(4f, 1173f),
        )
    }

    private fun barEntries3(): MutableList<BarEntry>? {
        return mutableListOf(
            BarEntry(0f, 400f),
            BarEntry(1f, 231f),
            BarEntry(2f, 100f),
            BarEntry(3f, 768f),
            BarEntry(4f, 1514f),
            BarEntry(3f, 9874f),
            BarEntry(4f, 1273f),
        )
    }

    private fun barEntries4(): MutableList<BarEntry>? {
        return mutableListOf(
            BarEntry(0f, 100f),
            BarEntry(1f, 291f),
            BarEntry(2f, 1230f),
            BarEntry(3f, 1168f),
            BarEntry(4f, 114f),
            BarEntry(3f, 950f),
            BarEntry(4f, 173f),
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