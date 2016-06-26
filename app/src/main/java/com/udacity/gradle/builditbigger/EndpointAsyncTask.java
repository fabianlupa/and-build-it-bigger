package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.backend.jokeApi.JokeApi;

import java.io.IOException;

/**
 * Task to retrieve a random joke from GCE backend
 */
public class EndpointAsyncTask extends AsyncTask<Void, Void, String> {
    private static JokeApi jokeApi = null;
    private Callback callback;

    public EndpointAsyncTask(Callback callback) {
        this.callback = callback;
    }

    @Override
    protected String doInBackground(Void... params) {
        if (jokeApi == null) {
            // Options for local development
            /*JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver */

            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://build-it-bigger-backend-1354.appspot.com/_ah/api/");

            jokeApi = builder.build();
        }

        try {
            return jokeApi.getRandomJoke().execute().getText();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        callback.onResult(s);
    }

    public interface Callback {
        void onResult(String joke);
    }
}
