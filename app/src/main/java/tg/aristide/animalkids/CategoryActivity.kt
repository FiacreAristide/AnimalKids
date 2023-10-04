package tg.aristide.animalkids

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categorie)

        val cardMammiferes = findViewById<CardView>(R.id.cardMammifere)
        val cardOiseaux = findViewById<CardView>(R.id.cardOiseaux)
        val cardAmphibiens = findViewById<CardView>(R.id.cardAmphibiens)
        val cardPoissons = findViewById<CardView>(R.id.cardPoissons)
        val cardReptiles = findViewById<CardView>(R.id.cardReptiles)


        cardMammiferes.setOnClickListener {
            startMainActivityWith("mammifères")
        }

        cardOiseaux.setOnClickListener {
            startMainActivityWith("oiseaux")
        }

        cardAmphibiens.setOnClickListener {
            startMainActivityWith("amphibiens")
        }

        cardReptiles.setOnClickListener {
            startMainActivityWith("reptiles")
        }

        cardPoissons.setOnClickListener {
            startMainActivityWith("poissons")
        }



    }

    private fun startMainActivityWith(categorie: String) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("categorie", categorie)
        startActivity(intent)
    }
}