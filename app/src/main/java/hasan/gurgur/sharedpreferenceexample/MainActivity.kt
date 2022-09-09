package hasan.gurgur.sharedpreferenceexample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import hasan.gurgur.sharedpreferenceexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val PREFS_FILENAME = "com.hasans.prefs"
    val KEY_NAME = "NAME"
    val KEY_AGE = "AGE"
    val KEY_HEIGHT = "HEIGHT"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val prefences = getSharedPreferences(PREFS_FILENAME, Context.MODE_PRIVATE)
        val editor = prefences.edit()

        binding.etName.text = prefences.getString(KEY_NAME, "DEFAULT_VALUE")
        binding.etAge.text = prefences.getInt(KEY_AGE, 0).toString()
        binding.etHeight.text = prefences.getInt(KEY_HEIGHT, 0).toString() + " cm"




        binding.save.setOnClickListener {

            if (binding.name.text.isNullOrEmpty() || binding.age.text.toString()
                    .isNullOrEmpty() || binding.height.text.toString().isNullOrEmpty()
            ) {
                Toast.makeText(
                    this,
                    "You should put each comfirmation completely",
                    Toast.LENGTH_SHORT
                ).show()
            } else {

                editor.putString(KEY_NAME, binding.name.text.toString())
                editor.putInt(KEY_AGE, binding.age.text.toString().toInt())
                editor.putInt(KEY_HEIGHT, binding.height.text.toString().toInt())
                editor.apply() // Dosyaya yazılır.
                Toast.makeText(applicationContext, "Kayıt Başarıl...", Toast.LENGTH_SHORT).show()
            }


        }
    }


}