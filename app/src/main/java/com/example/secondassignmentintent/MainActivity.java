package com.example.secondassignmentintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText title,message;
    Button send,whatsapp_pk,whatsapp_usa,goodword_books,website_btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);


        title=findViewById(R.id.editTextTextPersonName);
        message=findViewById(R.id.messagebox);

        send=findViewById(R.id.submit);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title_text= title.getText().toString();
                String message_text= message.getText().toString();
                Toast.makeText(MainActivity.this, "You clicked on send", Toast.LENGTH_SHORT).show();
                if(title_text.length()<1){
                    Toast.makeText(MainActivity.this, "Title field is empty", Toast.LENGTH_SHORT).show();
                }else if(message_text.length()<1){
                    Toast.makeText(MainActivity.this, "Message field is empty", Toast.LENGTH_SHORT).show();
                }else{
                    // here we will make the new email sender intent....
                    Intent intent=new Intent(Intent.ACTION_SENDTO);
                    intent.setType("text/plain");
                    intent.setData(Uri.parse("mailto:"));

                    // now set the receiver, subject and message body
                    String[] receivers={"umairpu24@gmail.com"};
                    intent.putExtra(Intent.EXTRA_EMAIL,receivers);
                    intent.putExtra(Intent.EXTRA_SUBJECT,title_text);
                    intent.putExtra(Intent.EXTRA_TEXT,message_text);

                    if(intent.resolveActivity(getPackageManager())!=null){
                        // if application exists then send the email using that app
                        startActivity(intent);
                    }else {
                        // or display the error
                        Toast.makeText(MainActivity.this, "No Email application exists", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }

}