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

package org.wso2.finance.open.banking.conformance.mgt.testconfig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * DTO representing the front end TestPlan object.
 */
public class TestPlan {

    private Map<String, Specification> specifications;
    private String testId;
    private String name;

    private Date lastRun = new Date();

    public TestPlan() {

    }

    public TestPlan(Map<String, Specification> specificationMap) {

        this.specifications = specificationMap;
    }

    public Specification getSpecification(String key) {

        return specifications.get(key);
    }

    public List<Specification> getSpecifications() {

        return Collections.unmodifiableList(new ArrayList<Specification>(specifications.values()));
    }

    public Date getLastRun() {

        return new Date(lastRun.getTime());
    }

    public void setLastRun(Date lastRun) {

        this.lastRun =  new Date(lastRun.getTime());
    }

    public String getTestId() {

        return testId;
    }

    public void setTestId(String testId) {

        this.testId = testId;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }
}
