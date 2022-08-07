package uz.ka5.pulishla.ui.fragment

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.yarolegovich.slidingrootnav.SlidingRootNav
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder
import uz.ka5.pulishla.R
import uz.ka5.pulishla.adapters.YarolegovichAdapter
import uz.ka5.pulishla.adapters.model.YarolegovichItem
import uz.ka5.pulishla.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var slidingRootNav: SlidingRootNav

    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()

    }


    private fun setData() {

        binding.apply {
            slidingRootNav = SlidingRootNavBuilder(requireActivity())
                .withDragDistance(180)
                .withRootViewScale(0.75f)
                .withRootViewElevation(25)
                .withToolbarMenuToggle(binding.toolbar)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(true)
                .withMenuLayout(R.layout.drawer_menu)
                .inject()

            bottomNavigation.add(MeowBottomNavigation.Model(1, R.drawable.ic_baseline_home_24))
            bottomNavigation.add(
                MeowBottomNavigation.Model(
                    2,
                    R.drawable.ic_baseline_supervised_user_circle_24
                )
            )
            bottomNavigation.add(MeowBottomNavigation.Model(3, R.drawable.ic_baseline_subtitles_24))
            bottomNavigation.add(MeowBottomNavigation.Model(4, R.drawable.ic_baseline_bookmarks_24))

            bottomNavigation.setOnShowListener(MeowBottomNavigation.ShowListener {

            })
            bottomNavigation.setCount(1, "8")
            bottomNavigation.show(1, true)
            bottomNavigation.setOnClickMenuListener {
                Toast.makeText(requireContext(), it.id.toString(), Toast.LENGTH_SHORT).show()
            }
            bottomNavigation.setOnReselectListener {
                Toast.makeText(requireContext(), it.id.toString(), Toast.LENGTH_SHORT).show()
            }

        }
        val adapter = YarolegovichAdapter(requireContext()) {
            slidingRootNav.closeMenu()
        }
        val list: RecyclerView = requireActivity().findViewById(R.id.drawer_list)
        list.isNestedScrollingEnabled = false
        list.adapter = adapter
        val model: MutableList<YarolegovichItem> = mutableListOf()

        model.add(
            YarolegovichItem(
                resources.getDrawable(R.drawable.ic_baseline_home_24),
                "Home"
            )
        )
        model.add(
            YarolegovichItem(
                resources.getDrawable(R.drawable.ic_baseline_supervised_user_circle_24),
                "Contacts"
            )
        )
        model.add(
            YarolegovichItem(
                resources.getDrawable(R.drawable.ic_baseline_subtitles_24),
                "Subtitles"
            )
        )
        model.add(
            YarolegovichItem(
                resources.getDrawable(R.drawable.ic_baseline_bookmarks_24),
                "BookMarks"
            )
        )
        adapter.model = model
    }

}