package vn.iotstar.ltmob210225;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity_LinearLayout1 extends AppCompatActivity {

    private Button btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_linear1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.act_linear1), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // button next (Activity_LinearLayout2)
        btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(view -> {
            Intent intent = new Intent(Activity_LinearLayout1.this, Activity_LinearLayout2.class);
            startActivity(intent);
        });
    }
}
