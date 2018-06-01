package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static final String NAME = "name";
    public static final String PLACEOFORIGIN = "placeOfOrigin";
    public static final String DESCRIPTION = "description";
    public static final String IMAGE = "image";
    public static final String INGREDIENTS = "ingredients";

    public static Sandwich parseSandwichJson(String json) throws JSONException {

        List<String> ingredientList = new ArrayList<String>();
        List<String> asKnownList = new ArrayList<String>();
        Sandwich mySandwich;


        JSONObject mainObject = new JSONObject(json);

        JSONObject nameObject = mainObject.getJSONObject(NAME);
        String mainName = nameObject.getString("mainName");

        JSONArray asknownArray = nameObject.getJSONArray("alsoKnownAs");
        if (asknownArray != null) {
            for (int i = 0; i < asknownArray.length(); i++) {
                asKnownList.add(asknownArray.getString(i));
            }
        }

        String placeOfOrigin = mainObject.getString(PLACEOFORIGIN);
        String description = mainObject.getString(DESCRIPTION);
        String image = mainObject.getString(IMAGE);
        JSONArray ingredientsArray = mainObject.getJSONArray(INGREDIENTS);
        if (ingredientsArray != null) {
            for (int i = 0; i < ingredientsArray.length(); i++) {
                ingredientList.add(ingredientsArray.getString(i));
            }
        }
        mySandwich = new Sandwich(mainName, asKnownList, placeOfOrigin, description, image, ingredientList);
        return mySandwich;
    }

}
