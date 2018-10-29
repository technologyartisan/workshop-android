package id.technologyartisan.workshopandroid;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import id.technologyartisan.workshopandroid.api.ApiClient;
import id.technologyartisan.workshopandroid.model.Contact;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton fabAddContact;
    private RecyclerView rvContact;

    private RecyclerViewAdapter adapter;

    private List<Contact> contacts=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Contact");

        ApiClient apiClient=new ApiClient();
        String nama=ApiClient.nama;
        String allamat=apiClient.alamat;

        fabAddContact=findViewById(R.id.fab_add_contact);
        fabAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,AddContactActivity.class));
            }
        });

        rvContact=findViewById(R.id.rv_contact);
        rvContact.setLayoutManager(new LinearLayoutManager(this));

        setDataContact();
        setAdapter();
    }

    private void setDataContact(){
        for (int i=0;i<3;i++){
            contacts.add(new Contact("Urip Yogantara","082237137611","urip.jpg"));
            contacts.add(new Contact("Wahyu Permadi","085123456789","wahyu.jpg"));
            contacts.add(new Contact("Kris Sanjaya","08108765432","kris.jpg"));
        }
    }

    private void setAdapter(){
        adapter=new RecyclerViewAdapter(this,contacts);
        rvContact.setAdapter(adapter);
    }
}
