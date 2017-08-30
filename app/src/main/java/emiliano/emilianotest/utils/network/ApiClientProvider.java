package emiliano.emilianotest.utils.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Emiliano on 30/8/17.
 */

public class ApiClientProvider {

    private static final String BASE_URL = "";

    public FeedsApiClient getAPI(){
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(FeedsApiClient.class);
    }
}
