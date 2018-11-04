package id.technologyartisan.workshopandroid;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.technologyartisan.workshopandroid.api.ApiClient;
import id.technologyartisan.workshopandroid.api.ApiService;
import id.technologyartisan.workshopandroid.database.DbHelper;
import id.technologyartisan.workshopandroid.model.Contact;
import id.technologyartisan.workshopandroid.model.Response;
import retrofit2.Call;
import retrofit2.Callback;

public class AddContactActivity extends AppCompatActivity {
    private Button btnAdd;
    private EditText etContactName,etContactNumber;

    ApiService service;
ApiClient apiClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        setTitle("Add Contact");

        apiClient=new ApiClient();
        service=apiClient.getService();

        etContactName=findViewById(R.id.et_contact_name);
        etContactNumber=findViewById(R.id.et_contact_number);

        btnAdd=findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                addContact();
                addContactLocal();
            }
        });
    }

    private void addContact(){
        String name=etContactName.getText().toString();
        String number=etContactNumber.getText().toString();

        service.addContact(name,number)
                .enqueue(new Callback<Response>() {
                    @Override
                    public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                        if (response.isSuccessful()){
                            Toast.makeText(AddContactActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(AddContactActivity.this, "Gagal tambah data", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {
                        Toast.makeText(AddContactActivity.this, "Error : "+t, Toast.LENGTH_SHORT).show();

                    }
                });
//        Toast.makeText(this, "Name : "+name+", number: "+number, Toast.LENGTH_SHORT).show();
    }

    private void addContactLocal(){
        int id=1;
        String name=etContactName.getText().toString();
        String number=etContactNumber.getText().toString();
        String picture="tes";

        DbHelper dbHelper=new DbHelper(this);

        long lastId=dbHelper.insertContact(id,name,number,picture);

        if (lastId>0){
            Toast.makeText(this, "Insert Berhasil", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Insert Gagal", Toast.LENGTH_SHORT).show();
        }
    }
}
