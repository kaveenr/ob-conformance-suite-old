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

package org.wso2.finance.open.banking.conformance.api.services;

import org.wso2.finance.open.banking.conformance.api.dao.SpecificationDAO;
import org.wso2.finance.open.banking.conformance.api.dto.BasicSpecificationDTO;
import org.wso2.finance.open.banking.conformance.mgt.models.Specification;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Microservice for managing Specifications.
 */
@Path("/specifications")
public class SpecificationAPI {

    private SpecificationDAO specificationDAO = new SpecificationDAO();

    /**
     * Return all BasicSpecifications.
     *
     * @return List of basic specifications.
     */
    @GET
    @Path("/")
    @Produces("application/json")
    public List<BasicSpecificationDTO> get() {

        return specificationDAO.getBasicSpecifications();
    }

    /**
     * Return a single complete Specification bny name.
     *
     * @param name name of the specification.
     * @return single Specification.
     */
    @GET
    @Path("/{name}")
    @Produces("application/json")
    public Specification getSpecification(@PathParam("name") String name) {

        return specificationDAO.getSpecification(name);
    }
}
