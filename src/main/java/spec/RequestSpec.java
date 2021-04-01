package spec;

import io.restassured.authentication.PreemptiveOAuth2HeaderScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {

    RequestSpecification requestSpecification;
    public RequestSpec(String baseUrl)

    {
        PreemptiveOAuth2HeaderScheme authenticationScheme=new PreemptiveOAuth2HeaderScheme();
        authenticationScheme.setAccessToken("BQA-zUTNhzmAlgBW52ywf3I_6ALw2FQEGkTYY_Oo-uJ3VjDpHp6CSv890mckHZJrCgo-uXoonxgNb8T9r0xjpQGjbx_M_ub4Jxh9CjMBbeLLkX4dpfxhsL__DenBSm-qLM6CqGomypUXdCw1i3_H3HedvHIT0XacihE4QcN43MvEaLXqqx55HecX2F1YZYr_BGU6p4VfUlTxs8d9NalYbdwFZtly1wm4ChoXZhkDnaCNQvTozofUaoPJovgHQWtkbjkr47erwJo6Ft7xlTc");
        //String token="BQBIb5sjCDNw2Y6Ho8S5KMuLO_W0r3mQzrhDPyc1ofYgbd_uYsvJHme96Jy5Jb21JFSd0pr72chZRdrQgexQWtjW9Emz8qY1h82FXLevPXEaTNt0eRk90c4Te0NiyIi6gRMxk4KhFTxpwUne67lwfW4xoBOnCSjtoIKfixratZOFmShWN_w70Bk6rU1THhPZiJnXPQsEqx4NWhGCan_jO84ZYi5jH1o8_Kl66GRXYGHRJawa_24kC8pfXGaP2TWmaPat06FPkvL8eP1dq0o";
        requestSpecification=new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setContentType("application/json")
                .setAuth(authenticationScheme)
                .build();
    }


    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }
}
