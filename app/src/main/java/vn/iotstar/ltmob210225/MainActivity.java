package vn.iotstar.ltmob210225;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.IOException;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mainLayout;
    private Button setWallpaperButton;
    private Switch swi_wallpaper;
    private int[] wallpapers = {R.drawable.wallpaper1, R.drawable.wallpaper2, R.drawable.wallpaper3}; // Add your images here
    private int currentWallpaperResId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mainLayout = findViewById(R.id.mainLayout);
        setWallpaperButton = findViewById(R.id.setWallpaperButton);
        swi_wallpaper = findViewById(R.id.swi_wallpaper);

        // Load a random wallpaper
        loadRandomWallpaper();

        // Set wallpaper on button click
        setWallpaperButton.setOnClickListener(view -> setAsWallpaper(currentWallpaperResId));
        // Set switch listener
        swi_wallpaper.setOnCheckedChangeListener((buttonView, isChecked) -> {
            int currentResId = 0;
            if (isChecked) {
                currentResId = currentWallpaperResId;
                loadRandomWallpaper(); // Show random wallpaper
            } else {
                mainLayout.setBackgroundResource(wallpapers[currentResId]); // Show current wallpaper
            }
        });
    }

    private void loadRandomWallpaper() {
        Random random = new Random();
        int randomIndex = random.nextInt(wallpapers.length);
        currentWallpaperResId = wallpapers[randomIndex];

        // Set the background
        mainLayout.setBackgroundResource(currentWallpaperResId);
    }

    private void setAsWallpaper(int resId) {
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resId);

        try {
            wallpaperManager.setBitmap(bitmap);
            Toast.makeText(this, "Wallpaper set successfully!", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, "Failed to set wallpaper.", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}