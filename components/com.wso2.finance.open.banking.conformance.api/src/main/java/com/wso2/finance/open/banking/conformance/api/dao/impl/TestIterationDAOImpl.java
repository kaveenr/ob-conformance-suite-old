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

import com.wso2.finance.open.banking.conformance.api.dao.TestIterationDAO;
import com.wso2.finance.open.banking.conformance.mgt.testconfig.TestIteration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestIterationDAOImpl implements TestIterationDAO {

    private static Map<Integer, Map<Integer, TestIteration>> testIterationMap = new HashMap<>();
    private static Integer id_count = 0;

    @Override
    public TestIteration addTestIterationDAO(TestIteration testIteration) {

        Integer id = TestIterationDAOImpl.id_count++;
        testIteration.setId(id);

        if (TestIterationDAOImpl.testIterationMap.get(testIteration.getTestPlanId()) == null) {
            TestIterationDAOImpl.testIterationMap.put(testIteration.getTestPlanId(), new HashMap<>());
        }

        TestIterationDAOImpl.testIterationMap.get(testIteration.getTestPlanId()).put(id, testIteration);

        return testIteration;
    }

    @Override
    public List<TestIteration> getTestIterations(Integer testPlanId) {

        return new ArrayList<>(TestIterationDAOImpl.testIterationMap.get(testPlanId).values());
    }

    @Override
    public TestIteration getTestIteration(Integer testPlanId, Integer iterationId) {

        return TestIterationDAOImpl.testIterationMap.get(testPlanId).get(iterationId);
    }

    @Override
    public void deleteTestIteration(Integer testPlanId, Integer iterationId) {

        TestIterationDAOImpl.testIterationMap.get(testPlanId).remove(iterationId);
    }
}
