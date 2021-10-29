package API;

import com.squareup.okhttp.*;

import java.io.IOException;

public class TranslateText {

    private static final String subscriptionKey = "ba36d98c47e245288ba61f8a3a7c6723";
    HttpUrl url = new HttpUrl.Builder()
            .scheme("https")
            .host("api.cognitive.microsofttranslator.com")
            .addPathSegment("/translate")
            .addQueryParameter("api-version", "3.0")
            .addQueryParameter("from", "en")
            .addQueryParameter("to", "vi")
            .build();

    OkHttpClient client = new OkHttpClient();

    public String Post(String wordToTranslation) throws IOException {
        MediaType mediaType = MediaType.parse("application/json");

        RequestBody body = RequestBody.create(mediaType,
                "[{\n\t\"Text\":" + "\"" + wordToTranslation + "\"" + "\n}]");

        Request request = new Request.Builder()
                .url(url).post(body)
                .addHeader("Ocp-Apim-Subscription-Key", subscriptionKey)
                .addHeader("Ocp-Apim-Subscription-Region", "southeastasia")
                .addHeader("Content-type", "application/json").build();

        Response response = client.newCall(request).execute();

        String responseString = response.body().string();
        return responseString.substring(27, responseString.length() - 15);
    }

    /**
     * @param wordToTranslation
     * @return
     * @throws IOException
     */
    public String Translate(String wordToTranslation) throws IOException {
        TranslateText translateRequest = new TranslateText();
        return translateRequest.Post(wordToTranslation);
    }
}
