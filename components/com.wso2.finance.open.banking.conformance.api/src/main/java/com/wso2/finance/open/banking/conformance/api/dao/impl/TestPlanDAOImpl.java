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

package com.wso2.finance.open.banking.conformance.api.dao.impl;

import com.wso2.finance.open.banking.conformance.api.dao.TestPlanDAO;
import com.wso2.finance.open.banking.conformance.mgt.testconfig.TestPlan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestPlanDAOImpl implements TestPlanDAO {

    public static Map<Integer, TestPlan> testplanStore = new HashMap<>();
    public static int id_count = 0;

    @Override
    public TestPlan addTestPlan(TestPlan testPlan) {

        Integer id = TestPlanDAOImpl.id_count++;
        testPlan.setId(id);
        TestPlanDAOImpl.testplanStore.put(id, testPlan);
        return testPlan;
    }

    @Override
    public void removeTestPlan(Integer id) {

        TestPlanDAOImpl.testplanStore.remove(id);
    }

    @Override
    public void updateTestPlan(TestPlan testPlan, Integer id) {

        TestPlanDAOImpl.testplanStore.put(id, testPlan);
    }

    @Override
    public TestPlan getTestPlan(Integer id) {

        return TestPlanDAOImpl.testplanStore.get(id);
    }

    @Override
    public List<TestPlan> getTestPlans() {

        return new ArrayList<TestPlan>(TestPlanDAOImpl.testplanStore.values());
    }
}
