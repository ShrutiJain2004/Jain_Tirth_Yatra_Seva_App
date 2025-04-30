package com.example.application;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.TextRecognizer;
import com.google.mlkit.vision.text.latin.TextRecognizerOptions;

import java.io.IOException;

public class OCRFragment extends Fragment {

    private static final int REQUEST_CAMERA = 100;
    private static final int REQUEST_GALLERY = 101;

    private ImageView imageView;
    private TextView textView;
    private Button cameraButton, galleryButton;

    public OCRFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ocr, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        imageView = view.findViewById(R.id.imageView);
        textView = view.findViewById(R.id.textView);
        cameraButton = view.findViewById(R.id.cameraButton);
        galleryButton = view.findViewById(R.id.galleryButton);

        cameraButton.setOnClickListener(v -> {
            if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(requireActivity(), new String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA);
            } else {
                openCamera();
            }
        });

        galleryButton.setOnClickListener(v -> openGallery());
    }

    private void openCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CAMERA);
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, REQUEST_GALLERY);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK && data != null) {
            Bitmap bitmap = null;
            if (requestCode == REQUEST_CAMERA) {
                bitmap = (Bitmap) data.getExtras().get("data");
            } else if (requestCode == REQUEST_GALLERY) {
                Uri uri = data.getData();
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), uri);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                runTextRecognition(bitmap);
            }
        }
    }

    private void runTextRecognition(Bitmap bitmap) {
        InputImage image = InputImage.fromBitmap(bitmap, 0);
        TextRecognizer recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS);

        recognizer.process(image)
                .addOnSuccessListener(visionText -> textView.setText(visionText.getText()))
                .addOnFailureListener(e -> textView.setText("Failed: " + e.getMessage()));
    }
}
