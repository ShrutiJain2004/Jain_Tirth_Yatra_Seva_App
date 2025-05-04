package com.example.application;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AboutUsFragment extends Fragment {

    public AboutUsFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about_us, container, false);

        TextView introText = view.findViewById(R.id.about_intro_text);
        TextView continueText = view.findViewById(R.id.about_continue_text);

        String aboutIntro = "Welcome to Jain Tirth Yatra Seva!\n\n" +
                "Our app is dedicated to helping users discover, plan, and embark on meaningful Jain pilgrimage journeys. Rooted in the rich spiritual heritage of Jainism, this platform serves as a guide for all those who wish to explore tirths with devotion and convenience.\n\n" +

                "🌟 Why We Built This App:\n" +
                "In today’s fast-paced world, finding reliable information about Jain pilgrimage sites can be difficult. We created this app to bridge that gap—bringing Jain Tirth information, travel planning tools, and historical context to your fingertips.\n\n" +

                "✨ Key Features:\n" +
                "🛕 Browse major and hidden Jain Tirths across India\n" +
                "🧭 Get maps, directions, and nearby amenities\n" +
                "📜 Read about temple history, significance, and rituals\n" +
                "🗓️ Create and save custom Yatra plans\n" +
                "💡 Access contact info, darshan timings, and travel tips\n" +
                "📷 View images and tirth highlights for inspiration\n\n" +

                "🙏 Our Vision:\n" +
                "To promote the principles of Jain Dharma and make the journey to self-realization more accessible. We believe every soul deserves the opportunity to connect with the sacred energy of Jain Tirths—no matter where they are.\n\n" +

                "📲 Stay Tuned:\n" +
                "We are continuously adding new tirths, user features, and tools to improve your yatra experience. Your feedback is valuable and helps us grow.\n";

        String continueInfo = "📧 Contact Us:\n" +
                "Have suggestions or need help? Reach out at: support@jaintirthyatra.app\n\n" +
                "🧘‍♂️ Jai Jinendra!\n" +
                "Thank you for being a part of our spiritual journey.\n\n" +
                "Version 1.0.0 - Made with faith and devotion.";

        introText.setText(aboutIntro);
        continueText.setText(continueInfo);

        return view;
    }
}
