package com.titanfrs.kulineran.API;

import com.titanfrs.kulineran.model.RestoModel;
import retrofit2.http.GET;
import retrofit2.Call;

public interface APIRestoService {

    //read
    @GET("r2kld")
    Call<RestoModel>getPegiMakan();

}