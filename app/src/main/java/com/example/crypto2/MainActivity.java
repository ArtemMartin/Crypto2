package com.example.crypto2;

import static com.example.crypto2.Crypto.getCryptoMessage;
import static com.example.crypto2.Crypto.getDeCryptoMessage;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    static String messageInput;
    Button btnZakodirovat;
    Button btnRazkodirovat;
    EditText inputText;
    EditText outputText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inputText = findViewById(R.id.inputText);
        outputText = findViewById(R.id.outputText);

        //мерцание
        @SuppressLint("ResourceType") final Animation animRotate = AnimationUtils.loadAnimation(this, R.drawable.mercanie);
        /**
         * слушаем кнопку закодировать
         */
        btnZakodirovat = findViewById(R.id.btnZakodirovat);
        btnZakodirovat.setOnClickListener(v -> {
            v.startAnimation(animRotate);
            messageInput = inputText.getText().toString();
            outputText.setText(getCryptoMessage(messageInput));
        });

        /**
         * слушаем кнопку разкодировать
         */
        btnRazkodirovat = findViewById(R.id.btnRazkodirovat);
        btnRazkodirovat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animRotate);
                messageInput = inputText.getText().toString();
                outputText.setText(getDeCryptoMessage(messageInput));
            }
        });
    }
}