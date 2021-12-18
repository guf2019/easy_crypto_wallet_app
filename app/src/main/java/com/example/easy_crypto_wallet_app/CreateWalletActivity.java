package com.example.easy_crypto_wallet_app;
import com.example.easy_crypto_wallet_app.constants.ServiceConstants;
import com.example.easy_crypto_wallet_app.common.yaml.YamlDriver;
import com.example.easy_crypto_wallet_app.constants.ConfigConstants;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.net.URL;
import java.util.Map;

public class CreateWalletActivity extends AppCompatActivity {
    private final String YamlPath = ServiceConstants.YamlPath;
    private final Map<String, Object> YamlConfig = new YamlDriver().YamlConverterToMap(YamlPath);
    private TextView TextViewMnemonicPhrase = findViewById(R.id.TextViewMnemonicPhrase);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_wallet);

        GetMnemonicPhrase();
    }

    private void GetMnemonicPhrase(){
        URL MnemonicPhraseUrlServiceEndpoint = GetMnemonicPhraseUrlServiceEndpoint();

    }

    private URL GetMnemonicPhraseUrlServiceEndpoint() {
        Map<String, Object> Bip44 = (Map<String, Object>) YamlConfig.get(ConfigConstants.Bip44);
        if (Bip44 != null){
            return (URL) Bip44.get(ConfigConstants.MnemonicPhrase);
        }
        return null;
    }
}