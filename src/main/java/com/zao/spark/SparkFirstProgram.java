package com.zao.spark;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;

public class SparkFirstProgram {

	public static void main(String[] args) {
		try (final var spark = SparkSession.builder()
			 	.appName("SparkFirstProgram")
				.master("local[*]")
				.getOrCreate();
				final var sc = new JavaSparkContext(spark.sparkContext())) {
			final var data = Stream.iterate(1, n -> n + 1)
					.limit(5)
					.collect(Collectors.toList());
			final var myRdd = sc.parallelize(data);
			System.out.printf("Total elements in RDD: %d%n", myRdd.count());

		}
	}

}
