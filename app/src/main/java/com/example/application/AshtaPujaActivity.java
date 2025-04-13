package com.example.application;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AshtaPujaActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ashta_puja);

        TextView pujaTextView = findViewById(R.id.pujaTextView);
        TextView dohaTextView = findViewById(R.id.dohaTextView);
        WebView youtubeWebView = findViewById(R.id.youtubeWebView);

        String videoId = "krn7-axV9c0";
        String html = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/" + videoId + "\" frameborder=\"0\" allowfullscreen></iframe>";

        youtubeWebView.getSettings().setJavaScriptEnabled(true);
        youtubeWebView.setWebChromeClient(new WebChromeClient());
        youtubeWebView.loadData(html, "text/html", "utf-8");

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button openYoutubeButton = findViewById(R.id.openYoutubeButton);
        openYoutubeButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/krn7-axV9c0"));
            intent.setPackage("com.google.android.youtube");
            try {
                startActivity(intent);
            } catch (android.content.ActivityNotFoundException e) {
                // Fallback to browser if YouTube app is not installed
                intent.setPackage(null);
                startActivity(intent);
            }
        });


        // Set Puja Description
        pujaTextView.setText(
                        "Ashta Prakari Puja is also known as Snatra Puja.\n You should do " +
                        "the following things to prepare for any type of Puja ceremony : "+
                        "II. Bathe or shower prior to performing Puja \n +  III. Wear clean (recently washed) " +
                        "clothing and do not eat anything or go to the bathroom after putting on those clothes"+
                        "\n IV. Cover your mouth with a handkerchief \n\n The purpose of performing Snatra Puja" +
                        " is to perceive and praise the virtues and attributes of the supreme beings Jineshwar " +
                        "(24 Tirthankars), and thereby remembering to always conduct ones own daily life with the same" +
                        " supreme virtues and attributes.\n\n"+
                        " Meaning of Ashta Prakari Puja : Generally Jains use the following eight items to perform Astha Prakari Puja" +
                        " of a Tirthankar. Each item represents a specific religious virtue. While conducting the puja, one is reminded of " +
                        "the importance of conducting his/her own daily life with the same supreme virtues.\n "+
                        "1. Jala Puja (Water) : Water symbolizes the ocean. Every living being continuously travels through life’s ocean birth," +
                        " death, and misery. This puja reminds that one should live their life with honesty, truthfulness, love and compassion towards" +
                        "all living beings. This way one will be able to cross life’s ocean and attain Moksha or liberation.\n " +
                        "2. Chandan Puja (Sandal Wood) : Chandan symbolizes knowledge (Jnan). By performing this puja, one should strive for Right Knowledge." +
                        " Jainism preaches that the Path of Knowledge is the main path to attain liberation. Bhakti or Devotion helps in the early stages of one's" +
                        " effort for liberation.\n"+
                        "3. Pushpa Puja (Flower) : A flower symbolizes conduct. Our conduct should be like a flower, which provides fragrance and beauty to all living" +
                        " beings without discrimination. We should live our life like a flower, with love and compassion towards all living beings.\n"+
                        "4. Dhoop Puja (Incense) : Dhoop symbolizes the ascetic life. While burning itself, incense provides fragrance to others. Similarly, true monks and " +
                        "nuns spend their entire life selflessly for the benefit of all living beings. This puja reminds that one should strive for an ascetic lifestyle that " +
                        "ultimately leads to liberation.\n"+
                        "5. Deepak Puja (Candle) : The flame of deepak represents Pure Consciousness or a soul without any bondage (liberated soul). In Jainism, such a soul" +
                        " is called a Siddha or God. The ultimate goal of every living being is to become liberated from karma. By doing this puja one should strive to follow the" +
                        " Five Great Vows : Non violence, Truthfulness, Non stealing, Chastity and Non possession. Ultimately, these vows coupled with Right Faith and Knowledge will " +
                        "lead to liberation.\n"+
                        "6. Akshat Puja (Rice) : Since rice is a non-fertile grain, it cannot be grown by seeding it. Symbolically, it means that rice is the last birth. By doing this puja," +
                        " one should strive to put all their efforts in life as if this is their last life. And after the end of this life, one will be liberated and will not be reborn again.\n"+
                        "7. Naivedya Puja (Sweet) : Naivedya symbolizes a tasty food. By doing this puja, one should strive to reduce or eliminate attachment to tasty food. Healthy food is essential" +
                        " for survival, however one should not live to eat tasty food. The ultimate aim in one's life is to attain a life where no food is essential for our existence. That is the life of " +
                        "a liberated soul who lives in Moksha forever in ultimate bliss.\n"+
                    " 8. Fal Puja (Fruit) : Fruit symbolizes Moksha or Liberation. If we live our life without any attachment to worldly affair, continue to perform our duty without any expectation and" +
                         " reward, be a witness to all the incidents that occur surrounding us and within us, truly follow ascetic life, and have a love and compassion to all living beings, we will attain the fruit" +
                         " of Moksha or liberation. This is the last puja performed and symbolizes the ultimate achievement of our life."

                );

        // Set Doha's (replace these with actual dohas)
        dohaTextView.setText(
                "1. Jal Puja – Water Puja \n"+
                "Jal Se Shuddh Hoye Tan Mera, Man Ko Mile Vishaal,\n"+
                "Pap Nash Jaye Sab Mera, Mile Param Kripal.\n"+
                "2. Chandan Puja – Sandalwood Puja\n" +
                "Chandan Si Sheetalta Laave, Man Ko Kare Prakash,\n" +
                "Dosh Dukh Door Kare Sabhi, Satya Rahe Vikas.\n"+
                "3.Pushpa Puja – Flower Puja\n" +
                "Phool Sam Bhaav Banaye Raho, Komal Man Apnaaye,\n" +
                "Ahimsa Aur Prem Se, Sabko Gale Lagaye.\n"+
                "4.Dhup Puja – Incense Puja\n" +
                "Dhup Ki Sugandh Si Phailaao, Guno Ki Mehek Jagaye,\n" +
                "Dukh-Daridra Door Hoye, Satkarma Man Bhaaye.\n"+
                "5.Deep Puja – Lamp Puja\n" +
                "Deepak Sam Gyaan Prakaash Ho, Andhkaar Mite Sab Bhaari,\n" +
                "Vivek Udaye Jeevan Mein, Moksha Mile Sansaari.\n"+
                "6.Akshat Puja – Unbroken Rice Puja\n" +
                "Akshat Sa Ho Nishthaa Maanav, Kabhi Na Ho Bhrasht,\n" +
                "Sada Rahe Gunon Mein, Dharm Mein Rahe Vyasth.\n"+
                 "7.Naivedya Puja – Food Offering Puja\n" +
                 "Naivedya Arpan Karun Tujhe, Tyag Bhav Samaye,\n" +
                 "Vairagya Udaye Jeevan Mein, Ichha Sabhi Mitaaye.\n "+
                 "8.Fal Puja – Fruit Offering Puja\n" +
                 "Fal Arpan Karun Main Tujhko, Moksha Phal Paane Ko,\n" +
                 "Karm Kaat Do Hey Nath, Paavan Gati Jaane Ko.\n "

        );
    }
}
