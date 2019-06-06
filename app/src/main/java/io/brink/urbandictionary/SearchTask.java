package io.brink.urbandictionary;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SearchTask extends AsyncTask<String, Void, String> {

    SearchTaskCompletedListener mListener;

    public SearchTask(SearchTaskCompletedListener listener) {
        mListener = listener;


    }

    @Override
    protected String doInBackground(String... strings) {
        String resJson = "";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(strings[0])
                .build();

        try (Response response = client.newCall(request).execute()) {
            resJson = response.body().string();


        } catch (IOException e) {
            e.printStackTrace();
        }

        return resJson;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        try{
            JSONObject defObject =new JSONObject(s);
            JSONArray defArray = defObject.getJSONArray("list");
            int arrayLength = defArray.length();
            String[] defStringArray = new String[arrayLength];

            for (int i=0;i<arrayLength;i++){

                String definition = defArray.getJSONObject(i).getString("definition");

                defStringArray[i] = definition;

            }

            mListener.onSearchTaskCompleted(defStringArray);


        }
        catch (JSONException e){
            e.printStackTrace();
        }


    }
}
