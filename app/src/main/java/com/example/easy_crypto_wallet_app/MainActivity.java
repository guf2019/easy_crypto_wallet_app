package com.example.easy_crypto_wallet_app;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {
    private Button ButtonCreateWallet;
    private Button ButtonImportWallet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ButtonCreateWallet = findViewById(R.id.ButtonCreateWallet);
        ButtonImportWallet = findViewById(R.id.ButtonImportWallet);

        ButtonCreateWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateWalletActivity.class);
                startActivity(intent);

            }
        });

        ButtonImportWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


}