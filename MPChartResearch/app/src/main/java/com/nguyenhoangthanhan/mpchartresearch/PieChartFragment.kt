package com.nguyenhoangthanhan.mpchartresearch

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.nguyenhoangthanhan.mpchartresearch.databinding.FragmentHomeBinding
import com.nguyenhoangthanhan.mpchartresearch.databinding.FragmentPieChartBinding

class PieChartFragment : Fragment() {

    private var _binding: FragmentPieChartBinding? = null
    private val binding get() = _binding!!

    private val colors = listOf(
        Color.LTGRAY,
        Color.BLUE,
        Color.CYAN,
        Color.DKGRAY,
        Color.GREEN,
        Color.MAGENTA,
        Color.RED
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPieChartBinding.inflate(inflater, container, false)
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
        val pieDataSet = PieDataSet(dataPieChartValue1(), "").also { it.colors = colors }
        val pieData = PieData(pieDataSet)

        binding.pieChart.apply {
            data = pieData
            invalidate()
        }
    }

    private fun initView() {

    }

    private fun initEvents() {

    }

    private fun dataPieChartValue1(): List<PieEntry>{
        return listOf(
            PieEntry(15f, "Sun"),
            PieEntry(34f, "Mon"),
            PieEntry(23f, "Tue"),
            PieEntry(86f, "Wed"),
            PieEntry(26f, "Thu"),
            PieEntry(17f, "Fri"),
            PieEntry(63f, "Sat"),
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}