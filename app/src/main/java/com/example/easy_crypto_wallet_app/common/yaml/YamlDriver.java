package com.example.easy_crypto_wallet_app.common.yaml;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;
import java.util.Objects;

public class YamlDriver {

    public Map<String, Object> YamlConverterToMap(String Path) {
        Yaml yaml = new Yaml();
        InputStream inputStream = Objects.requireNonNull(this.getClass()
                .getClassLoader())
                .getResourceAsStream(Path);
        Map<String, Object> obj = (Map<String, Object>) yaml.load(inputStream);
        return obj;
    }
}
