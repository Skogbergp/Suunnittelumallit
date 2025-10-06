package org.example;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ApiFacade {

    public String getAttributeValueFromJson(String urlString, String attributeName)
            throws IllegalArgumentException, IOException {

        String body = httpGet(urlString);
        Object jsonRoot = parseJson(body);

        String found = findFirstAttribute(jsonRoot, attributeName);
        if (found == null) {
            throw new IllegalArgumentException("Attribute '" + attributeName + "' not found in JSON.");
        }
        return found;
    }


    private String httpGet(String urlString) throws IOException {
        HttpURLConnection con = null;
        try {
            URL url = new URL(urlString); // MalformedURLException -> IOException (subclass)
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setConnectTimeout(10_000);
            con.setReadTimeout(10_000);

            int status = con.getResponseCode();
            InputStream stream = status >= 200 && status < 300
                    ? con.getInputStream()
                    : con.getErrorStream();

            String payload = readAll(stream);
            if (status < 200 || status >= 300) {
                throw new IOException("HTTP GET failed (" + status + "): " + truncate(payload, 300));
            }
            return payload;
        } finally {
            if (con != null) con.disconnect();
        }
    }

    private String readAll(InputStream in) throws IOException {
        if (in == null) return "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))) {
            StringBuilder sb = new StringBuilder();
            char[] buf = new char[4096];
            int n;
            while ((n = br.read(buf)) != -1) sb.append(buf, 0, n);
            return sb.toString();
        }
    }

    private String truncate(String s, int max) {
        if (s == null) return "";
        return s.length() <= max ? s : s.substring(0, max) + "...";
    }


    private Object parseJson(String body) throws IOException {
        try {
            return new JSONParser().parse(body);
        } catch (ParseException e) {
            throw new IOException("Response was not valid JSON: " + e.getMessage(), e);
        }
    }

    private String findFirstAttribute(Object node, String attributeName) {
        if (node instanceof JSONObject obj) {
            for (Object k : obj.keySet()) {
                String key = String.valueOf(k);
                Object val = obj.get(k);

                if (attributeName.equals(key)) {
                    return val == null ? null : String.valueOf(val);
                }
                String nested = findFirstAttribute(val, attributeName);
                if (nested != null) return nested;
            }
        } else if (node instanceof JSONArray arr) {
            for (Object elem : (JSONArray) arr) {
                String nested = findFirstAttribute(elem, attributeName);
                if (nested != null) return nested;
            }
        }
        return null;
    }
}

