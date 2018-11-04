package id.technologyartisan.workshopandroid.api;

import java.util.List;

import id.technologyartisan.workshopandroid.model.Contact;
import id.technologyartisan.workshopandroid.model.Response;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST("contact")
    Call<Response> addContact(@Field("name") String name, @Field("phone_number") String phneNumber);

    @GET("contact")
    Call<List<Contact>> getContact();
}
