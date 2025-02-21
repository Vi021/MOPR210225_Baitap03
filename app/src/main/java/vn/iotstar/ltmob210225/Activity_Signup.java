package vn.iotstar.ltmob210225;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity_Signup extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.act_signup), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

//        Button btn_signup = findViewById(R.id.btn_signup);
//        btn_signup.setOnClickListener(view -> {
//            // do something
//        });

//        TextView textView17 = findViewById(R.id.textView17);
//        SpannableString spannable = getSpannableString();
//        textView15.setText(spannable);
//        textView15.setMovementMethod(LinkMovementMethod.getInstance()); // Enables click event
    }
}
