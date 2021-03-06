/*
 * Copyright (c) 2016 Nike, Inc.
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

package com.nike.cerberus.util;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.function.Supplier;

/**
 * Utility class for getting the current time in UTC.
 */
public class DateTimeSupplier implements Supplier<OffsetDateTime> {

    public final ZoneId UTC = ZoneId.of("UTC");

    @Override
    public OffsetDateTime get() {
        return OffsetDateTime.now(UTC);
    }
}
