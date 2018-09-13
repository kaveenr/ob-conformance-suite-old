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

package com.wso2.finance.open.banking.conformance.api;

import com.google.gson.Gson;
import com.wso2.finance.open.banking.conformance.api.dao.TestPlanDAO;
import com.wso2.finance.open.banking.conformance.api.dao.impl.SpecificationDAOImpl;
import com.wso2.finance.open.banking.conformance.api.dao.impl.TestPlanDAOImpl;
import com.wso2.finance.open.banking.conformance.api.dto.TestPlanAddConfirmationDTO;
import com.wso2.finance.open.banking.conformance.api.dto.TestPlanAddDTO;
import com.wso2.finance.open.banking.conformance.mgt.testconfig.TestPlan;
import junit.framework.Test;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * This is the Microservice resource class.
 * See <a href="https://github.com/wso2/msf4j#getting-started">https://github.com/wso2/msf4j#getting-started</a>
 * for the usage of annotations.
 *
 * @since 1.0.0-SNAPSHOT
 */
@Path("/testplan")
public class TestPlanAPI {

    private TestPlanDAO testPlanDAO = new TestPlanDAOImpl();

    @GET
    @Path("/all")
    @Produces("application/json")
    public List<TestPlan> get() {

        return testPlanDAO.getTestPlans();
    }

    @GET
    @Path("/single/{id}")
    public TestPlan getSpecification(@PathParam("id") Integer id) {

        return testPlanDAO.getTestPlan(id);
    }

    @OPTIONS
    @Path("/add")
    public Response getOptionsRunTestPlan() {

        return Response
                .status(Response.Status.OK)
                .header("Access-Control-Allow-Methods", "POST,OPTIONS").build();
    }

    @POST
    @Path("/add")
    @Consumes("application/json")
    @Produces("application/json")
    public TestPlanAddConfirmationDTO addTestPlan(TestPlanAddDTO addDTO) {

        TestPlan planWithId = testPlanDAO.addTestPlan(addDTO.testPlan);
        //TODO add support for run now
        return new TestPlanAddConfirmationDTO(planWithId, null);
    }

}
