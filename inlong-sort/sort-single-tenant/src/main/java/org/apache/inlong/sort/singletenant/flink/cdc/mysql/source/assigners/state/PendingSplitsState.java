/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.inlong.sort.singletenant.flink.cdc.mysql.source.assigners.state;

import javax.annotation.Nullable;

/**
 * A checkpoint of the current state of the containing the currently pending splits that are not yet
 * assigned.
 */
public abstract class PendingSplitsState {
    /**
     * The splits are frequently serialized into checkpoints. Caching the byte representation makes
     * repeated serialization cheap. This field is used by {@link PendingSplitsStateSerializer}.
     */
    @Nullable transient byte[] serializedFormCache;
}
