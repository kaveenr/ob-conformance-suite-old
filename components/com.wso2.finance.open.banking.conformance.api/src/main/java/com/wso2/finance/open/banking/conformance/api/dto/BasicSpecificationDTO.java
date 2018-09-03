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

package com.wso2.finance.open.banking.conformance.api.dto;

/**
 * DTO for Specification
 */
public class BasicSpecificationDTO {

    public String name;
    public String title;
    public String version;
    public String description;
    public String specificationUri;

    /**
     * @param name
     * @param title
     * @param version
     * @param description
     * @param specificationUri
     */
    public BasicSpecificationDTO(String name, String title, String version, String description,
                                 String specificationUri) {

        this.name = name;
        this.title = title;
        this.version = version;
        this.description = description;
        this.specificationUri = specificationUri;
    }
}
