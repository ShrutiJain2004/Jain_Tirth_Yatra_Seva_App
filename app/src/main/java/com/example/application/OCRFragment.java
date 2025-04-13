package com.example.application;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.TextRecognizer;
import com.google.mlkit.vision.text.latin.TextRecognizerOptions;
import java.io.IOException;

public class OCRFragment extends Fragment {

    private static final int PICK_IMAGE_REQUEST = 1;
    private ImageView imageView;
    private TextView textView;
    private Bitmap selectedImage;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ocr, container, false);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btnSelectImage = view.findViewById(R.id.btn_select_image);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btnRecognizeText = view.findViewById(R.id.btn_recognize_text);
        imageView = view.findViewById(R.id.imageView);
        textView = view.findViewById(R.id.textView);

        btnSelectImage.setOnClickListener(v -> openImagePicker());
        btnRecognizeText.setOnClickListener(v -> recognizeText());

        return view;
    }

    private void openImagePicker() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            Uri imageUri = data.getData();
            try {
                selectedImage = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), imageUri);
                imageView.setImageBitmap(selectedImage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void recognizeText() {
        if (selectedImage == null) {
            textView.setText("Please select an image first.");
            return;
        }

        InputImage image = InputImage.fromBitmap(selectedImage, 0);
        TextRecognizer recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS);

        recognizer.process(image)
                .addOnSuccessListener(result -> {
                    StringBuilder extractedText = new StringBuilder();
                    for (Text.TextBlock block : result.getTextBlocks()) {
                        extractedText.append(block.getText()).append("\n");
                    }
                    textView.setText(extractedText.toString());
                })
                .addOnFailureListener(e -> textView.setText("Failed to recognize text."));
    }
}
