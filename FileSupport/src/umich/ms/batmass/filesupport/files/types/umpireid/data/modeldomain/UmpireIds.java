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
package umich.ms.batmass.filesupport.files.types.umpireid.data.modeldomain;

/**
 * To be used as data-type for UmpireIdData container.
 * @author Dmitry Avtonomov
 */
public class UmpireIds {

    private final UmpireId[] ids;

    public UmpireIds(UmpireId[] ids) {
        this.ids = ids;
    }

    public UmpireId[] getIds() {
        return ids;
    }
}
