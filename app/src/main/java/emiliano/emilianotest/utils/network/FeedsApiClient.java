package emiliano.emilianotest.utils.network;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Emiliano on 30/8/17.
 */

public interface FeedsApiClient {

    @GET("country/get/all")
    Call<String> getResults();
}
