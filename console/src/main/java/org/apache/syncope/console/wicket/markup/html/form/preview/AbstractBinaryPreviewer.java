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
package org.apache.syncope.console.wicket.markup.html.form.preview;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractBinaryPreviewer extends Panel {

    protected static final Logger LOG = LoggerFactory.getLogger(AbstractBinaryPreviewer.class);

    private static final long serialVersionUID = -2482706463911903025L;

    protected final String mimeType;

    protected final byte[] uploadedBytes;

    public AbstractBinaryPreviewer(final String id, final String mimeType, final byte[] uploadedBytes) {
        super(id);
        this.mimeType = mimeType;
        this.uploadedBytes = uploadedBytes;
    }

    public abstract Component preview();
}
