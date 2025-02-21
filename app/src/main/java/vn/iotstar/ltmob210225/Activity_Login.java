package vn.iotstar.ltmob210225;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity_Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.act_login), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(view -> {
            // do something
        });

        TextView textView15 = findViewById(R.id.textView15);
        SpannableString spannable = getSpannableString();
        textView15.setText(spannable);
        textView15.setMovementMethod(LinkMovementMethod.getInstance()); // Enables click event
    }

    // for partially clickable, underlined, different color text in a string, in this case: "Are you a new user? >>Register<<"
    @NonNull
    private SpannableString getSpannableString() {
        SpannableString spannable = new SpannableString("Are you a new user? Register");
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Intent intent = new Intent(Activity_Login.this, Activity_Signup.class);
                startActivity(intent);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(true); // Ensure underline
                ds.setColor(Color.argb(255, 234, 109, 53)); // Change color if needed
            }
        };

        spannable.setSpan(clickableSpan, 20, spannable.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannable;
    }
}
