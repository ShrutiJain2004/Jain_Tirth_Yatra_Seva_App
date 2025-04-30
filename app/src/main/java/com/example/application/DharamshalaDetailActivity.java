package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.RatingBar;

import java.util.HashMap;
import java.util.Map;

public class DharamshalaDetailActivity extends AppCompatActivity {

    private TextView tvDetailHeading, tvAddress, tvPhone, tvEmail, tvAccommodation, tvFacilities, tvBookingPolicies, tvReviewCount;
    private RatingBar ratingBar;
    private Button btnBookNow;
    private String dharamshalaName;

    private static final Map<String, Map<String, Object>> dharamshalaDetails = new HashMap<>();

    static {
        // Example data for Shankeshwar
        Map<String, Object> shankeshwarDetails = new HashMap<>();
        shankeshwarDetails.put("address", "Near Shankeshwar Temple, Gujarat, India");
        shankeshwarDetails.put("phone", "+91 1234567890");
        shankeshwarDetails.put("email", "shankeshwar.info@example.com");
        shankeshwarDetails.put("accommodation", "Standard Rooms, Deluxe Rooms");
        shankeshwarDetails.put("facilities", "Dining Hall, Parking, Jain Food Available");
        shankeshwarDetails.put("booking", "Advance booking preferred. Contact for cancellation policy.");
        shankeshwarDetails.put("rating", 4.5f);
        shankeshwarDetails.put("reviews", 25);
        dharamshalaDetails.put("Shankeshwar Jain Agam Mandir Dharamshala", shankeshwarDetails);

        // Example data for Girnar Ji
        Map<String, Object> girnarDetails = new HashMap<>();
        girnarDetails.put("address", "Girnar Taleti, Junagadh, Gujarat, India");
        girnarDetails.put("phone", "+91 9876543210, +91 8765432109");
        girnarDetails.put("email", "girnar.trust@example.com");
        girnarDetails.put("accommodation", "Basic Rooms, Dormitories, Attached Bath (some)");
        girnarDetails.put("facilities", "Simple Meals, Prayer Hall");
        girnarDetails.put("booking", "On arrival basis. Limited availability during peak season.");
        girnarDetails.put("rating", 3.8f);
        dharamshalaDetails.put("Girnar Jain Trust Dharamshala", girnarDetails);

        // Example data for Taleti
        Map<String, Object> taletiDetails = new HashMap<>();
        taletiDetails.put("address", "Taleti, Palitana, Gujarat, India");
        taletiDetails.put("phone", "+91 7890123456");
        taletiDetails.put("email", "taleti.info@example.com");
        taletiDetails.put("accommodation", "Guest House Rooms, Economy Rooms");
        taletiDetails.put("facilities", "Common Dining Area, Basic Amenities");
        taletiDetails.put("booking", "Contact in advance for group bookings.");
        taletiDetails.put("rating", 4.0f);
        taletiDetails.put("reviews", 18);
        dharamshalaDetails.put("Taleti Jain Dharamshala", taletiDetails);

        // Example data for Songadh Jain Temple
        Map<String, Object> songadhDetails = new HashMap<>();
        songadhDetails.put("address", "Songadh, Gujarat, India");
        songadhDetails.put("phone", "+91 8901234567");
        songadhDetails.put("email", "songadh.trust@example.com");
        songadhDetails.put("accommodation", "Rooms with attached facilities");
        songadhDetails.put("facilities", "Dining Hall, Library");
        songadhDetails.put("booking", "Booking available on their website.");
        songadhDetails.put("rating", 4.7f);
        songadhDetails.put("reviews", 32);
        dharamshalaDetails.put("Songadh Jain Temple Dharamshala", songadhDetails);

        // Example data for Mahudi
        Map<String, Object> mahudiDetails = new HashMap<>();
        mahudiDetails.put("address", "Mahudi, Gujarat, India");
        mahudiDetails.put("phone", "+91 9012345678");
        mahudiDetails.put("email", "mahudi.info@example.com");
        mahudiDetails.put("accommodation", "Standard Rooms, Family Suites");
        mahudiDetails.put("facilities", "Jain Bhojanalaya, Parking");
        mahudiDetails.put("booking", "Bookings accepted via phone.");
        mahudiDetails.put("rating", 4.2f);
        mahudiDetails.put("reviews", 21);
        dharamshalaDetails.put("Mahudi Jain Dharamshala", mahudiDetails);

        // Example data for Mehsana
        Map<String, Object> mehsanaDetails = new HashMap<>();
        mehsanaDetails.put("address", "Mehsana, Gujarat, India");
        mehsanaDetails.put("phone", "+91 6789012345");
        mehsanaDetails.put("email", "mehsana.bhavan@example.com");
        mehsanaDetails.put("accommodation", "AC and Non-AC Rooms");
        mehsanaDetails.put("facilities", "Guest Kitchen, Common Hall");
        mehsanaDetails.put("booking", "Walk-ins welcome, advance booking for groups.");
        mehsanaDetails.put("rating", 3.9f);
        mehsanaDetails.put("reviews", 15);
        dharamshalaDetails.put("Mehsana Jain Atithi Bhavan", mehsanaDetails);

        // Example data for Nakoda Parshwanath
        Map<String, Object> nakodaDetails = new HashMap<>();
        nakodaDetails.put("address", "Nakoda, Rajasthan, India");
        nakodaDetails.put("phone", "+91 9123456780");
        nakodaDetails.put("email", "nakoda.trust@example.com");
        nakodaDetails.put("accommodation", "Rooms and Guest Houses Available");
        nakodaDetails.put("facilities", "Common Kitchen, Prayer Hall");
        nakodaDetails.put("booking", "Contact temple trust for booking.");
        nakodaDetails.put("rating", 4.6f);
        nakodaDetails.put("reviews", 28);
        dharamshalaDetails.put("Nakoda Jain Dharamshala", nakodaDetails);

        // Example data for Ranakpur
        Map<String, Object> ranakpurDetails = new HashMap<>();
        ranakpurDetails.put("address", "Ranakpur, Rajasthan, India");
        ranakpurDetails.put("phone", "+91 8234567890");
        ranakpurDetails.put("email", "ranakpur.info@example.com");
        ranakpurDetails.put("accommodation", "Standard and Deluxe Rooms");
        ranakpurDetails.put("facilities", "Dining Facility, Parking");
        ranakpurDetails.put("booking", "Online booking available.");
        ranakpurDetails.put("rating", 4.8f);
        ranakpurDetails.put("reviews", 35);
        dharamshalaDetails.put("Ranakpur Jain Dharamshala", ranakpurDetails);

        // Example data for Khajuri
        Map<String, Object> khajuriDetails = new HashMap<>();
        khajuriDetails.put("address", "Khajuri, Madhya Pradesh, India");
        khajuriDetails.put("phone", "+91 7345678901");
        khajuriDetails.put("email", "khajuri.stay@example.com");
        khajuriDetails.put("accommodation", "Simple Guest Rooms");
        khajuriDetails.put("facilities", "Basic Amenities");
        khajuriDetails.put("booking", "On arrival.");
        khajuriDetails.put("rating", 3.5f);
        khajuriDetails.put("reviews", 10);
        dharamshalaDetails.put("Khajuri Jain Dharamshala", khajuriDetails);

        // Example data for Jirawala
        Map<String, Object> jirawalaDetails = new HashMap<>();
        jirawalaDetails.put("address", "Jirawala, Rajasthan, India");
        jirawalaDetails.put("phone", "+91 6456789012");
        jirawalaDetails.put("email", "jirawala.stay@example.com");
        jirawalaDetails.put("accommodation", "Rooms with attached bath");
        jirawalaDetails.put("facilities", "Dining hall");
        jirawalaDetails.put("booking", "Contact trust office.");
        jirawalaDetails.put("rating", 4.3f);
        jirawalaDetails.put("reviews", 22);
        dharamshalaDetails.put("Jirawala Jain Dharamshala", jirawalaDetails);

        // Example data for Kumbhalgarh
        Map<String, Object> kumbhalgarhDetails = new HashMap<>();
        kumbhalgarhDetails.put("address", "Kumbhalgarh, Rajasthan, India");
        kumbhalgarhDetails.put("phone", "+91 5567890123");
        kumbhalgarhDetails.put("email", "kumbhalgarh.stay@example.com");
        kumbhalgarhDetails.put("accommodation", "Guest rooms");
        kumbhalgarhDetails.put("facilities", "Basic facilities available");
        kumbhalgarhDetails.put("booking", "Limited rooms, contact in advance.");
        kumbhalgarhDetails.put("rating", 3.9f);
        kumbhalgarhDetails.put("reviews", 16);
        dharamshalaDetails.put("Kumbhalgarh Jain Dharamshala", kumbhalgarhDetails);

        // Example data for Shree Keshariya Ji Jain Temple
        Map<String, Object> kesariyaDetails = new HashMap<>();
        kesariyaDetails.put("address", "Shree Keshariya Ji, Rajasthan, India");
        kesariyaDetails.put("phone", "+91 4678901234");
        kesariyaDetails.put("email", "kesariyaji.stay@example.com");
        kesariyaDetails.put("accommodation", "Dharamshala rooms");
        kesariyaDetails.put("facilities", "Common dining");
        kesariyaDetails.put("booking", "Booking through temple committee.");
        kesariyaDetails.put("rating", 4.5f);
        kesariyaDetails.put("reviews", 27);
        dharamshalaDetails.put("Shree Keshariya Ji Jain Temple Dharamshala", kesariyaDetails);

        // Example data for Mangi Tungi
        Map<String, Object> mangiTungiDetails = new HashMap<>();
        mangiTungiDetails.put("address", "Mangi Tungi, Maharashtra, India");
        mangiTungiDetails.put("phone", "+91 3789012345");
        mangiTungiDetails.put("email", "mangitungi.stay@example.com");
        mangiTungiDetails.put("accommodation", "Various guest houses");
        mangiTungiDetails.put("facilities", "Basic amenities, Jain food available");
        mangiTungiDetails.put("booking", "Contact local dharamshalas.");
        mangiTungiDetails.put("rating", 4.4f);
        mangiTungiDetails.put("reviews", 24);
        dharamshalaDetails.put("Mangi Tungi Jain Dharamshala", mangiTungiDetails);

        // Example data for Kunthalgiri
        Map<String, Object> kunthalgiriDetails = new HashMap<>();
        kunthalgiriDetails.put("address", "Kunthalgiri, Maharashtra, India");
        kunthalgiriDetails.put("phone", "+91 2890123456");
        kunthalgiriDetails.put("email", "kunthalgiri.info@example.com");
        kunthalgiriDetails.put("accommodation", "Dharamshala accommodations");
        kunthalgiriDetails.put("facilities", "Simple facilities");
        kunthalgiriDetails.put("booking", "Usually on arrival basis.");
        kunthalgiriDetails.put("rating", 3.7f);
        kunthalgiriDetails.put("reviews", 11);
        dharamshalaDetails.put("Kunthalgiri Jain Dharamshala", kunthalgiriDetails);

        // Example data for Toranmal
        Map<String, Object> toranmalDetails = new HashMap<>();
        toranmalDetails.put("address", "Toranmal, Maharashtra, India");
        toranmalDetails.put("phone", "+91 1901234567");
        toranmalDetails.put("email", "toranmal.stay@example.com");
        toranmalDetails.put("accommodation", "Limited guest house options");
        toranmalDetails.put("facilities", "Basic lodging");
        toranmalDetails.put("booking", "Contact local caretakers.");
        toranmalDetails.put("rating", 3.2f);
        toranmalDetails.put("reviews", 8);
        dharamshalaDetails.put("Toranmal Jain Dharamshala", toranmalDetails);

        // Example data for Gajpanth
        Map<String, Object> gajpanthDetails = new HashMap<>();
        gajpanthDetails.put("address", "Gajpanth, Maharashtra, India");
        gajpanthDetails.put("phone", "+91 9213456780");
        gajpanthDetails.put("email", "gajpanth.info@example.com");
        gajpanthDetails.put("accommodation", "Dharamshala rooms");
        gajpanthDetails.put("facilities", "Basic amenities");
        gajpanthDetails.put("booking", "Contact temple committee.");
        gajpanthDetails.put("rating", 4.1f);
        gajpanthDetails.put("reviews", 19);
        dharamshalaDetails.put("Gajpanth Jain Dharamshala", gajpanthDetails);

        // Example data for Rishabhdev
        Map<String, Object> rishabhdevDetails = new HashMap<>();
        rishabhdevDetails.put("address", "Rishabhdev, Rajasthan, India");
        rishabhdevDetails.put("phone", "+91 8324567890");
        rishabhdevDetails.put("email", "rishabhdev.stay@example.com");
        rishabhdevDetails.put("accommodation", "Various dharamshalas");
        rishabhdevDetails.put("facilities", "Jain food, basic amenities");
        rishabhdevDetails.put("booking", "Contact individual dharamshalas.");
        rishabhdevDetails.put("rating", 4.5f);
        rishabhdevDetails.put("reviews", 26);
        dharamshalaDetails.put("Rishabhdev Jain Dharamshala", rishabhdevDetails);

        // Example data for Sonagiri Jain Temples
        Map<String, Object> sonagiriDetails = new HashMap<>();
        sonagiriDetails.put("address", "Sonagiri, Madhya Pradesh, India");
        sonagiriDetails.put("phone", "+91 7435678901");
        sonagiriDetails.put("email", "sonagiri.info@example.com");
        sonagiriDetails.put("accommodation", "Guest houses available");
        sonagiriDetails.put("facilities", "Basic facilities");
        sonagiriDetails.put("booking", "On arrival or contact trust.");
        sonagiriDetails.put("rating", 4.0f);
        sonagiriDetails.put("reviews", 17);
        dharamshalaDetails.put("Sonagiri Jain Temples Dharamshala", sonagiriDetails);

        // Example data for Kundalpur Jain Temple
        Map<String, Object> kundalpurDetails = new HashMap<>();
        kundalpurDetails.put("address", "Kundalpur, Madhya Pradesh, India");
        kundalpurDetails.put("phone", "+91 6546789012");
        kundalpurDetails.put("email", "kundalpur.stay@example.com");
        kundalpurDetails.put("accommodation", "Dharamshala rooms");
        kundalpurDetails.put("facilities", "Simple amenities");
        kundalpurDetails.put("booking", "Contact temple management.");
        kundalpurDetails.put("rating", 4.2f);
        kundalpurDetails.put("reviews", 21);
        dharamshalaDetails.put("Kundalpur Jain Temple Dharamshala", kundalpurDetails);

        // Example data for Chanderi Jain Temple
        Map<String, Object> chanderiDetails = new HashMap<>();
        chanderiDetails.put("address", "Chanderi, Madhya Pradesh, India");
        chanderiDetails.put("phone", "+91 5657890123");
        chanderiDetails.put("email", "chanderi.info@example.com");
        chanderiDetails.put("accommodation", "Guest house facilities");
        chanderiDetails.put("facilities", "Basic lodging");
        chanderiDetails.put("booking", "Contact local contacts.");
        chanderiDetails.put("rating", 3.8f);
        chanderiDetails.put("reviews", 13);
        dharamshalaDetails.put("Chanderi Jain Temple Dharamshala", chanderiDetails);

        // Example data for Datia Jain Temples
        Map<String, Object> datiaDetails = new HashMap<>();
        datiaDetails.put("address", "Datia, Madhya Pradesh, India");
        datiaDetails.put("phone", "+91 4768901234");
        datiaDetails.put("email", "datia.stay@example.com");
        datiaDetails.put("accommodation", "Dharamshala rooms");
        datiaDetails.put("facilities", "Simple amenities");
        datiaDetails.put("booking", "Contact temple trust.");
        datiaDetails.put("rating", 3.9f);
        datiaDetails.put("reviews", 15);
        dharamshalaDetails.put("Datia Jain Temples Dharamshala", datiaDetails);

        // Example data for Pawagiri
        Map<String, Object> pawagiriDetails = new HashMap<>();
        pawagiriDetails.put("address", "Pawagiri, Madhya Pradesh, India");
        pawagiriDetails.put("phone", "+91 3879012345");
        pawagiriDetails.put("email", "pawagiri.info@example.com");
        pawagiriDetails.put("accommodation", "Guest houses");
        pawagiriDetails.put("facilities", "Basic facilities, Jain food");
        pawagiriDetails.put("booking", "Contact local dharamshalas.");
        pawagiriDetails.put("rating", 4.3f);
        pawagiriDetails.put("reviews", 22);
        dharamshalaDetails.put("Pawagiri Jain Dharamshala", pawagiriDetails);

        // Example data for Bawangaja
        Map<String, Object> bawangajaDetails = new HashMap<>();
        bawangajaDetails.put("address", "Bawangaja, Madhya Pradesh, India");
        bawangajaDetails.put("phone", "+91 2980123456");
        bawangajaDetails.put("email", "bawangaja.stay@example.com");
        bawangajaDetails.put("accommodation", "Dharamshala accommodations");
        bawangajaDetails.put("facilities", "Simple lodging");
        bawangajaDetails.put("booking", "On arrival or contact caretakers.");
        bawangajaDetails.put("rating", 4.1f);
        bawangajaDetails.put("reviews", 18);
        dharamshalaDetails.put("Bawangaja Jain Dharamshala", bawangajaDetails);

        // Example data for Hastinapur
        Map<String, Object> hastinapurDetails = new HashMap<>();
        hastinapurDetails.put("address", "Hastinapur, Uttar Pradesh, India");
        hastinapurDetails.put("phone", "+91 1091234567");
        hastinapurDetails.put("email", "hastinapur.stay@example.com");
        hastinapurDetails.put("accommodation", "Various dharamshalas and guest houses");
        hastinapurDetails.put("facilities", "Jain food options, basic amenities");
        hastinapurDetails.put("booking", "Contact individual dharamshalas.");
        hastinapurDetails.put("rating", 4.2f);
        hastinapurDetails.put("reviews", 20);
        dharamshalaDetails.put("Hastinapur Jain Dharamshala", hastinapurDetails);

        // Example data for Deogarh
        Map<String, Object> deogarhDetails = new HashMap<>();
        deogarhDetails.put("address", "Deogarh, Uttar Pradesh, India");
        deogarhDetails.put("phone", "+91 2101234567");
        deogarhDetails.put("email", "deogarh.info@example.com");
        deogarhDetails.put("accommodation", "Limited guest house facilities");
        deogarhDetails.put("facilities", "Simple lodging");
        deogarhDetails.put("booking", "Contact local caretakers.");
        deogarhDetails.put("rating", 3.6f);
        deogarhDetails.put("reviews", 12);
        dharamshalaDetails.put("Deogarh Jain Dharamshala", deogarhDetails);

        // Example data for Parashnath Digambar Jain Temple
        Map<String, Object> parashnathDetails = new HashMap<>();
        parashnathDetails.put("address", "Parashnath, Jharkhand, India");
        parashnathDetails.put("phone", "+91 3101234567");
        parashnathDetails.put("email", "parashnath.stay@example.com");
        parashnathDetails.put("accommodation", "Dharamshalas near the temple");
        parashnathDetails.put("facilities", "Basic amenities, Jain food available");
        parashnathDetails.put("booking", "Contact local dharamshalas.");
        parashnathDetails.put("rating", 4.4f);
        parashnathDetails.put("reviews", 25);
        dharamshalaDetails.put("Parashnath Digambar Jain Temple Dharamshala", parashnathDetails);

        // Example data for Jambudweep Jain Temple
        Map<String, Object> jambudweepDetails = new HashMap<>();
        jambudweepDetails.put("address", "Jambudweep, Uttar Pradesh, India");
        jambudweepDetails.put("phone", "+91 4101234567");
        jambudweepDetails.put("email", "jambudweep.info@example.com");
        jambudweepDetails.put("accommodation", "Guest house within the complex");
        jambudweepDetails.put("facilities", "Modern amenities, dining hall");
        jambudweepDetails.put("booking", "Booking through temple administration.");
        jambudweepDetails.put("rating", 4.7f);
        jambudweepDetails.put("reviews", 30);
        dharamshalaDetails.put("Jambudweep Jain Temple Dharamshala", jambudweepDetails);

        // Example data for Lalitpur Jain Temples
        Map<String, Object> lalitpurDetails = new HashMap<>();
        lalitpurDetails.put("address", "Lalitpur, Uttar Pradesh, India");
        lalitpurDetails.put("phone", "+91 5101234567");
        lalitpurDetails.put("email", "lalitpur.stay@example.com");
        lalitpurDetails.put("accommodation", "Guest houses near the temples");
        lalitpurDetails.put("facilities", "Basic facilities available");
        lalitpurDetails.put("booking", "Contact local guest houses.");
        lalitpurDetails.put("rating", 3.9f);
        lalitpurDetails.put("reviews", 16);
        dharamshalaDetails.put("Lalitpur Jain Temples Dharamshala", lalitpurDetails);

        // Example data for Parichha Jain Temple
        Map<String, Object> parichhaDetails = new HashMap<>();
        parichhaDetails.put("address", "Parichha, Uttar Pradesh, India");
        parichhaDetails.put("phone", "+91 6101234567");
        parichhaDetails.put("email", "parichha.info@example.com");
        parichhaDetails.put("accommodation", "Dharamshala facilities");
        parichhaDetails.put("facilities", "Simple amenities");
        parichhaDetails.put("booking", "Contact temple committee.");
        parichhaDetails.put("rating", 4.0f);
        parichhaDetails.put("reviews", 18);
        dharamshalaDetails.put("Parichha Jain Temple Dharamshala", parichhaDetails);

        // Example data for Soniji Ki Nasiyan Dharamshala
        Map<String, Object> sonijiNasiyanDetails = new HashMap<>();
        sonijiNasiyanDetails.put("address", "Prithviraj Marg, Ajmer, Rajasthan, India");
        sonijiNasiyanDetails.put("phone", "+91 145 2423007");
        sonijiNasiyanDetails.put("email", "soniji.nasiyan@example.com");
        sonijiNasiyanDetails.put("accommodation", "Guest house within the complex");
        sonijiNasiyanDetails.put("facilities", "Rooms with attached bath, Jain Bhojanalaya");
        sonijiNasiyanDetails.put("booking", "On arrival or contact temple trust.");
        sonijiNasiyanDetails.put("rating", 4.7f);
        sonijiNasiyanDetails.put("reviews", 42);
        dharamshalaDetails.put("Digamber Jain Atishay Kshetra Soniji Ki Nasiyan", sonijiNasiyanDetails);

        // Lodurva Jain Temple, Jaisalmer
        Map<String, Object> lodurvaDetails = new HashMap<>();
        lodurvaDetails.put("address", "Lodurva, Near Jaisalmer, Rajasthan, India");
        lodurvaDetails.put("phone", "+91 9876543211");
        lodurvaDetails.put("email", "lodurva.stay@example.com");
        lodurvaDetails.put("accommodation", "Nearby Jain Dharamshalas in Jaisalmer");
        lodurvaDetails.put("facilities", "Basic amenities, Jain food options in Jaisalmer");
        lodurvaDetails.put("booking", "Contact Dharamshalas in Jaisalmer.");
        lodurvaDetails.put("rating", 4.1f);
        lodurvaDetails.put("reviews", 28);
        dharamshalaDetails.put("Jain Dharamshala Jaisalmer", lodurvaDetails);

        // Shri Kesariyaji Rishabdev Jain Temple, Udaipur
        Map<String, Object> udaipurKesariyajiDetails = new HashMap<>();
        udaipurKesariyajiDetails.put("address", "Near Rishabhdev, Udaipur Region, Rajasthan, India");
        udaipurKesariyajiDetails.put("phone", "+91 8765432112");
        udaipurKesariyajiDetails.put("email", "udaipurkesariyaji.stay@example.com");
        udaipurKesariyajiDetails.put("accommodation", "Dharamshalas in Rishabhdev near Udaipur");
        udaipurKesariyajiDetails.put("facilities", "Good facilities, Jain Bhojanalaya");
        udaipurKesariyajiDetails.put("booking", "Contact local Dharamshalas.");
        udaipurKesariyajiDetails.put("rating", 4.5f);
        udaipurKesariyajiDetails.put("reviews", 35);
        dharamshalaDetails.put("Gaj Mandir Kesariaji", udaipurKesariyajiDetails);

        // Dilwara Jain Temple , Mount Abu
        Map<String, Object> mountAbuDetails = new HashMap<>();
        mountAbuDetails.put("address", "Mount Abu, Rajasthan, India");
        mountAbuDetails.put("phone", "+91 7654321113");
        mountAbuDetails.put("email", "mountabu.stay@example.com");
        mountAbuDetails.put("accommodation", "Various Dharamshalas in Mount Abu");
        mountAbuDetails.put("facilities", "Range of facilities, Jain food available");
        mountAbuDetails.put("booking", "Contact Dharamshalas in Mount Abu.");
        mountAbuDetails.put("rating", 4.3f);
        mountAbuDetails.put("reviews", 40);
        dharamshalaDetails.put("Adinath Digambar Jain Mandir and Jain Dharmshala Mount Abu", mountAbuDetails);

        // Hutheesing Jain Temple , Ahemdabad
        Map<String, Object> ahmedabadDetails = new HashMap<>();
        ahmedabadDetails.put("address", "Ahmedabad, Gujarat, India");
        ahmedabadDetails.put("phone", "+91 6543211114");
        ahmedabadDetails.put("email", "ahmedabad.stay@example.com");
        ahmedabadDetails.put("accommodation", "Dharamshalas and guest houses in Ahmedabad");
        ahmedabadDetails.put("facilities", "Standard amenities, Jain food options");
        ahmedabadDetails.put("booking", "Contact local Dharamshalas.");
        ahmedabadDetails.put("rating", 4.2f);
        ahmedabadDetails.put("reviews", 32);
        dharamshalaDetails.put("Marchipole Jain Dharmshala", ahmedabadDetails);

        // Shree Shatrunjaya Tirth, Palitana
        Map<String, Object> palitanaDetails = new HashMap<>();
        palitanaDetails.put("address", "Palitana, Gujarat, India");
        palitanaDetails.put("phone", "+91 5432111115");
        palitanaDetails.put("email", "palitana.stay@example.com");
        palitanaDetails.put("accommodation", "Numerous Dharamshalas in Palitana");
        palitanaDetails.put("facilities", "Wide range of facilities, Jain food readily available");
        palitanaDetails.put("booking", "Contact individual Dharamshalas.");
        palitanaDetails.put("rating", 4.6f);
        palitanaDetails.put("reviews", 55);
        dharamshalaDetails.put("Mewad Bhavan ( Palitana )", palitanaDetails);

        // Taranga Jain Tirth (Mehsana)
        Map<String, Object> tarangaDetails = new HashMap<>();
        tarangaDetails.put("address", "Taranga, Near Mehsana, Gujarat, India");
        tarangaDetails.put("phone", "+91 4321111116");
        tarangaDetails.put("email", "taranga.stay@example.com");
        tarangaDetails.put("accommodation", "Dharamshalas near Taranga Hill");
        tarangaDetails.put("facilities", "Basic amenities, Jain food options");
        tarangaDetails.put("booking", "Contact local Dharamshalas.");
        tarangaDetails.put("rating", 4.0f);
        tarangaDetails.put("reviews", 25);
        dharamshalaDetails.put("Taranga Jain Tirth Dharamshala", tarangaDetails);

        // Kumbhariya Jain Tirth
        Map<String, Object> kumbhariyaDetails = new HashMap<>();
        kumbhariyaDetails.put("address", "Kumbhariya, Gujarat, India");
        kumbhariyaDetails.put("phone", "+91 3211111117");
        kumbhariyaDetails.put("email", "kumbhariya.stay@example.com");
        kumbhariyaDetails.put("accommodation", "Dharamshalas in Kumbhariya village");
        kumbhariyaDetails.put("facilities", "Simple facilities, Jain food");
        kumbhariyaDetails.put("booking", "Contact local Dharamshalas.");
        kumbhariyaDetails.put("rating", 4.4f);
        kumbhariyaDetails.put("reviews", 38);
        dharamshalaDetails.put("Kumbhariya Jain Tirth Dharamshala", kumbhariyaDetails);

        // Sammed ShikharJi
        Map<String, Object> sammedShikharjiDetails = new HashMap<>();
        sammedShikharjiDetails.put("address", "Madhuban, Jharkhand, India");
        sammedShikharjiDetails.put("phone", "+91 2111111118");
        sammedShikharjiDetails.put("email", "sammedshikharji.stay@example.com");
        sammedShikharjiDetails.put("accommodation", "Numerous Dharamshalas at the base");
        sammedShikharjiDetails.put("facilities", "Varied facilities, Jain food available");
        sammedShikharjiDetails.put("booking", "Contact individual Dharamshalas.");
        sammedShikharjiDetails.put("rating", 4.7f);
        sammedShikharjiDetails.put("reviews", 60);
        dharamshalaDetails.put("Shikharji Dharamshala (Rajendra Dham)", sammedShikharjiDetails);

        // Dadabari Jain Shwetambar Mandir ,Mehroli
        Map<String, Object> mehroliDetails = new HashMap<>();
        mehroliDetails.put("address", "Mehrauli, New Delhi, India");
        mehroliDetails.put("phone", "+91 1122222222");
        mehroliDetails.put("email", "mehroli.stay@example.com");
        mehroliDetails.put("accommodation", "Nearby guest houses and Dharamshalas");
        mehroliDetails.put("facilities", "Basic amenities, local food options");
        mehroliDetails.put("booking", "Check local guest houses.");
        mehroliDetails.put("rating", 4.1f);
        mehroliDetails.put("reviews", 29);
        dharamshalaDetails.put("Jain Mandir Chhoti Dadabwadi", mehroliDetails);

        // Antarikṣa Pārśvanātha Tīrtha , Maharashtra
        Map<String, Object> antarikshParshwanathDetails = new HashMap<>();
        antarikshParshwanathDetails.put("address", "Shirpur Jain, Maharashtra, India");
        antarikshParshwanathDetails.put("phone", "+91 9999888877");
        antarikshParshwanathDetails.put("email", "antariksh.stay@example.com");
        antarikshParshwanathDetails.put("accommodation", "Dharamshalas in Shirpur Jain");
        antarikshParshwanathDetails.put("facilities", "Simple rooms, Jain food");
        antarikshParshwanathDetails.put("booking", "Contact local Dharamshalas.");
        antarikshParshwanathDetails.put("rating", 4.3f);
        antarikshParshwanathDetails.put("reviews", 33);
        dharamshalaDetails.put("Shree Antariksh Parshwanath Shwetambar Jain Dharamshala", antarikshParshwanathDetails);

        // Shree Sambhavnath Jain Derasar, Bangkok (Accommodation Details)
        Map<String, Object> bangkokSambhavnathDharamshala = new HashMap<>();
        bangkokSambhavnathDharamshala.put("address", "Near Shree Sambhavnath Jain Derasar, Bangkok, Thailand");
        bangkokSambhavnathDharamshala.put("phone", "+66 XX XXX XXXX"); // Example Thai number
        bangkokSambhavnathDharamshala.put("email", "sambhavnath.stay@example.com");
        bangkokSambhavnathDharamshala.put("accommodation", "Guest houses and Dharamshalas nearby");
        bangkokSambhavnathDharamshala.put("facilities", "Basic amenities, possibly Jain food");
        bangkokSambhavnathDharamshala.put("booking", "Contact local accommodations.");
        bangkokSambhavnathDharamshala.put("rating", 3.8f);
        bangkokSambhavnathDharamshala.put("reviews", 15);
        dharamshalaDetails.put("Bangkok Jain Temple Dharamshala", bangkokSambhavnathDharamshala);

        // Shri 1008 Mahavir Digamber Jain Mandir, Bangkok
        Map<String, Object> bangkokMahavirDharamshala = new HashMap<>();
        bangkokMahavirDharamshala.put("address", "Near Shri 1008 Mahavir Digamber Jain Mandir, Bangkok, Thailand");
        bangkokMahavirDharamshala.put("phone", "+66 YY YYY YYYY");
        bangkokMahavirDharamshala.put("email", "mahavir.stay@example.com");
        bangkokMahavirDharamshala.put("accommodation", "Guest houses in the vicinity");
        bangkokMahavirDharamshala.put("facilities", "Standard amenities");
        bangkokMahavirDharamshala.put("booking", "Check local guest houses.");
        bangkokMahavirDharamshala.put("rating", 3.5f);
        bangkokMahavirDharamshala.put("reviews", 10);
        dharamshalaDetails.put("Bangkok Jain Temple Dharamshala", bangkokMahavirDharamshala);

        // Sankeshwar Parshwanath Jain Jinalay, Bangkok (Accommodation Details)
        Map<String, Object> bangkokSankeshwarDharamshala = new HashMap<>();
        bangkokSankeshwarDharamshala.put("address", "Near Sankeshwar Parshwanath Jain Jinalay, Bangkok, Thailand");
        bangkokSankeshwarDharamshala.put("phone", "+66 ZZ ZZZ ZZZZ");
        bangkokSankeshwarDharamshala.put("email", "shankeshwar.stay@example.com");
        bangkokSankeshwarDharamshala.put("accommodation", "Dharamshalas or guest houses nearby");
        bangkokSankeshwarDharamshala.put("facilities", "Basic facilities");
        bangkokSankeshwarDharamshala.put("booking", "Enquire locally.");
        bangkokSankeshwarDharamshala.put("rating", 3.9f);
        bangkokSankeshwarDharamshala.put("reviews", 18);
        dharamshalaDetails.put("Bangkok Jain Temple Dharamshala", bangkokSankeshwarDharamshala);

        // Jain Mandir Lahore, Pakistan (Accommodation Details)
        Map<String, Object> lahoreDharamshala = new HashMap<>();
        lahoreDharamshala.put("address", "Near Jain Mandir, Lahore, Pakistan");
        lahoreDharamshala.put("phone", "+92 XX XXXXXXXX");
        lahoreDharamshala.put("email", "lahorejain.stay@example.com");
        lahoreDharamshala.put("accommodation", "Guest houses or basic lodging nearby");
        lahoreDharamshala.put("facilities", "Likely basic amenities");
        lahoreDharamshala.put("booking", "Enquire locally.");
        lahoreDharamshala.put("rating", 3.0f);
        lahoreDharamshala.put("reviews", 5);
        dharamshalaDetails.put("Lahore Jain Temple Dharamshala", lahoreDharamshala);

        // Jain Mandir Rawalpindi, Pakistan
        Map<String, Object> rawalpindiDharamshala = new HashMap<>();
        rawalpindiDharamshala.put("address", "Near Jain Mandir, Rawalpindi, Pakistan");
        rawalpindiDharamshala.put("phone", "+92 YY YYYYYYYY");
        rawalpindiDharamshala.put("email", "rawalpindijain.stay@example.com");
        rawalpindiDharamshala.put("accommodation", "Guest houses in Rawalpindi");
        rawalpindiDharamshala.put("facilities", "Standard guest house facilities");
        rawalpindiDharamshala.put("booking", "Check local guest houses.");
        rawalpindiDharamshala.put("rating", 3.2f);
        rawalpindiDharamshala.put("reviews", 8);
        dharamshalaDetails.put("Rawalpindi Jain Temple Dharamshala", rawalpindiDharamshala);

        // Shri Vishwanath Jain Shwetambar Mandir, Multan, Pakistan
        Map<String, Object> multanDharamshala = new HashMap<>();
        multanDharamshala.put("address", "Near Shri Vishwanath Jain Mandir, Multan, Pakistan");
        multanDharamshala.put("phone", "+92 ZZ ZZZZZZZZ");
        multanDharamshala.put("email", "multanjain.stay@example.com");
        multanDharamshala.put("accommodation", "Basic lodging or guest houses in Multan");
        multanDharamshala.put("facilities", "Likely basic amenities");
        multanDharamshala.put("booking", "Enquire locally.");
        multanDharamshala.put("rating", 3.1f);
        multanDharamshala.put("reviews", 6);
        dharamshalaDetails.put("Multan Jain Temple Dharamshala", multanDharamshala);

        // Swaminarayan Jain Temple, Karachi, Pakistan
        Map<String, Object> karachiDharamshala = new HashMap<>();
        karachiDharamshala.put("address", "Near Swaminarayan Jain Temple, Karachi, Pakistan");
        karachiDharamshala.put("phone", "+92 AA AAAAAAAA");
        karachiDharamshala.put("email", "karachijain.stay@example.com");
        karachiDharamshala.put("accommodation", "Guest houses in Karachi");
        karachiDharamshala.put("facilities", "Standard guest house facilities");
        karachiDharamshala.put("booking", "Check local guest houses.");
        karachiDharamshala.put("rating", 3.3f);
        karachiDharamshala.put("reviews", 10);
        dharamshalaDetails.put("Karachi Jain Temple Dharamshala", karachiDharamshala);

        // Jain Temple Sindh, Pakistan
        Map<String, Object> sindhDharamshala = new HashMap<>();
        sindhDharamshala.put("address", "Near Jain Temple(s) in Sindh, Pakistan (general area)");
        sindhDharamshala.put("phone", "+92 BB BBBBBBBB");
        sindhDharamshala.put("email", "sindhjain.stay@example.com");
        sindhDharamshala.put("accommodation", "Limited information, likely basic lodging in towns near temples");
        sindhDharamshala.put("facilities", "Likely very basic amenities");
        sindhDharamshala.put("booking", "Highly recommend local enquiry.");
        sindhDharamshala.put("rating", 2.5f);
        sindhDharamshala.put("reviews", 2);
        dharamshalaDetails.put("Sindh Jain Temple Dharamshala", sindhDharamshala);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dharamshala_detail);

