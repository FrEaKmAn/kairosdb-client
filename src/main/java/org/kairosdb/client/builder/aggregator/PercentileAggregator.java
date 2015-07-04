/*
 * Copyright 2013 Proofpoint Inc.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.kairosdb.client.builder.aggregator;

import static com.google.common.base.Preconditions.checkArgument;

import org.kairosdb.client.builder.TimeUnit;

public class PercentileAggregator extends SamplingAggregator
{
	private double percentile;

	public PercentileAggregator(double percentile, int value, TimeUnit unit)
	{
		super("percentile", value, unit);
		
		checkArgument(percentile >= 0, "value must be greater than or equal to 0.");
		checkArgument(percentile <= 1, "value must be less than or equal to 1.");
		
		this.percentile = percentile;

	}

	public double getPercentile()
	{
		return percentile;
	}

}