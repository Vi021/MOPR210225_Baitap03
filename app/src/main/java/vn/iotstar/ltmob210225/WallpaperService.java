package vn.iotstar.ltmob210225;

import android.os.AsyncTask;

import java.net.HttpURLConnection;
import java.net.URL;

public class WallpaperService {
    private static final String WALLPAPER_API_URL = "https://source.unsplash.com/random/1080x1920"; // Gets a random wallpaper

    public interface WallpaperCallback {
        void onSuccess(String imageUrl);
        void onFailure();
    }

    public static void fetchRandomWallpaper(WallpaperCallback callback) {
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... voids) {
                try {
                    URL url = new URL(WALLPAPER_API_URL);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setInstanceFollowRedirects(true);
                    connection.connect();

                    String finalUrl = connection.getURL().toString(); // Get the final redirected URL
                    return finalUrl;
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }

            @Override
            protected void onPostExecute(String result) {
                if (result != null) {
                    callback.onSuccess(result);
                } else {
                    callback.onFailure();
                }
            }
        }.execute();
    }
}
