/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.inlong.manager.common.pojo.dataproxy;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import java.util.List;
import lombok.Data;

@Data
@ApiModel("DataProxy IP response param")
public class DataProxyIpResponse {

    private String businessId;
    private int clusterId;
    private int size;
    private int load;
    private int isInterVisit;
    private String netTag;
    @SerializedName("switch")
    @JsonProperty("switch")
    private int switchX;
    private List<AddressBean> address;

    public static class AddressBean {

        private String port;
        private String host;
        private Integer id;
        private String netTag;

        public String getPort() {
            return port;
        }

        public void setPort(String port) {
            this.port = port;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNetTag() {
            return netTag;
        }

        public void setNetTag(String netTag) {
            this.netTag = netTag;
        }
    }
}