        // Initialize Views
        tvDetailHeading = findViewById(R.id.tvDetailHeading);
        tvAddress = findViewById(R.id.tvAddress);
        tvPhone = findViewById(R.id.tvPhone);
        tvEmail = findViewById(R.id.tvEmail);
        tvAccommodation = findViewById(R.id.tvAccommodation);
        tvFacilities = findViewById(R.id.tvFacilities);
        tvBookingPolicies = findViewById(R.id.tvBookingPolicies);
        ratingBar = findViewById(R.id.ratingBar);
        tvReviewCount = findViewById(R.id.tvReviewCount);
        btnBookNow = findViewById(R.id.btnBookNow);

        // Get the Dharamshala name from the intent
        dharamshalaName = getIntent().getStringExtra("dharamshala_name");

        // Set the heading and populate details
        if (dharamshalaName != null) {
            tvDetailHeading.setText(dharamshalaName);
            populateDetails(dharamshalaName);
        } else {
            tvDetailHeading.setText("Dharamshala Details");
        }

        // Set OnClickListener for the Book Now button to start BookingActivity
        btnBookNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DharamshalaDetailActivity.this, BookingActivity.class);
                intent.putExtra("dharamshala_name", dharamshalaName);
                startActivity(intent);
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void populateDetails(String name) {
        if (dharamshalaDetails.containsKey(name)) {
            Map<String, Object> details = dharamshalaDetails.get(name);
            tvAddress.setText(String.valueOf(details.get("address")));
            tvPhone.setText("Phone: " + String.valueOf(details.get("phone")));
            tvEmail.setText("Email: " + String.valueOf(details.get("email")));
            tvAccommodation.setText("Accommodation: " + String.valueOf(details.get("accommodation")));
            tvFacilities.setText("Facilities: " + String.valueOf(details.get("facilities")));
            tvBookingPolicies.setText("Booking: " + String.valueOf(details.get("booking")));
            ratingBar.setRating(Float.parseFloat(String.valueOf(details.get("rating"))));
            tvReviewCount.setText("(" + String.valueOf(details.get("reviews")) + " Reviews)");
        } else {
            tvAddress.setText("Address not available");
            tvPhone.setText("Phone not available");
            tvEmail.setText("Email not available");
            tvAccommodation.setText("Details not available");
            tvFacilities.setText("Details not available");
            tvBookingPolicies.setText("Details not available");
            ratingBar.setRating(0f);
            tvReviewCount.setText("(0 Reviews)");
        }
    }
}