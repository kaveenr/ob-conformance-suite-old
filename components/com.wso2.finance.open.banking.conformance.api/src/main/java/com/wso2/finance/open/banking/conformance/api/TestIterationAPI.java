///*
// * Copyright (c) 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
// *
// * WSO2 Inc. licenses this file to you under the Apache License,
// * Version 2.0 (the "License"); you may not use this file except
// * in compliance with the License.
// * You may obtain a copy of the License at
// *
// * http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing,
// * software distributed under the License is distributed on an
// * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// * KIND, either express or implied.  See the License for the
// * specific language governing permissions and limitations
// * under the License.
// */
//
//package com.wso2.finance.open.banking.conformance.api;
//
//
//import javax.ws.rs.GET;
//import javax.ws.rs.OPTIONS;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.QueryParam;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//
//import com.google.gson.JsonObject;
//import com.wso2.finance.open.banking.conformance.api.dao.TestPlanDAO;
//import com.wso2.finance.open.banking.conformance.api.dao.impl.TestPlanDAOImpl;
//import com.wso2.finance.open.banking.conformance.api.dto.TestPlanAddConfirmationDTO;
//import com.wso2.finance.open.banking.conformance.api.dto.TestPlanAddDTO;
//import com.wso2.finance.open.banking.conformance.api.dto.TestPlanDTO;
//import com.wso2.finance.open.banking.conformance.mgt.testconfig.TestPlan;
//import com.wso2.finance.open.banking.conformance.test.core.runner.TestPlanFeatureResult;
//import com.wso2.finance.open.banking.conformance.test.core.runner.TestPlanRunnerManager;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * This is the Microservice resource class.
// * See <a href="https://github.com/wso2/msf4j#getting-started">https://github.com/wso2/msf4j#getting-started</a>
// * for the usage of annotations.
// *
// * @since 1.0.0-SNAPSHOT
// */
//@Path("/testplan/iteration")
//public class TestIterationAPI {
//
//    TestPlanRunnerManager runnerManager = ApplicationDataHolder.getInstance().getRunnerManager();
//    TestPlanDAO testPlanDAO = new TestPlanDAOImpl();
//
//    @POST
//    @Path("/add")
//    @Consumes("application/json")
//    @Produces("application/json")
//    public TestPlanAddConfirmationDTO addTestPlan(TestPlanAddDTO addDTO) {
//        TestPlan planWithId = this.testPlanDAO.addTestPlan(addDTO.testPlan);
//        if(addDTO.runNow){
//            //this.runnerManager.addPlan(planWithId);
//        }
//        return new TestPlanAddConfirmationDTO(planWithId,null);
//    }
//
//    @OPTIONS
//    @Path("/add")
//    public Response getOptionsRunTestPlan(){
//        return Response.status(Response.Status.OK).header("Access-Control-Allow-Methods","POST,OPTIONS").build();
//    }
//
//    @GET
//    @Path("/result/poll/{testId}")
//    @Produces("application/json")
//    public List<TestPlanFeatureResult> getCurrentResult(@PathParam("testId") String testId) {
//
//        return this.runnerManager.getResults(testId);
//    }
//
//    @GET
//    @Path("/result/complete/{testId}")
//    @Produces("application/json")
//    public Map<String, List<JsonObject>> getCompleteResult(@PathParam("testId") String testId) {
//
//        return this.runnerManager.getResultSet(testId);
//    }
//
//
//    @GET
//    @Path("/list/all")
//    @Produces("application/json")
//    public Map<String, TestPlanDTO> getAllTestPlans(){
//        Map<String, TestPlanDTO> results = new HashMap<>();
//        this.runnerManager.getAllTests().forEach(
//                (uuid, testPlan) -> results.put(uuid,new TestPlanDTO(uuid,testPlan,this.runnerManager.getStatus(uuid)))
//        );
//        return results;
//    }
//
//    @GET
//    @Path("/callback")
//    public Response processCallback(@QueryParam("code") String code){
//        this.runnerManager.setContextAttribute("auth_code",code);
//        return Response.ok().type(MediaType.TEXT_HTML).entity("Done").build();
//    }
//
//}
