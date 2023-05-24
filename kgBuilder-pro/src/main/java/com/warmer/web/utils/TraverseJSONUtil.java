package com.warmer.web.utils;

import cn.hutool.json.JSONObject;
import org.json.JSONException;

public class TraverseJSONUtil {
    public static void traverseJsonObject(JSONObject jsonObj) {
        for (java.util.Map.Entry<String, Object> entry : jsonObj.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof JSONObject) {
                System.out.println(key + ": JSONObject");
                traverseJsonObject((JSONObject) value);
            } else {
                System.out.println(key + ": " + value);
            }
        }
    }


    public static String parse(String input) {
        try {
            JSONObject jsonObject = new JSONObject(input);
            return parseJson(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String parseJson(JSONObject jsonObject) throws JSONException {
        StringBuilder parsedJson = new StringBuilder();
        parsedJson.append("{");

        boolean firstEntry = true;
        for (String key : jsonObject.keySet()) {
            if (!firstEntry) {
                parsedJson.append(",");
            }

            parsedJson.append(key);
            parsedJson.append(":");
            parsedJson.append(parseValue(jsonObject.get(key)));

            firstEntry = false;
        }

        parsedJson.append("}");
        return parsedJson.toString();
    }

    private static String parseValue(Object value) throws JSONException {
        if (value instanceof JSONObject) {
            return parseJson((JSONObject) value);
        } else {
            return "\"" + value.toString() + "\"";
        }
    }

}
