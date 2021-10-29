package API;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.squareup.okhttp.*;

import java.io.IOException;

public class TranslateWord {

    private static final String subscriptionKey = "ba36d98c47e245288ba61f8a3a7c6723";
    HttpUrl url = new HttpUrl.Builder()
            .scheme("https")
            .host("api.cognitive.microsofttranslator.com")
            .addPathSegment("/Dictionary/Lookup")
            .addQueryParameter("api-version", "3.0")
            .addQueryParameter("from", "en")
            .addQueryParameter("to", "vi")
            .build();

    OkHttpClient client = new OkHttpClient();

    public String Post(String word) throws IOException {
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType,
                "[{\n\t\"Text\": \"" + word + "\"\n}]");
        Request request = new Request.Builder()
                .url(url).post(body)
                .addHeader("Ocp-Apim-Subscription-Key", subscriptionKey)
                .addHeader("Ocp-Apim-Subscription-Region", "southeastasia")
                .addHeader("Content-type", "application/json").build();
        Response response = client.newCall(request).execute();

        StringBuilder meaning = new StringBuilder();

        Gson gson = new Gson();

        JsonArray jsonArray = gson.fromJson(response.body().string(), JsonArray.class);

        JsonObject jsonObject = (JsonObject) jsonArray.get(0);

        JsonArray subArray = gson.fromJson(jsonObject.get("translations").toString(), JsonArray.class);

        for (int i = 0; i < subArray.size(); ++i) {
            JsonObject getobject = (JsonObject) subArray.get(i);

            String tmpPostTag = String.valueOf(getobject.get("posTag"));
            tmpPostTag = tmpPostTag.substring(1, tmpPostTag.length() - 1);
            String tmpDisplayTag = String.valueOf(getobject.get("displayTarget"));
            tmpDisplayTag = tmpDisplayTag.substring(1, tmpDisplayTag.length() - 1);

            meaning.append("(").append(tmpPostTag).append(")").append("\t\t\t\t\t").append(tmpDisplayTag).append("\n");

        }

        return meaning.toString();
    }

    /**
     * @param wordToTranslate
     * @return
     */
    public String translateWord(String wordToTranslate) {
        try {
            TranslateWord translateRequest = new TranslateWord();
            return translateRequest.Post(wordToTranslate);
        } catch (Exception e) {
            return "e.getMessage()";
        }
    }
}

