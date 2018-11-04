package id.technologyartisan.workshopandroid.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public ApiService getService(){
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("http://api.futnet.id/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ApiService.class);
    }
}
