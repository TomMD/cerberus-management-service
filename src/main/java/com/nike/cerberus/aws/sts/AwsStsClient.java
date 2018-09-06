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

import com.google.inject.Singleton;

import javax.inject.Inject;

/**
 * Client for calling AWS STS APIs
 */
@Singleton
public class AwsStsClient {
    private final AwsStsHttpClient httpClient;

    @Inject
    public AwsStsClient(AwsStsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public GetCallerIdentityResponse getCallerIdentity(AwsStsHttpHeader header) {
        GetCallerIdentityFullResponse response = httpClient.execute(header.generateHeaders(), GetCallerIdentityFullResponse.class);
        return response.getGetCallerIdentityResponse();
    }
}
