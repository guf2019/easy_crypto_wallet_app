package com.example.easy_crypto_wallet_app;
import com.example.easy_crypto_wallet_app.config.*;
import com.example.easy_crypto_wallet_app.constants.Constants;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.NonNull;

import org.json.JSONObject;
import org.yaml.snakeyaml.Yaml;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Map;

public class CreateWalletActivity extends AppCompatActivity {
    private TextView MnemonicPhrase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_wallet);
        MnemonicPhrase = findViewById(R.id.MnemonicPhrase);
        String Url = new Constants().YamlPath;

        String ApiRequestMnemonicPhrase = GetApiResponseUrl(Url);
        MnemonicPhrase.setText(GetMnemonicPhrase(ApiRequestMnemonicPhrase));
    }

    private String GetApiResponseUrl(String Url) {
        Yaml yaml= new Yaml();
        Map<String,Object> map= (Map<String, Object>) yaml.load(Url);

        JSONObject jsonObject=new JSONObject(map);
        return jsonObject.toString();
    }


    private String GetMnemonicPhrase(String url){
        OkHttpClient client = new OkHttpClient();
        Request req = new Request.Builder().url(url).build();
        client.newCall(req).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {e.printStackTrace();}
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()){
                    final String myResponse = response.body().string();

                    CreateWalletActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            return myResponse;
                        }
                    });
                }
            }

}