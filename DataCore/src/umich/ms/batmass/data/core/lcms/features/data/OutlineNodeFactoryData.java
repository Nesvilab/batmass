/* 
 * Copyright 2016 Dmitry Avtonomov.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package umich.ms.batmass.data.core.lcms.features.data;

import org.openide.nodes.ChildFactory;
import umich.ms.batmass.data.core.api.DataContainer;
import umich.ms.batmass.data.core.api.DataSource;

/**
 * A marker class that should be extended to provide
 * @author Dmitry Avtonomov
 * @param <T>
 */
public abstract class OutlineNodeFactoryData<T> extends DataContainer<T> {

    public OutlineNodeFactoryData(DataSource<T> source) {
        super(source);
    }

    public abstract ChildFactory<?> create();
}
