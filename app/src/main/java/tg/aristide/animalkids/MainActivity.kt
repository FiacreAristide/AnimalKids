package tg.aristide.animalkids

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var animalList: List<Animal>
    private lateinit var categorieSelectionnee: String

    private var mediaPlayer: MediaPlayer? = null

    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewPager)


        val categorieSelectionnee = intent.getStringExtra("categorie")

       when(categorieSelectionnee){
           "mammifères"-> animalList = listOf(
               Animal("Lion", "Le Lion (Panthera leo) est une espèce de mammifères carnivores de la famille des Félidés. La femelle du lion est la lionne, son petit est le lionceau. Le mâle adulte, aisément reconnaissable à son importante crinière, accuse une masse moyenne qui peut être variable selon les zones géographiques où il se trouve, allant de 145 à 180 kg pour les lions d'Asie à plus de 225 kg pour les lions d'Afrique. Certains spécimens très rares peuvent dépasser exceptionnellement 300 kg. Un mâle adulte se nourrit de 7 kg de viande chaque jour contre 5 kg chez la femelle. Le lion est un animal grégaire, c'est-à-dire qu'il vit en larges groupes familiaux, contrairement aux autres félins. Son espérance de vie, à l'état sauvage, est comprise entre 7 et 12 ans pour le mâle et 14 à 20 ans pour la femelle, mais il dépasse fréquemment les 30 ans en captivité.", R.drawable.lion),
               Animal("Tigre", "Le Tigre (Panthera tigris) est une espèce de mammifère carnivore de la famille des félidés (Felidae) du genre Panthera. Aisément reconnaissable à sa fourrure rousse rayée de noir, c'est le plus grand félin sauvage et l'un des plus grands carnivores terrestres, dépassé seulement par les plus grandes espèces d'ours. L'espèce est divisée en neuf sous-espèces présentant des différences mineures de taille ou de comportement. Superprédateur, il chasse principalement les cerfs et les sangliers, bien qu'il puisse s'attaquer à des proies de taille plus importante comme les buffles jusqu'à l'énorme gayal (rarement attaqué en raison de sa taille imposante et de ses cornes qui peuvent tuer un tigre adulte)", R.drawable.tigre),
               Animal("Koala", "Le koala (Phascolarctos cinereus), appelé aussi Paresseux australien, est une espèce de marsupiaux arboricoles herbivores, endémique d'Australie et le seul représentant encore vivant de la famille des Phascolarctidés. On le trouve dans les régions côtières de l'Australie-Méridionale et orientale, d'Adélaïde à la partie sud de la péninsule du cap York. Les populations s'étendent aussi sur des distances considérables dans l'arrière-pays australien (outback), là où l'humidité est suffisante pour le maintien de forêts. ", R.drawable.koala),
               Animal("Chimpanzé", "Le Chimpanzé (Pan) est un genre de Simiformes (singes) appartenant à la famille des Hominidés1 (grands singes). Ce genre comprend deux espèces : le Chimpanzé commun (Pan troglodytes) et le Chimpanzé nain, plus connu sous le nom de Bonobo (Pan paniscus). Ces hominidés d'Afrique équatoriale et débordant sur l'Afrique tropicale sont les animaux les plus proches génétiquement d'Homo sapiens, avec 98,8 % de leur ADN en commun.", R.drawable.chimpanze),
               Animal("Gorille", "Gorilla, les Gorilles, est un genre de singes appartenant à la famille des Hominidés.Les gorilles sont les plus grands des hominoïdes. Les mâles, en particulier, peuvent développer une force physique colossale.Les gorilles vivent en groupes dans les forêts tropicales ou subtropicales, où ils se nourrissent de végétaux et parfois d'insectes. Leur présence couvre un faible pourcentage de l'Afrique et ce sont des espèces menacées de disparition. On les trouve à des altitudes très variées", R.drawable.gorille),
               Animal("Elephant", "Les éléphants sont des mammifères proboscidiens de la famille des Éléphantidés. Ils correspondent aujourd'hui à trois espèces réparties en deux genres distincts. L'éléphant de savane d'Afrique et l'éléphant de forêt d'Afrique, autrefois regroupés sous la même espèce d'« éléphant d'Afrique », appartiennent au genre Loxodonta, tandis que l'éléphant d'Asie, anciennement appelé « éléphant indien », appartient au genre Elephas. Ils se différencient par certaines caractéristiques anatomiques, les éléphants d'Asie étant en général plus petits avec des oreilles plus petites, ou encore une différence du bout de la trompe", R.drawable.elephant),
               Animal("Girafe", "La Girafe (Giraffa camelopardalis) est une espèce de mammifères ongulés artiodactyles, du groupe des ruminants, vivant dans les savanes africaines et répandue du Tchad jusqu'en Afrique du Sud. Son nom commun vient de l'arabe زرافة, zarāfah, mais l'animal fut anciennement appelé camélopard, du latin camelopardus1, contraction de camelus (chameau) en raison du long cou et de pardus (léopard) en raison des taches recouvrant son corps. Après des millions d'années d'évolution, la girafe a acquis une anatomie unique avec un cou particulièrement allongé qui lui permet notamment de brouter haut dans les arbres.", R.drawable.girafe),
               Animal("Ours", "Les Ours forment la famille de mammifères des Ursidés (Ursidae), de l'ordre des Carnivores (Carnivora). Le Grand panda, dont la classification a longtemps prêté à débat, est aujourd'hui considéré comme un ours herbivore au sein de cette famille1,2. Il n'existe que huit espèces d'ours vivantes réparties dans une grande variété d'habitats, à la fois dans l'hémisphère Nord et dans une partie de l'hémisphère Sud. Les ours vivent sur les continents d'Europe, d'Amérique, et en Asie.", R.drawable.ours),
               Animal("Renard", "Renard est un terme ambigu qui désigne le plus souvent en français les canidés du genre Vulpes, le plus commun étant le renard roux (Vulpes vulpes). Toutefois, par similitude physique, le terme est aussi employé pour désigner des canidés appartenant à d'autres genres, comme les genres Atelocynus, Cerdocyon, Dusicyon, Otocyon, Lycalopex et Urocyon. Dans la culture populaire, le renard est un personnage symbolique et littéraire qui représente l'intelligence et surtout la ruse.", R.drawable.renard),
           )

           "oiseaux"-> animalList = listOf(
               Animal("Aigle", "Un animal au long cou.", R.drawable.aigle),
               Animal("Autruche", "Un animal rayé.", R.drawable.autruche),
               Animal("Canard", "Un grand prédateur.", R.drawable.canard),
               Animal("Corbeau", "Un grand prédateur.", R.drawable.corbeau),
               Animal("Collibri", "Un grand prédateur.", R.drawable.collibri),
               Animal("Hibou", "Un grand prédateur.", R.drawable.hibou),
               Animal("Merle", "Un grand prédateur.", R.drawable.merle),
           )

           "amphibiens"-> animalList = listOf(
               Animal("Axoliti", "Un mammifère marin intelligent.", R.drawable.axoliti),
               Animal("Moineau", "Un animal arboricole.", R.drawable.moineau),
               Animal("Rainette", "Un oiseau de proie.", R.drawable.rainette),
               Animal("Salamandre", "Un oiseau de proie.", R.drawable.salamandre),
               Animal("Triton", "Un oiseau de proie.", R.drawable.triton),
           )

           "reptiles"-> animalList = listOf(
               Animal("Alligator", "Un oiseau de proie.", R.drawable.alligator),
               Animal("Boa", "Un rapace rapide.", R.drawable.boa),
               Animal("Caméléon", "Un oiseau exotique.", R.drawable.cameleon),
               Animal("Crocodile", "Un oiseau exotique.", R.drawable.crocodile),
               Animal("Iguane", "Un oiseau exotique.", R.drawable.iguane),
               Animal("Python", "Un oiseau exotique.", R.drawable.python),
               Animal("Tequs", "Un oiseau exotique.", R.drawable.tegus),
               Animal("Tortue", "Un oiseau exotique.", R.drawable.tortue),
           )
           "poissons"-> animalList = listOf(
               Animal("Brochet", "Un oiseau de proie.", R.drawable.brochet),
               Animal("Merou", "Un rapace rapide.", R.drawable.merou),
               Animal("Poisson Ange", "Un oiseau exotique.", R.drawable.poisson_ange),
               Animal("Poisson Clown", "Un oiseau exotique.", R.drawable.poisson_clown),
               Animal("Poisson Crapaud", "Un oiseau exotique.", R.drawable.poisson_crapaud),
               Animal("Poisson Globe", "Un oiseau exotique.", R.drawable.poisson_globe),
               Animal("Poisson Mandarin", "Un oiseau exotique.", R.drawable.poisson_mandarin),
               Animal("Poisson Scie", "Un oiseau exotique.", R.drawable.poisson_scie),
               Animal("Saumon", "Un oiseau exotique.", R.drawable.saumon),
               Animal("Thon", "Un oiseau exotique.", R.drawable.thon),
               Animal("Truite", "Un oiseau exotique.", R.drawable.truite),
           )
       }




        mediaPlayer = MediaPlayer.create(this, R.raw.backsong)

        // Configurations supplémentaires du MediaPlayer, si nécessaire
        mediaPlayer?.isLooping = true

        val adapter = AnimalAdapter(animalList)
        viewPager.adapter = adapter
    }

    // Gérez le démarrage du son lorsque l'activité reprend ou démarre
    override fun onResume() {
        super.onResume()
        mediaPlayer?.start()
    }

    // Gérez l'arrêt du son lorsque l'activité est mise en pause ou arrêtée
    override fun onPause() {
        super.onPause()
        mediaPlayer?.pause()
    }

    // Libérez les ressources du MediaPlayer lorsque l'activité est détruite
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }


}
