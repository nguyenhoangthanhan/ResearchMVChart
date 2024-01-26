package com.nguyenhoangthanhan.mpchartresearch

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.LegendEntry
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import com.github.mikephil.charting.formatter.IValueFormatter
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.github.mikephil.charting.utils.ViewPortHandler
import com.nguyenhoangthanhan.mpchartresearch.databinding.FragmentLineChart1Binding

class LineChart1Fragment : Fragment() {

    private var _binding: FragmentLineChart1Binding? = null
    private val binding get() = _binding!!

    private val lineDataSet1 = LineDataSet(dataValues1(), "Data set 1")
    private val lineDataSet2 = LineDataSet(dataValues2(), "Data set 2")
    private lateinit var dataSets: MutableList<LineDataSet>
    private lateinit var data: LineData

    private lateinit var legendEntries: MutableList<LegendEntry>

    private lateinit var legendsColors:Array<Int>
    private val legendsColors2 = intArrayOf(R.color.color1, R.color.color2, R.color.color3, R.color.color4)
    private val legendNames = arrayOf("Cow", "Dog", "Cat", "Rat")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLineChart1Binding.inflate(inflater, container, false)
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
        legendsColors = arrayOf(
            resources.getColor(R.color.color1, null),
            resources.getColor(R.color.color2, null),
            resources.getColor(R.color.color3, null),
            resources.getColor(R.color.color4, null)
        )

        dataSets = mutableListOf(lineDataSet1)
        dataSets.add(lineDataSet2)

        data = LineData(dataSets as List<ILineDataSet>?)

        legendEntries = mutableListOf()
        for (i in 0..3 step 1) {
            val legendEntry = LegendEntry()
            legendEntry.formColor = legendsColors[i]
            legendEntry.label = legendNames[i]
            legendEntry.form = Legend.LegendForm.SQUARE
            legendEntries.add(legendEntry)
        }
    }

    private fun initView() {
        binding.lineChart.data = data
        binding.lineChart.invalidate()
//        binding.lineChart.setBackgroundColor(Color.GREEN)
        binding.lineChart.setNoDataText("No data in current!")
        binding.lineChart.setNoDataTextColor(Color.BLUE)
        binding.lineChart.setDrawGridBackground(false)
        binding.lineChart.setDrawBorders(true)
        binding.lineChart.setBorderColor(Color.RED)
        binding.lineChart.setBorderWidth(5f)

        lineDataSet1.lineWidth = 4f
        lineDataSet1.color = Color.MAGENTA
        lineDataSet1.setDrawCircles(true)
        lineDataSet1.setDrawCircleHole(true)
        lineDataSet1.setCircleColor(Color.GREEN)
        lineDataSet1.circleHoleColor = Color.RED
        lineDataSet1.circleRadius = 20f
        lineDataSet1.circleHoleRadius = 15f
        lineDataSet1.valueTextSize = 20f
        lineDataSet1.valueTextColor = 0xFF14B6E3.toInt()
//        lineDataSet1.enableDashedLine(30f,5f,0f)
        lineDataSet1.setColors(legendsColors2, requireActivity())

        val xAxis = binding.lineChart.xAxis
        val xAxisLeft = binding.lineChart.axisLeft
        val xAxisRight = binding.lineChart.axisRight
        xAxis.valueFormatter = MyAxisValueFormatter()
        xAxisLeft.valueFormatter = MyAxisValueFormatter()

        val description = Description()
        description.apply {
            text = "Temperature"
            textColor = Color.BLUE
            textSize = 25f
        }

        binding.lineChart.description = description

//        val legend = binding.lineChart.legend
//        legend.isEnabled = true
//        legend.textColor = Color.GREEN
//        legend.textSize = 22f
//        legend.form = Legend.LegendForm.CIRCLE
//        legend.formSize = 22f
//        legend.xEntrySpace = 80f
//        legend.formToTextSpace = 10f

//        legend.setCustom(legendEntries)

//        data.setValueFormatter(MyValueFormatter())
        lineDataSet1.valueFormatter = MyValueFormatter()
    }

    private fun initEvents() {

    }

    private fun dataValues1(): MutableList<Entry> {
        return mutableListOf(
            Entry(0f, 20f),
            Entry(1f, 24f),
            Entry(2f, 2f),
            Entry(3f, 10f),
            Entry(4f, 20f),
        )
    }

    private fun dataValues2(): MutableList<Entry> {
        return mutableListOf(
            Entry(0f, 12f),
            Entry(2f, 16f),
            Entry(3f, 23f),
            Entry(5f, 1f),
            Entry(7f, 18f),
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    inner class MyValueFormatter : ValueFormatter() {
        override fun getFormattedValue(value: Float): String {
            return ("$value $")
        }
    }

    inner class MyAxisValueFormatter : ValueFormatter() {
        override fun getAxisLabel(value: Float, axis: AxisBase?): String {
            axis?.setLabelCount(3, true)
            return "$value $"
        }
    }
}