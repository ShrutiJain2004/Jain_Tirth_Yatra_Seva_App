package com.example.application;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.*;

public class StateTempleListActivity extends AppCompatActivity {

    TextView stateNameTextView;
    EditText searchEditText;
    Button searchButton;
    Spinner citySpinner;
    ListView templeListView;

    String selectedState;
    Map<String, String[]> stateCitiesMap;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_temple_list);

        stateNameTextView = findViewById(R.id.stateNameTextView);
        searchEditText = findViewById(R.id.searchEditText);
        searchButton = findViewById(R.id.searchButton);
        citySpinner = findViewById(R.id.citySpinner);
        RecyclerView templeRecyclerView = findViewById(R.id.templeRecyclerView);


        // Get selected state
        selectedState = getIntent().getStringExtra("selectedState");

        if (selectedState == null) {
            Toast.makeText(this, "SelectedState is null!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Received state: " + selectedState, Toast.LENGTH_SHORT).show();
            stateNameTextView.setText(selectedState);
        }


        // Map of cities (you can add more later)
        stateCitiesMap = new HashMap<>();

        stateCitiesMap.put("Rajasthan", new String[]{"Ajmer", "Alwar", "Banswara", "Baran", "Barmer", "Bharatpur",
                "Bhilwara", "Bikaner", "Bundi", "Chittorgarh", "Churu", "Dausa", "Dholpur", "Dungarpur", "Hanumangarh",
                "Jaipur", "Jaisalmer","Jalore", "Jhalawar","Jhunjhunu", "Jodhpur","Karauli", "Kota","Nagaur", "Pali",
                "Pratapgarh", "Rajsamand", "Sawai Madhopur", "Sikar", "Sirohi", "Sri Ganganagar", "Tonk", "Udaipur"
        });

        stateCitiesMap.put("Gujarat", new String[]{"Ahmedabad", "Amreli", "Anand", "Aravalli", "Banaskantha", "Bharuch",
                "Bhavnagar", "Botad", "Chhota Udaipur", "Dahod", "Dang", "Devbhumi Dwarka", "Gandhinagar", "Gir Somnath",
                "Jamnagar", "Junagadh", "Kheda", "Kutch (Bhuj)", "Mahisagar", "Mehsana", "Morbi", "Narmada", "Navsari",
                "Panchmahal", "Patan", "Porbandar", "Rajkot", "Sabarkantha", "Surat", "Surendranagar", "Tapi", "Vadodara", "Valsad"
        });

        stateCitiesMap.put("Maharashtra", new String[]{"Ahmednagar", "Akola", "Amravati", "Aurangabad", "Beed", "Bhandara",
                "Buldhana", "Chandrapur", "Dhule", "Gadchiroli", "Gondia", "Hingoli", "Jalgaon", "Jalna", "Kolhapur",
                "Latur", "Mumbai", "Nagpur", "Nanded", "Nandurbar", "Nashik", "Osmanabad", "Palghar", "Parbhani", "Pune", "Raigad",
                "Ratnagiri", "Sangli", "Satara", "Sindhudurg", "Solapur", "Thane", "Wardha", "Washim", "Yavatmal"
        });

        // Populate city spinner
        String[] cities = stateCitiesMap.containsKey(selectedState) ?
                stateCitiesMap.get(selectedState) : new String[]{"City1", "City2"};

        // Create a new list and add "Select City" at the top
        List<String> cityList = new ArrayList<>();
        cityList.add("Select City");
        cityList.addAll(Arrays.asList(cities));

        ArrayAdapter<String> cityAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cityList);
        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySpinner.setAdapter(cityAdapter);

        // Handle city selection
        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCity = parent.getItemAtPosition(position).toString();
                // You will load temples of selectedCity here later
                if (!selectedCity.equals("Select City")) {
                    Toast.makeText(StateTempleListActivity.this, "Loading temples for: " + selectedCity, Toast.LENGTH_SHORT).show();
                    // Load temples logic here
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

        // Search button click (you’ll implement actual search later)
        searchButton.setOnClickListener(v -> {
            String query = searchEditText.getText().toString().trim();
            // Add logic to search within temple list later
            Toast.makeText(this, "Search for: " + query, Toast.LENGTH_SHORT).show();
        });


        templeRecyclerView.setLayoutManager(new LinearLayoutManager(this));

         List<Temple> templeList = new ArrayList<>();
        if ("Rajasthan".equals(selectedState)) {
            templeList.add(new Temple(
                    "Soniji Ki Nasiyan, Ajmer", "Ajmer", R.drawable.nasiyan_ajmer, "https://www.google.com/maps?q=Soniji+Ki+Nasiyan+Ajmer",
                    "Addresss : Dumada Adarsh Nagar,Ajmer, Rajasthan – 305002", "History :Soniji Ki Nasiyan is also popularly" +
                    " known as Ajmer Jain Temple. This beautiful temple situated in Ajmer city of Rajasthan is dedicated " +
                    "to the Jainism.  The whole temple has a main chamber which is installed with many figures made of gold " +
                    "dedicated to Jain deities.This chamber is known as the Swanrna Nagari or City of gold. This beautiful" +
                    " massive temple was established  in the 19th Century.",
                    "Contact : 123-456-7890 "
            ));

            templeList.add(new Temple(
                    "Lodurva Jain Temple,Jaisalmer", "Jaisalmer", R.drawable.lodurva_jaisalmer,
                    "https://www.google.com/maps?q=Lodurva+Jain+Temple+Jaisalmer",
                    "Address : Lodurva Jain Temple , Lodurva, Jaisalmer,Rajasthan 345001 ",
                    "History : Lodhurva Jain Temple is believed to have been built in the 10th century during the reign of the" +
                            " Parmar ruler, Bhati Rao, and it was dedicated to the Jain Tirthankara Parsvanatha. The temple showcases an" +
                            " exquisite blend of intricate carvings, detailed sculptures, and remarkable architecture typical of the medieval " +
                            "times. The temple's facade features finely sculpted figures of gods and goddesses, celestial nymphs, and intricate " +
                            "floral patterns, all carved with great skill and precision. The interior of the temple houses a beautifully adorned " +
                            "idol of Lord Parsvanatha, reflecting the artistic brilliance of the artisans of that era.Temple dedicated to 23rd " +
                            "Tirthankara, Parshvanath, with stunning yellow sandstone carvings and \"Kalpavriksha\" (Tree of Life) artwork. ",
                    "Contact : 987-654-3210"

            ));

            templeList.add(new Temple(
                    "Shri Kesariyaji Rishabdev Jain Temple, Udaipur", "Udaipur", R.drawable.rikhabdev_udaipur,
                    "https://www.google.com/maps?q=Rikhabdev+Temple+Udaipur",
                    "Addresss : Shri Rishabhdev Jain Temple (Kesariaji),Rishabhdev,District Udaipur,Rajasthan 313802",
                    "History : It is a well-known pilgrim site for the Jain temple Kesariyaji Tirth" +
                            "dedicated to the first Jaintirthankara Rishabhadeva (Adinath).\n + \n Local Bhils " +
                            "also worship the deity.\n" + "\n" + "Lord Rishabhadeo is also known as " +
                            "\"Kesariaji\" because a large offering of saffron(keshar, a common ingredient" +
                            " in Jain rituals) is made to the deity.",
                    "Contact : 456-789-1230 "

            ));

            templeList.add(new Temple(
                    "Dilwara Jain Temple , Mount Abu", "Abu", R.drawable.dilwara,
                    "https://www.google.com/maps?q= Dilwara+Jain+Temple+Abu",
                    "Address:  Delwara, Mount Abu, Rajasthan 30750",
                    "History: Constructed between the 11th and 13th centuries, the Dilwara Temples" +
                            "are renowned for their exquisite marble architecture and intricate carvings. " +
                            "The temples were designed by Vastupal Tejpal and constructed by Vimal Shah",
                    "Contact:  8500898000, 9393939150 "
            ));

        }
        else if ("Gujarat".equals(selectedState)) {
            templeList.add(new Temple(
                    "Hutheesing Jain Temple", "Ahmedabad", R.drawable.hutheesing_jain,
                    "https://www.google.com/maps?q=Hutheesing+Jain+Temple+Ahmedabad",
                    "Address: Bardolpura, Ahmedabad, Gujarat 380004",
                    "History: Built in 1848 by Hutheesing family in dedication to Lord Dharmanath...",
                    "Contact: 987-654-0001"
            ));

            templeList.add(new Temple("Shree Shatrunjaya Tirth, Palitana" , "Gujarat",
                    R.drawable.palitana,"https://www.google.com/maps?q=Shree+Shatrunjaya+Tirth+Palitana+Gujarat",
                    "Address : Palitana,Bhavnagar District Gujarat","History : Palitana, in Gujarat, is " +
                    "the holiest Jain pilgrimage site, located on the Shatrunjaya Hills. It houses over 900 marble temples," +
                    " with the main temple dedicated to Lord Rishabhdev. The site is sacred as many Tirthankars preached here." +
                    "Construction began in the 11th century, funded by Jain kings and merchants. Pilgrims climb 3,800+ steps barefoot" +
                    "to reach the summit, and no one is allowed to stay overnight on the hill. Visiting Palitana is believed to purify the " +
                    "soul and help attain moksha. ",
                    "Contact : +91 9920730014 , +91 7203027030 , +91 9099989191"
                    ));

            templeList.add(new Temple("Girnar Jain Tirth (Junagadh)","Gujarat",R.drawable.girnar,
                    "https://www.google.com/maps?q=Girnar+Jain+Junagadh+Gujarat","Address : Bhavnath ," +
                    "Girnar Hills , Junagadh , Gujarat , 362001 ",
                    "History : ","Contact :  "
            ));

            templeList.add(new Temple("Taranga Jain Tirth (Mehsana)","Gujarat",R.drawable.taranga,
                    "https://www.google.com/maps?q=Taranga+Jain+Tirth+Gujarat",
                    "Address : Taranga Village, Kheralu Taluka, Mehsana District, Gujarat ",
                    "History : This site is known for its exquisite Māru-Gurjara style architecture.\n" +
                            "The Ajitnatha temple, a major highlight, was constructed in the 12th century under the" +
                            " Solanki king Kumarapala.\n + Taranga's history also reveals a blend of Jain and Buddhist " +
                            "influences, with evidence of ancient Buddhist monuments.\n + It has both Shwetambar and Digambar " +
                            "Jain temples.",
                    "Contact : "
            ));

            templeList.add(new Temple("Mahudi","Gujarat",R.drawable.mahudi,
                    "https://www.google.com/maps?q=Mahudi+Jain+Tirth+Gujarat",
                    "Address :  Mahudi Village, Mansa Taluka, Gandhinagar District, Gujarat",
                    "History : Mahudi is particularly famous for the Ghantakarna Mahavir Temple.\n" +
                            "It holds significant religious importance, and the temple's history is intertwined " +
                            "with the legends surrounding Ghantakarna Mahavir.\n + The temple is known for the " +
                            "Sukhadi prasad that is offered there. ",
                    "Contact : "
            ));

            templeList.add(new Temple("Songadh Jain Temple","Gujarat",R.drawable.songadh,
                    "https://www.google.com/maps?q=Songadh+Jain+Tirth+Gujarat",
                    "Address :  Songadh Village, Vyara Taluka, Tapi District, Gujarat ",
                    "History : Songadh is a place that has gained more recent prominence, " +
                            "especially due to the influence of Shrimad Rajchandra.\n" +
                            "It is an important spiritual center for those who follow his teachings.\n" +
                            "While having ancient roots relating to jainism, it's modern history is very much" +
                            "tied to the teachings of Shrimad Rajchandra.",
                    "Contact : "
            ));

            templeList.add(new Temple("Kumbhariya Jain Tirth","Gujarat",R.drawable.kumbhariya,
                    "https://www.google.com/maps?q=Kumbhariya+Jain+Tirth+Gujarat",
                    "Address : Kumbhariya Village, Danta Taluka, Banaskantha District, Gujarat ",
                    "History : Kumbhariya is renowned for its cluster of beautifully carved Jain temples.\n" +
                            "These temples are excellent examples of the intricate artistry of their time.\n + The" +
                            " temples date back to the 11th through 13th centuries.\n + They are known for their " +
                            "architectural similarity to the dilwara temples of mount abu.\n",
                    "Contact : "
            ));
        } else if ("Bihar".equals(selectedState)) {
            templeList.add(new Temple("Sammed ShikharJi","Jharkhand",R.drawable.shikharji,
                    "https://www.google.com/maps?q=Sammed+ShikharJi+Tirth+Bihar",
                    "Address : Located on Parasnath Hills , Madhuban , Giridih , Jharkhand",
                    "History : Shikharji is considered the most sacred Jain Tirtha (pilgrimage site).\n" +
                            "It is believed to be the place where 20 of the 24 Jain Tirthankaras attained Moksha (liberation).\n" +
                            "Historical records indicate Jain presence in the area dating back to at least 1500 BCE.\n" +
                            "The site has been mentioned in ancient Jain texts.\n" + "Throughout history, various individuals and " +
                            "groups have contributed to the development and maintenance of the temples and facilities at Shikharji.\n" +
                            "The site has seen renovations and maintainance through the centuries, under the guidance of various groups, " +
                            "and individuals",
                    "Contact : 7004153053 , 7979751102 "
            ));

        } else if ("Delhi".equals(selectedState)) {
            templeList.add(new Temple("Dadabari Jain Shwetambar Mandir","Mehroli",R.drawable.mehroli,
                    "https://www.google.com/maps?q=Dadabari+Jain+Shwetambar+Mandir+Delhi",
                    "Address : Qutab Minar Metro Station, Devi Puriji Ashram Road, opp. Zafar Mahal Road, Aam Bagh, Ladha Sarai Village," +
                            " Mehrauli, New Delhi, Delhi 110030 ",
                    "History : This is the oldest Jain temple in Delhi, built in the 12th century.\n" +
                            "It is a revered Jain temple dedicated to the Jain saint Shri Jin Kushal Suri Ji, also known as Dadaguru.\n" +
                            "The Dadabari in Delhi is the place where Dādā Guru Jinachandra Sūri was cremated.\n" +
                            "The temple stands in an open courtyard surrounded by a corridor, which has numerous cells containing small idols of the Tirthankaras.\n" +
                            "The temple is built in white marble and has numerous pillars carved in exquisite detail.\n" +
                            "The interior ceilings feature glass and silver artwork, with designs of lotus buds, petals, flowers, and scenes from Jain mythology.\n" +
                            "Paintings depict Jain stories, including the marriage procession of Neminath. ",
                    "Contact : "
            ));
        } else if ("Maharashtra".equals(selectedState)) {
            templeList.add(new Temple("Antarikṣa Pārśvanātha Tīrtha",
                    "Akola",R.drawable.antariksa ,
                    "https://www.google.com/maps?q=Antarikṣa+Pārśvanātha+Tīrtha+Maharashtra",
                    "Address : Shirpur (Jain), Akola district, Maharashtra ",
                    "History : The temple is most known for its main deity, a black-colored idol of Parshvanatha, the 23rd Tirthankara, which is believed to be \"floating.\"\n" +
                            "It has been a center of devotion for Jains and has also been a site of historical disputes between the Śvetāmbara and Digambara sects of Jainism.\n" +
                            "Historical records indicate that in 1406 CE, Jagasimha donated land for the temple's construction.\n" +
                            "In 1649 CE, Śvetāmbara Jain ascetic Acharya Devsuri oversaw the installation of new idols.\n" +
                            "Renovations and reinstallations are also recorded in 1658 CE.It is one of the 108 most prominent idols of Pārśvanātha worshipped by Śvetāmbaras.\n" +
                            "There are multiple temples within the Tirth.\n" +
                            "There is a 1406 CE inscription present.",
                    "Contact : "
            ));
        } else if ("Chattisgarh".equals(selectedState)) {
            templeList.add(new Temple("Bawangaja Tirtha",
                    "Bawangaja, Chhattisgarh", R.drawable.bawangaja,
                    "https://www.google.com/maps?q=Bawangaja+Tirtha+Chhattisgarh",
                    "Address : Bawangaja, Chhattisgarh",
                    "History : The Bawangaja Tirtha is a famous Jain temple and pilgrimage site in Chhattisgarh. It is known for its large idol of Lord Rishabhanatha, the first Tirthankara. The temple is situated in a picturesque location surrounded by hills and forests.",
                    "Contact : "
            ));
        } else if ("Haryana".equals(selectedState)) {
            templeList.add(new Temple("Shree Sanatan Dharam Jain Temple",
                    "Ambala, Haryana", R.drawable.sanatan_dharam_jain,
                    "https://www.google.com/maps?q=Shree+Sanatan+Dharam+Jain+Temple+Ambala+Haryana",
                    "Address : Ambala, Haryana",
                    "History : The Shree Sanatan Dharam Jain Temple in Ambala is a significant Jain place of worship. The temple is known for its serene environment and beautiful architecture, dedicated to Lord Mahavira.",
                    "Contact : "
            ));
        } else if ("Jharkhand".equals(selectedState)) {
            templeList.add(new Temple("Parasnath Jain Temple",
                    "Parasnath Hill, Jharkhand", R.drawable.parasnath,
                    "https://www.google.com/maps?q=Parasnath+Jain+Temple+Parasnath+Hill+Jharkhand",
                    "Address : Parasnath Hill, Jharkhand",
                    "History : The Parasnath Jain Temple is located on the Parasnath Hill, which is one of the holiest places for Jains. It is dedicated to Lord Parshvanatha and is known for its stunning architecture and serene surroundings. The hill is also the site of several Jain temples.",
                    "Contact : "
            ));
        } else if ("Karnataka".equals(selectedState)) {
            templeList.add(new Temple("Shree Karkala Jain Temple",
                    "Karkala, Karnataka", R.drawable.karkala_jain,
                    "https://www.google.com/maps?q=Shree+Karkala+Jain+Temple+Karkala+Karnataka",
                    "Address : Karkala, Karnataka",
                    "History : The Shree Karkala Jain Temple is one of the prominent Jain temples in Karnataka. The temple is known for its massive statue of Lord Bahubali (Gomateshwara), which stands 42 feet tall and attracts pilgrims from all over India.",
                    "Contact : "
            ));
        } else if ("Kerala".equals(selectedState)) {
            templeList.add(new Temple("Parumala Jain Temple",
                    "Parumala, Kerala", R.drawable.parumala_jain,
                    "https://www.google.com/maps?q=Parumala+Jain+Temple+Parumala+Kerala",
                    "Address : Parumala, Kerala",
                    "History : Parumala Jain Temple is known for its historical significance in Kerala. The temple features beautiful architecture and is dedicated to Lord Mahavira. The serene ambiance of the temple offers a peaceful environment for meditation and prayers.",
                    "Contact : "
            ));
        } else if ("Punjab".equals(selectedState)) {
            templeList.add(new Temple("Gurudwara Nanakshahi Tirth",
                    "Amritsar, Punjab", R.drawable.gurudwara_nanakshahi,
                    "https://www.google.com/maps?q=Gurudwara+Nanakshahi+Tirth+Amritsar+Punjab",
                    "Address : Amritsar, Punjab",
                    "History : The Gurudwara Nanakshahi Tirth is an important Jain temple located in Amritsar. Known for its historical connections to the Sikh and Jain community, it attracts a large number of pilgrims every year.",
                    "Contact : "
            ));
        } else if ("Madhya Pradesh".equals(selectedState)) {
            templeList.add(new Temple("Kanch Mandir",
                    "Indore, Madhya Pradesh", R.drawable.kanch_mandir,
                    "https://www.google.com/maps?q=Kanch+Mandir+Indore+Madhya+Pradesh",
                    "Address : Indore, Madhya Pradesh",
                    "History : The Kanch Mandir in Indore is a famous Jain temple known for its beautiful glasswork. The temple is dedicated to Lord Mahavira and is considered one of the most significant Jain temples in Madhya Pradesh.",
                    "Contact : "
            ));
        } else if ("Uttar Pardesh".equals(selectedState)) {
            templeList.add(new Temple("Shree Digamber Jain Mandir",
                    "Varanasi, Uttar Pradesh", R.drawable.digamber_jain_mandir,
                    "https://www.google.com/maps?q=Shree+Digamber+Jain+Mandir+Varanasi+Uttar+Pradesh",
                    "Address : Varanasi, Uttar Pradesh",
                    "History : The Shree Digamber Jain Mandir in Varanasi is an important temple for the Digambara sect of Jainism. The temple is renowned for its detailed architecture and sacredness among the Jain community.",
                    "Contact : "
            ));
        } else if ("West Bengal".equals(selectedState)) {
            templeList.add(new Temple("Rishabhdev Jain Temple",
                    "Kolkata, West Bengal", R.drawable.rishabhdev_jain,
                    "https://www.google.com/maps?q=Rishabhdev+Jain+Temple+Kolkata+West+Bengal",
                    "Address : Kolkata, West Bengal",
                    "History : The Rishabhdev Jain Temple in Kolkata is dedicated to Lord Rishabhdev, the first Tirthankara. It is known for its vibrant rituals and the architectural beauty of its carvings and sculptures.",
                    "Contact : "
            ));
        } else if ("Tamil Nadu".equals(selectedState)) {
            templeList.add(new Temple("Shree Adinatha Jain Temple",
                    "Chennai, Tamil Nadu", R.drawable.adinatha_jain,
                    "https://www.google.com/maps?q=Shree+Adinatha+Jain+Temple+Chennai+Tamil+Nadu",
                    "Address : Chennai, Tamil Nadu",
                    "History : The Shree Adinatha Jain Temple is one of the famous Jain temples in Tamil Nadu. It is dedicated to Lord Adinatha, the first Tirthankara, and is known for its exquisite sculptures and peaceful atmosphere.",
                    "Contact : "
            ));
        }


        // Set adapter
            TempleAdapter adapter = new TempleAdapter(this, templeList);
            templeRecyclerView.setAdapter(adapter);

    }
}
