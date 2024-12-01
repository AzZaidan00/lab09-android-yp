package com.azim.lab09

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.azim.lab09.data.PlaceListAdapter
import com.azim.lab09.databinding.ActivityMainBinding
import com.azim.lab09.model.place
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var countryList = ArrayList<place>()
        var kualaLumpur = place(countryName = "Malaysia", cityName = "Kuala Lumpur")
        countryList.add(kualaLumpur)

        var bangkok = place(countryName = "Thailand", cityName = "Bangkok")
        countryList.add(bangkok)

        var jakarta = place(countryName = "Indonesia", cityName = "Jakarta")
        countryList.add(jakarta)

        val adapter = PlaceListAdapter(list = countryList, context = this)
        binding.recyclerView.adapter = adapter
    }

    // Bila menu dibuat, this function will be called
    // Initialize the menu, point the activity to the right menu file
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Dapatkan file menu.xml di dalam folder menu
        // Keluarkan (inflate) menu di sini
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // Bila menu item dipilih
    // Create a when (switch) statement to perform the execution for the menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.about -> {
                // buka Chrome atau Internet dan tunjukkan website tertentu :Peoplelogy
                val openURL = Intent(Intent.ACTION_VIEW)
                openURL.data = Uri.parse("https://peoplelogy.com/")
                startActivity(openURL)
            }
            R.id.email -> {
                // Buka email dan set email : App Feedback and to:
                val mIntent = Intent(Intent.ACTION_SENDTO)
                mIntent.data = Uri.parse("mailto:contact@peoplelogy.com.my")
                startActivity(mIntent)
            }
            R.id.call -> {
                // Add second option to call directly the number
                /*
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:0123456789")
                startActivity(intent)
                */

                // Variable phone number
                val phoneNumber = "1234567890"
                intent.data = Uri.parse("tel:"+phoneNumber)
                startActivity(intent)
                }
            R.id.exit -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
