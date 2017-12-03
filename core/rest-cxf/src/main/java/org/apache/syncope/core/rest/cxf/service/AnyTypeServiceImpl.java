/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.syncope.core.rest.cxf.service;

import java.net.URI;
import java.util.List;
import javax.ws.rs.core.Response;
import org.apache.syncope.common.lib.to.AnyTypeTO;
import org.apache.syncope.common.rest.api.RESTHeaders;
import org.apache.syncope.common.rest.api.service.AnyTypeService;
import org.apache.syncope.core.logic.AnyTypeLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnyTypeServiceImpl extends AbstractServiceImpl implements AnyTypeService {

    @Autowired
    private AnyTypeLogic logic;

    @Override
    public List<AnyTypeTO> list() {
        return logic.list();
    }

    @Override
    public AnyTypeTO read(final String key) {
        return logic.read(key);
    }

    @Override
    public Response create(final AnyTypeTO anyTypeTO) {
        AnyTypeTO created = logic.create(anyTypeTO);
        URI location = uriInfo.getAbsolutePathBuilder().path(String.valueOf(created.getKey())).build();
        return Response.created(location).
                header(RESTHeaders.RESOURCE_KEY, created.getKey()).
                build();
    }

    @Override
    public void update(final AnyTypeTO anyTypeTO) {
        logic.update(anyTypeTO);
    }

    @Override
    public void delete(final String key) {
        logic.delete(key);
    }

}
