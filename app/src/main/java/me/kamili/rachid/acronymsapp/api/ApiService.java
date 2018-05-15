package me.kamili.rachid.acronymsapp.api;

import java.util.List;

import io.reactivex.Observable;
import me.kamili.rachid.acronymsapp.module.AcromineResponse;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiService {

    //Getting Acronyms
    @GET("/software/acromine/dictionary.py")
    Observable<List<AcromineResponse>> getAcronyms(@Query("sf") String query);

}
