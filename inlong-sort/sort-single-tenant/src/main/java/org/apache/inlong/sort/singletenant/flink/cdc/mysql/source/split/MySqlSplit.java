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

package org.apache.inlong.sort.singletenant.flink.cdc.mysql.source.split;

import io.debezium.relational.TableId;
import io.debezium.relational.history.TableChanges;
import java.util.Map;
import java.util.Objects;
import org.apache.flink.api.connector.source.SourceSplit;

/** The split of table comes from a Table that splits by primary key. */
public abstract class MySqlSplit implements SourceSplit {

    protected final String splitId;

    public MySqlSplit(String splitId) {
        this.splitId = splitId;
    }

    /** Checks whether this split is a snapshot split. */
    public final boolean isSnapshotSplit() {
        return getClass() == MySqlSnapshotSplit.class;
    }

    /** Checks whether this split is a binlog split. */
    public final boolean isBinlogSplit() {
        return getClass() == MySqlBinlogSplit.class;
    }

    /** Casts this split into a {@link MySqlSnapshotSplit}. */
    public final MySqlSnapshotSplit asSnapshotSplit() {
        return (MySqlSnapshotSplit) this;
    }

    /** Casts this split into a {@link MySqlBinlogSplit}. */
    public final MySqlBinlogSplit asBinlogSplit() {
        return (MySqlBinlogSplit) this;
    }

    @Override
    public String splitId() {
        return splitId;
    }

    public abstract Map<TableId, TableChanges.TableChange> getTableSchemas();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MySqlSplit that = (MySqlSplit) o;
        return Objects.equals(splitId, that.splitId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(splitId);
    }
}
