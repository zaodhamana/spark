package com.zao.spark;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;

public class SparkFirstProgram {

	public static void main(String[] args) {
		try (final var spark = SparkSession.builder()
										   .appName("SparkFirstProgram")
										   .master("local[*]")
										   .getOrCreate();
				final var sc = new JavaSparkContext(spark.sparkContext())) {

		}
	}

}
