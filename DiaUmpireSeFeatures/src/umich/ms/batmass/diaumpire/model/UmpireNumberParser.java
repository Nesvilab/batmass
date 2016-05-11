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
package umich.ms.batmass.diaumpire.model;

import umich.ms.batmass.filesupport.core.util.DelimitedFiles;

/**
 *
 * @author Dmitry Avtonomov
 */
public class UmpireNumberParser extends DelimitedFiles.NumberParsingDelegate {
    protected UmpireIsoCluster cluster;
    protected int[] colMapping;

    public UmpireNumberParser(int[] colMapping) {
        cluster = new UmpireIsoCluster();
        this.colMapping = colMapping;
    }
    
    @Override
    public void parse(int idx, int number, int length, int decimalPos) {
        int mapping = colMapping[idx];
        switch (idx) {
            case 0:
                cluster.setRtLo(DelimitedFiles.parseDouble(number, length, decimalPos));
                break;
            case 1:
                cluster.setRtHi(DelimitedFiles.parseDouble(number, length, decimalPos));
                break;
            case 2:
                cluster.setScanNumLo(DelimitedFiles.parseInt(number, length, decimalPos));
                break;
            case 3: 
                cluster.setScanNumHi(DelimitedFiles.parseInt(number, length, decimalPos));
                break;
            case 4:
                cluster.setCharge(DelimitedFiles.parseInt(number, length, decimalPos));
                break;
            case 5:
                cluster.setMz1(DelimitedFiles.parseDouble(number, length, decimalPos));
                break;
            case 6:
                cluster.setMz2(DelimitedFiles.parseDouble(number, length, decimalPos));
                break;
            case 7: 
                cluster.setMz3(DelimitedFiles.parseDouble(number, length, decimalPos));
                break;
            case 8:
                cluster.setMz4(DelimitedFiles.parseDouble(number, length, decimalPos));
                break;
            case 9:
                cluster.setPeakHeight(DelimitedFiles.parseDouble(number, length, decimalPos));
                break;
            case 10:
                cluster.setPeakArea(DelimitedFiles.parseDouble(number, length, decimalPos));
                break;
        }
    }
}
