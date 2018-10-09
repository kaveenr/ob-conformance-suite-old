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

package org.wso2.finance.open.banking.conformance.test.core.utilities;

/**
 * Class that provides utility functions.
 */
public class Utils {

    /**
     * This method appends a prefix and suffix to the error msg.
     * This prefix and suffix can be used in regex patters to capture the error from the cucumber test results
     * @param error
     * @return error string wrapped with a prefix and suffix
     */
    public static String formatError(String error) {

        return "StartError " + error + "EndError";
    }

}
