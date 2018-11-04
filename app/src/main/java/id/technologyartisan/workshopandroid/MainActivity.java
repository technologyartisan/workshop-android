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
import id.technologyartisan.workshopandroid.api.ApiService;
import id.technologyartisan.workshopandroid.database.DbHelper;
import id.technologyartisan.workshopandroid.model.Contact;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton fabAddContact;
    private RecyclerView rvContact;

    private RecyclerViewAdapter adapter;

    private List<Contact> contacts=new ArrayList<>();

    ApiService service;
    ApiClient apiClient;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Contact");

        apiClient=new ApiClient();
        service=apiClient.getService();
        fabAddContact=findViewById(R.id.fab_add_contact);
        fabAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,AddContactActivity.class));
            }
        });

        rvContact=findViewById(R.id.rv_contact);
        rvContact.setLayoutManager(new LinearLayoutManager(this));

//        callApi();
        callContactLocal();
        callApi();
    }

    private void callApi(){
        service.getContact()
                .enqueue(new Callback<List<Contact>>() {
                    @Override
                    public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
                        if (response.isSuccessful()){
                            DbHelper dbHelper=new DbHelper(MainActivity.this);

                            dbHelper.deleteContact();

                            contacts=response.body();

//                            loop contact
                            for (Contact contact:contacts) {
                                dbHelper.insertContact(contact.getId(),contact.getName(),contact.getNumber(),contact.getPicture());
                            }
                            setAdapter();
                        }else {

                        }
                    }

                    @Override
                    public void onFailure(Call<List<Contact>> call, Throwable t) {

                    }
                });
    }

    private void setAdapter(){
        adapter=new RecyclerViewAdapter(this,contacts);
        rvContact.setAdapter(adapter);
    }

    private void callContactLocal(){
        DbHelper dbHelper=new DbHelper(this);
        contacts=dbHelper.selectContact();

        setAdapter();
    }
}
