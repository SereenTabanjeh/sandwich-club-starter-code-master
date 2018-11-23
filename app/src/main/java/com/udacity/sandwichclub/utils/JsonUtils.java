package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;


public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwichObj = new Sandwich();
        try {

            JSONObject sandwichJson = new JSONObject(json);

            JSONObject name = sandwichJson.getJSONObject("name");
            String mainName = name.getString("mainName");
            JSONArray alsoKnownAs = name.getJSONArray("alsoKnownAs");
            int alsoKnownAsLength = alsoKnownAs.length();

            List<String> knownAsList = new ArrayList<>();

            for(int i=0; i<alsoKnownAsLength; i++){
                knownAsList.add(alsoKnownAs.getString(i));
            }

            String placeOfOrigin = sandwichJson.getString("placeOfOrigin");

            String description = sandwichJson.getString("description");

            String image = sandwichJson.getString("image");

            JSONArray ingredients = sandwichJson.getJSONArray("ingredients");
            int ingredientsLength = ingredients.length();

            List<String> ingredientsList = new ArrayList<>();

            for(int i=0; i<ingredientsLength; i++){
                ingredientsList.add(ingredients.getString(i));

            }

            sandwichObj.setMainName(mainName);
            sandwichObj.setAlsoKnownAs(knownAsList);
            sandwichObj.setDescription(description);
            sandwichObj.setPlaceOfOrigin(placeOfOrigin);
            sandwichObj.setIngredients(ingredientsList);
            sandwichObj.setImage(image);


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sandwichObj;
    }
}
