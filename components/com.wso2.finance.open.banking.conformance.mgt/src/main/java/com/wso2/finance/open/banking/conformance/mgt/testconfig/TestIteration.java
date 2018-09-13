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

package com.wso2.finance.open.banking.conformance.mgt.testconfig;

import com.google.gson.JsonObject;

import java.util.List;
import java.util.Map;

public class TestIteration {

    public enum RUNNER_STATE {
        RUNNING, DONE, NOT_STARTED, WAITING
    }

    private Integer id;
    private Integer testPlanId;
    private Map<String, List<JsonObject>> results;
    private RUNNER_STATE iterationState;

    public TestIteration(Integer testPlanId) {

        this.testPlanId = testPlanId;
    }

    public TestIteration(Integer id, Integer testPlanId) {

        this.id = id;
        this.testPlanId = testPlanId;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public Integer getTestPlanId() {

        return testPlanId;
    }

    public void setTestPlanId(Integer testPlanId) {

        this.testPlanId = testPlanId;
    }

    public Map<String, List<JsonObject>> getResults() {

        return results;
    }

    public void setResults(Map<String, List<JsonObject>> results) {

        this.results = results;
    }

    public RUNNER_STATE getIterationState() {

        return iterationState;
    }

    public void setIterationState(RUNNER_STATE iterationState) {

        this.iterationState = iterationState;
    }
}
