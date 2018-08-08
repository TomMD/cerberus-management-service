/*
 * Copyright (c) 2018 Nike, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nike.cerberus.aws.sts;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AwsStsClientTest {

    private AwsStsHttpClient httpClient;
    private AwsStsClient awsStsClient;
    private AwsStsHttpHeader awsStsHttpHeader;

    @Before
    public void setup() {
        httpClient = mock(AwsStsHttpClient.class);
        awsStsClient = new AwsStsClient(httpClient);
        awsStsHttpHeader = new AwsStsHttpHeader("test date", "test amz date",
                "test amz security token", "test authorization");
    }

    @Test
    public void test_createSessionLoginToken() {

        setupMocks();

        GetCallerIdentityFullResponse response = mock(GetCallerIdentityFullResponse.class);

        when(httpClient.execute(awsStsHttpHeader.generateHeaders(), GetCallerIdentityFullResponse.class))
                .thenReturn(response);

        // invoke method under test
        GetCallerIdentityResponse actualResponse = awsStsClient.getCallerIdentity(awsStsHttpHeader);

        assertEquals(response.getGetCallerIdentityResponse(), actualResponse);
    }

    private void setupMocks() {

        GetCallerIdentityFullResponse response = new GetCallerIdentityFullResponse();

        when(httpClient.execute(awsStsHttpHeader.generateHeaders(), GetCallerIdentityFullResponse.class))
                .thenReturn(response);
    }
}