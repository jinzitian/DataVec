/*-
 *  * Copyright 2016 Skymind, Inc.
 *  *
 *  *    Licensed under the Apache License, Version 2.0 (the "License");
 *  *    you may not use this file except in compliance with the License.
 *  *    You may obtain a copy of the License at
 *  *
 *  *        http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *    Unless required by applicable law or agreed to in writing, software
 *  *    distributed under the License is distributed on an "AS IS" BASIS,
 *  *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *    See the License for the specific language governing permissions and
 *  *    limitations under the License.
 */

package org.datavec.api.transform.sequence;

import org.nd4j.shade.jackson.annotation.JsonInclude;
import org.nd4j.shade.jackson.annotation.JsonSubTypes;
import org.nd4j.shade.jackson.annotation.JsonTypeInfo;
import org.datavec.api.transform.schema.Schema;
import org.datavec.api.transform.sequence.split.SequenceSplitTimeSeparation;
import org.datavec.api.transform.sequence.split.SplitMaxLengthSequence;
import org.datavec.api.writable.Writable;

import java.io.Serializable;
import java.util.List;

/**
 * SequenceSplit interface: used to split a single sequence into multiple smaller subsequences, according
 * to some criteria
 *
 * @author Alex Black
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonSubTypes(value = {
                @JsonSubTypes.Type(value = SequenceSplitTimeSeparation.class, name = "SequenceSplitTimeSeparation"),
                @JsonSubTypes.Type(value = SplitMaxLengthSequence.class, name = "SplitMaxLengthSequence")})
public interface SequenceSplit extends Serializable {

    List<List<List<Writable>>> split(List<List<Writable>> sequence);

    void setInputSchema(Schema inputSchema);

    Schema getInputSchema();

}
