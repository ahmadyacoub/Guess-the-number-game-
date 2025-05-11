package com.example.todo1;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.util.Random;


public class game_page extends AppCompatActivity {


    Button lower_button, higher_button, equal_button;


    int target_number;
    int current_number = 50;
    int min_number=1;
    int max_number =100;

    private static final String MY_CHANNEL_ID = "my_chanel_1";
    private static final String MY_CHANNEL_NAME = "My channel";
    private void createNotificationChannel() {
        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel channel = new NotificationChannel(MY_CHANNEL_ID,
                MY_CHANNEL_NAME, importance);
        NotificationManager notificationManager =
                getSystemService(NotificationManager.class);
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(channel);
        }
    }
    private static final int NOTIFICATION_ID = 123;
    private static final String NOTIFICATION_TITLE = "The Target Number Is : ";
    public void createNotification(String title, String body) {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent, 0);
        createNotificationChannel();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,
                MY_CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(body)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(body))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent);
        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(this);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);

        TextView welcome_text = (TextView) findViewById(R.id.welcome_text);
        TextView number_text =(TextView) findViewById(R.id.number_text);
        TextView target_ref = (TextView) findViewById(R.id.target_ref);
        lower_button = (Button)findViewById(R.id.lower_button);
        higher_button= (Button)findViewById(R.id.higher_button);
        equal_button= (Button)findViewById(R.id.equal_button);
        resetButtonColors();
        String first_name = getIntent().getStringExtra("first_name");
        String last_name = getIntent().getStringExtra("last_name");
        String gender = getIntent().getStringExtra("gender");

        Random random_number=new  Random();
        target_number = random_number.nextInt(100)+1; //(0 to 99) + 1 = 1 to 100
        current_number=(min_number+max_number)/2;
        number_text.setText(String.valueOf(current_number));



        welcome_text.setText("Welcome "+ first_name+" "+last_name+" "+"!");
        target_ref.setText(String.valueOf(target_number));
        String NOTIFICATION_BODY = Integer.toString(target_number);
        createNotification(NOTIFICATION_TITLE,NOTIFICATION_BODY);


        lower_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetButtonColors();
                if (current_number>target_number){
                    lower_button.setBackgroundColor(Color.GREEN);
                    max_number=current_number-1;
                    current_number=(min_number+max_number)/2;
                    number_text.setText(String.valueOf(current_number));

                }else {
                    lower_button.setBackgroundColor(Color.RED);
                    Toast toast=   Toast.makeText(game_page.this,"WRONG ! ",Toast.LENGTH_SHORT);
                    toast.show();

                }

            }
        });

        higher_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetButtonColors();
                if (current_number<target_number){
                    higher_button.setBackgroundColor(Color.GREEN);
                    min_number=current_number+1;
                    current_number=(min_number+max_number)/2;
                    number_text.setText(String.valueOf(current_number));

                }else {
                    higher_button.setBackgroundColor(Color.RED);

                    Toast toast=   Toast.makeText(game_page.this,"WRONG ! ",Toast.LENGTH_SHORT);
                    toast.show();

                }

            }
        });
        equal_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetButtonColors();
                if (current_number==target_number){
                    equal_button.setBackgroundColor(Color.GREEN);
                    Toast toast_equal=   Toast.makeText(game_page.this,"Correct ! ",Toast.LENGTH_SHORT);
                    toast_equal.show();
                    Intent intent=new Intent(game_page.this,    MainActivity.class);
                    startActivity(intent);



                }else {
                    equal_button.setBackgroundColor(Color.RED);

                    Toast toast=   Toast.makeText(game_page.this,"WRONG ! ",Toast.LENGTH_SHORT);
                    toast.show();

                }

            }
        });


    }
    private void resetButtonColors() {
        lower_button.setBackgroundColor(Color.parseColor("#673AB7FF"));
        higher_button.setBackgroundColor(Color.parseColor("#673AB7FF"));
        equal_button.setBackgroundColor(Color.parseColor("#673AB7FF"));
    };
}