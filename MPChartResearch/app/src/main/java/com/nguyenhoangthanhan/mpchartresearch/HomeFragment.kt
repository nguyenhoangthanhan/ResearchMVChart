package com.nguyenhoangthanhan.mpchartresearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.nguyenhoangthanhan.mpchartresearch.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
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
        binding.btnOpenLineChart1.setOnClickListener {
            parentFragmentManager.commit {
                val lineChart1Fragment: Fragment = LineChart1Fragment()
                val arguments = Bundle()
                arguments.putBoolean("shouldYouCreateAChildFragment", true)
                lineChart1Fragment.arguments = arguments
                replace(R.id.container, lineChart1Fragment, LineChart1Fragment::class.java.canonicalName)
                addToBackStack(LineChart1Fragment::class.java.canonicalName)
            }
        }
        binding.btnOpenBarChart.setOnClickListener {
            parentFragmentManager.commit {
                val barChartFragment: Fragment = BarChartFragment()
                val arguments = Bundle()
                arguments.putBoolean("bar_chart", true)
                barChartFragment.arguments = arguments
                replace(R.id.container, barChartFragment, BarChartFragment::class.java.canonicalName)
                addToBackStack(BarChartFragment::class.java.canonicalName)
            }
        }
        binding.btnOpenBarChart2.setOnClickListener {
            parentFragmentManager.commit {
                val barChart2Fragment: Fragment = BarChart2Fragment()
                val arguments = Bundle()
                arguments.putBoolean("bar_chart2", true)
                barChart2Fragment.arguments = arguments
                replace(R.id.container, barChart2Fragment, BarChart2Fragment::class.java.canonicalName)
                addToBackStack(BarChart2Fragment::class.java.canonicalName)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}