/*
 * Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.finance.open.banking.conformance.test.core.oidc;

import com.google.gson.Gson;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.wso2.finance.open.banking.conformance.test.core.request.RequestGenerator;
import org.wso2.finance.open.banking.conformance.test.core.request.TokenEndPointRequestGenerator;

import static io.restassured.RestAssured.given;

/**
 * Helper for Handling OIDC flow.
 */
public class OIDCHandler {

    private static Logger log = Logger.getLogger(OIDCHandler.class);

    class TokenEndResponse {

        private String access_token;
        private String refresh_token;
        private String scope;
        private String token_type;
        private int expired_in;

        public String getAccess_token() {

            return access_token;
        }
    }

    private String clientID = "";
    private String clientSecret = "";
    private String callbackURL = "";
    private String authEnd = "";
    private String tokenEnd = "";
    private String authCode = "";
    private String scope = "";
    private String grantType = "";

    /**
     * @param clientID
     * @param clientSecret
     * @param authEnd
     * @param callbackURL
     * @param tokenEnd
     */
    public OIDCHandler(String clientID, String clientSecret, String authEnd, String callbackURL, String tokenEnd) {

        this.clientID = clientID;
        this.clientSecret = clientSecret;
        this.authEnd = authEnd;
        this.callbackURL = callbackURL;
        this.tokenEnd = tokenEnd;
    }

    /**
     * @param state
     * @return
     */
    public String createAuthUrlForUserContent(String state) {

        String url = authEnd + "?response_type=code&scope=" + scope + "&state=" +
                state + "&client_id=" + clientID + "&redirect_uri=" + callbackURL;
        log.debug("Get user consent url :" + url);
        return url;
    }

    /**
     * @return
     */
    public String getAccessTokenByAuthorizationCode() {

        RequestGenerator reqGenerator = new TokenEndPointRequestGenerator(grantType, scope, callbackURL, tokenEnd);
        RequestSpecification req = reqGenerator.generate();

        log.debug("Token EndPoint Request: " + req.toString());

        Response response = given().spec(req).when().post();

        log.debug("Token EndPoint Response: " + response.getBody().asString());

        Gson gson = new Gson();
        return gson.fromJson(response.getBody().asString(), TokenEndResponse.class).getAccess_token();

    }

    /**
     * @return
     */
    public String getAccessTokenByClientCredintials() {

        return "";

    }

    /**
     * @param authCode
     */
    public void setAuthCode(String authCode) {

        this.authCode = authCode;
    }

    /**
     * @param scope
     */
    public void setScope(String scope) {

        this.scope = scope;
    }

    /**
     * @param grantType
     */
    public void setGrantType(String grantType) {

        this.grantType = grantType;
    }
}
