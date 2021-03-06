package a4if1.insa.com.oboolo

import android.content.Intent
import android.opengl.Visibility
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_add_event -> {
                message.setText(R.string.title_add_event)
                val intent = Intent(this, AddEventActivity::class.java)
                intent.putExtra("action","create")
                startActivity(intent)
                return@OnNavigationItemSelectedListener false //Impératif de laisser false
            }
            R.id.navigation_day_planning -> {
                //message.setText(R.string.title_day_planning)
                val fragment = DayViewPlanningFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_week_planning -> {
                //message.setText(R.string.title_week_planning)
                val fragment = WeekViewPlanningFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_courses -> {
                message.visibility= View.GONE;
                val fragment = CoursesFragment2()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    /**
     * add/replace fragment in container [framelayout]
     */
    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out)
                .replace(R.id.replaceFrame, fragment, fragment.javaClass.getSimpleName())
                .addToBackStack(fragment.javaClass.getSimpleName())
                .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        navigation.setSelectedItemId(R.id.navigation_day_planning)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.top_menu_default, menu)
        menu.getItem(0).setOnMenuItemClickListener {
            finish()
            true
        }
        menu.getItem(1).setOnMenuItemClickListener {
            Toast.makeText(applicationContext, "Updated", Toast.LENGTH_SHORT)
            true
        }
        menu.getItem(2).setOnMenuItemClickListener {
            val intent = Intent(this@MainActivity, SettingsActivity::class.java)
            startActivity(intent)
            true
        }
        return true
    }
}
