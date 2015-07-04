package org.kairosdb.client.builder;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.kairosdb.client.builder.aggregator.CustomAggregator;
import org.kairosdb.client.builder.aggregator.PercentileAggregator;
import org.kairosdb.client.builder.aggregator.RateAggregator;
import org.kairosdb.client.builder.aggregator.SamplingAggregator;

public class AggregatorFactoryTest
{
	@Test(expected = IllegalArgumentException.class)
	public void test_createDivAggregator_zero_divisor_invalid()
	{
		AggregatorFactory.createDivAggregator(0);
	}

	@Test
	public void test_createMinAggregator()
	{
		SamplingAggregator minAggregator = AggregatorFactory.createMinAggregator(1, TimeUnit.MINUTES);

		assertThat(minAggregator.getName(), equalTo("min"));
		assertThat(minAggregator.getValue(), equalTo(1));
		assertThat(minAggregator.getUnit(), equalTo(TimeUnit.MINUTES));
	}

	@Test
	public void test_createMaxAggregator()
	{
		SamplingAggregator minAggregator = AggregatorFactory.createMaxAggregator(1, TimeUnit.MINUTES);

		assertThat(minAggregator.getName(), equalTo("max"));
		assertThat(minAggregator.getValue(), equalTo(1));
		assertThat(minAggregator.getUnit(), equalTo(TimeUnit.MINUTES));
	}

	@Test
	public void test_createAverageAggregator()
	{
		SamplingAggregator aggregator = AggregatorFactory.createAverageAggregator(2, TimeUnit.YEARS);

		assertThat(aggregator.getName(), equalTo("avg"));
		assertThat(aggregator.getValue(), equalTo(2));
		assertThat(aggregator.getUnit(), equalTo(TimeUnit.YEARS));
	}

	@Test
	public void test_createStandardDeviationAggregator()
	{
		SamplingAggregator aggregator = AggregatorFactory.createStandardDeviationAggregator(3, TimeUnit.DAYS);

		assertThat(aggregator.getName(), equalTo("dev"));
		assertThat(aggregator.getValue(), equalTo(3));
		assertThat(aggregator.getUnit(), equalTo(TimeUnit.DAYS));
	}

	@Test
	public void test_createSumAggregator()
	{
		SamplingAggregator aggregator = AggregatorFactory.createSumAggregator(3, TimeUnit.DAYS);

		assertThat(aggregator.getName(), equalTo("sum"));
		assertThat(aggregator.getValue(), equalTo(3));
		assertThat(aggregator.getUnit(), equalTo(TimeUnit.DAYS));
	}

	@Test
	public void test_createCountAggregator()
	{
		SamplingAggregator aggregator = AggregatorFactory.createCountAggregator(3, TimeUnit.DAYS);

		assertThat(aggregator.getName(), equalTo("count"));
		assertThat(aggregator.getValue(), equalTo(3));
		assertThat(aggregator.getUnit(), equalTo(TimeUnit.DAYS));
	}
	
	@Test
	public void test_createPercentileAggregator()
	{
		PercentileAggregator aggregator = AggregatorFactory.createPercentileAggregator(0.5,3, TimeUnit.DAYS);

		assertThat(aggregator.getName(), equalTo("percentile"));
		assertThat(aggregator.getPercentile(),equalTo(0.5));
		assertThat(aggregator.getValue(), equalTo(3));
		assertThat(aggregator.getUnit(), equalTo(TimeUnit.DAYS));
	}

	@Test
	public void test_createRateAggregator()
	{
		RateAggregator aggregator = AggregatorFactory.createRateAggregator(TimeUnit.DAYS);

		assertThat(aggregator.getName(), equalTo("rate"));
		assertThat(aggregator.getUnit(), equalTo(TimeUnit.DAYS));
	}

	@Test
	public void test_createCustomAggregator()
	{
		CustomAggregator aggregator = AggregatorFactory.createCustomAggregator("foobar", "\"foo\": 10");

		assertThat(aggregator.getName(), equalTo("foobar"));
		assertThat(aggregator.toJson(), equalTo("{\"name\":\"foobar\",\"foo\": 10}"));
	}

	@Test
	public void test_createDivAggregator()
	{
		CustomAggregator aggregator = AggregatorFactory.createDivAggregator(60);

		assertThat(aggregator.getName(), equalTo("div"));
		assertThat(aggregator.toJson(), equalTo("{\"name\":\"div\",\"divisor\":60.0}"));
	}

}
