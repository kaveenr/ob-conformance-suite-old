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

package com.wso2.finance.open.banking.conformance.test.core.runner;

import com.google.gson.JsonObject;
import com.wso2.finance.open.banking.conformance.mgt.testconfig.TestIteration;
import com.wso2.finance.open.banking.conformance.mgt.testconfig.TestPlan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TestPlanRunnerManager {

    private Map<Integer,BlockingQueue<TestPlanFeatureResult>> resultQueueMap = new HashMap();
    private Map<Integer,TestPlanRunnerInstance> runnerInstanceMap = new HashMap();

    public void addPlan(Integer testId, TestPlan testPlan){
        this.resultQueueMap.put(testId, new ArrayBlockingQueue(50));
        this.runnerInstanceMap.put(testId, new TestPlanRunnerInstance(testPlan,this.resultQueueMap.get(testId)));
    }

    public List<TestPlanFeatureResult> getResults(Integer id){
        if (this.runnerInstanceMap.containsKey(id)){
            List<TestPlanFeatureResult> results = new ArrayList();
            this.resultQueueMap.get(id).drainTo(results);
            return results;
        }else{
            return null;
        }
    }

    public TestIteration.RUNNER_STATE getStatus(Integer id){
        return this.runnerInstanceMap.get(id).getStatus();
    }

    public Map<String, List<JsonObject>> getResultSet(String uuid){
        return this.runnerInstanceMap.get(uuid).getFormattedResult();
    }

    public void start(String uuid){
        //Only one test can run now
        //TODO: block more than one running
        this.runnerInstanceMap.get(uuid).start();
    }

    public void setContextAttribute(String key, String value){
        for(TestPlanRunnerInstance instance : this.runnerInstanceMap.values()){
            if(instance.getStatus() == TestIteration.RUNNER_STATE.WAITING){
                instance.setContextAttributes(key,value);
            }
        }
    }
}
