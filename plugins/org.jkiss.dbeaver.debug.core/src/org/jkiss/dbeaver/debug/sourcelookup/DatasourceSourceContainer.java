/*
 * DBeaver - Universal Database Manager
 * Copyright (C) 2010-2018 Serge Rider (serge@jkiss.org)
 * Copyright (C) 2017-2018 Alexander Fedorov (alexander.fedorov@jkiss.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jkiss.dbeaver.debug.sourcelookup;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.sourcelookup.ISourceContainer;
import org.eclipse.debug.core.sourcelookup.ISourceContainerType;
import org.eclipse.debug.core.sourcelookup.containers.CompositeSourceContainer;
import org.eclipse.osgi.util.NLS;
import org.jkiss.dbeaver.DBException;
import org.jkiss.dbeaver.core.DBeaverCore;
import org.jkiss.dbeaver.debug.core.DebugCore;
import org.jkiss.dbeaver.model.DBPDataSourceContainer;
import org.jkiss.dbeaver.model.navigator.DBNModel;
import org.jkiss.dbeaver.model.navigator.DBNNode;
import org.jkiss.dbeaver.model.runtime.VoidProgressMonitor;
import org.jkiss.dbeaver.registry.DataSourceDescriptor;

public class DatasourceSourceContainer extends CompositeSourceContainer {

    private final DBNModel navigatorModel = DBeaverCore.getInstance().getNavigatorModel();
    private final DBPDataSourceContainer datasource;
    private final IProject project;

    public DatasourceSourceContainer(DataSourceDescriptor descriptor) {
        this.datasource = descriptor;
        this.project = datasource.getRegistry().getProject();
    }

    @Override
    public String getName() {
        return datasource.getName();
    }

    @Override
    protected Object[] findSourceElements(String name, ISourceContainer[] containers) throws CoreException {
        DBNNode node;
        try {
            VoidProgressMonitor monitor = new VoidProgressMonitor();
            node = navigatorModel.getNodeByPath(monitor, project, name);
        } catch (DBException e) {
            String message = NLS.bind("Unable to extract node {0}", name);
            throw new CoreException(DebugCore.newErrorStatus(message, e));
        }
        if (node != null) {
            return new Object[] { node };
        }
        return super.findSourceElements(name, containers);
    }

    @Override
    public ISourceContainerType getType() {
        return getSourceContainerType(DebugCore.SOURCE_CONTAINER_TYPE_DATASOURCE);
    }

    @Override
    protected ISourceContainer[] createSourceContainers() throws CoreException {
        return new ISourceContainer[0];
    }

}
