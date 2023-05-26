import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

object CounterDemo {
	def main(args: Array[String]): Unit = {
		val conf = new SparkConf().setAppName("lab10").setMaster("local[*]")
		val sc = new SparkContext(conf);
		val spark = SparkSession.builder.appName("lab10").getOrCreate()
		val df = spark.read.format("com.databricks.spark.csv").option("header",true).load("russian_air_service_CARGO_AND_PARCELS.csv")
		df.createOrReplaceTempView("air")

		spark.sql("select * from air").show()
		spark.sql("select count(*) from air").show()
		spark.sql("select count(*) from air group by `Airport name`").show()
		spark.sql("select distinct `Airport name` from air where `Airport name` like '%Moscow%'").show()
		spark.sql("select * from air where `Airport name` like '%Sheremetyevo%'").show()
		spark.sql("select Year, sum(January), sum(February), sum(March), sum(April), sum(May), sum(June), sum(July), sum(August), sum(September), sum(October), sum(November), sum(December)  from air where `Airport name` like '%Sheremetyevo%' group by Year").show()
		spark.sql("select `Airport name`, Year, `Whole year` from air where Year = 2019 order by cast(`Whole year` as int) desc").show()
		spark.sql("select `Airport name`, substring_index(substring_index(`Airport coordinates`, ',', 1), '(', -1) as Latitude, substring_index(substring_index(`Airport coordinates`, ',', -1), ')', 1) as Longitude from airports;").show()
		spark.sql("select a1.`Airport name`, a1.`Whole year` as PassengerTraffic_Year1, a2.`Whole year` as PassengerTraffic_Year2, (a2.`Whole year` - a1.`Whole year`) as TrafficGrowth from airports as a1 join airports as a2 on a1.`Airport name` = a2.`Airport name` where a1.Year = 2018 and a2.Year = 2019 order by TrafficGrowth desc").show()
		spark.sql("SELECT Month, AVG(January) AS Avg_January, AVG(February) AS Avg_February, AVG(March) AS Avg_March, AVG(April) AS Avg_April, AVG(May) AS Avg_May, AVG(June) AS Avg_June, AVG(July) AS Avg_July, AVG(August) AS Avg_August, AVG(September) AS Avg_September, AVG(October) AS Avg_October, AVG(November) AS Avg_November, AVG(December) AS Avg_December FROM ( SELECT 'January' AS Month, January FROM airports UNION ALL SELECT 'February' AS Month, February FROM airports UNION ALL SELECT 'March' AS Month, March FROM airports UNION ALL SELECT 'April' AS Month, April FROM airports UNION ALL SELECT 'May' AS Month, May FROM airports UNION ALL SELECT 'June' AS Month, June FROM airports UNION ALL SELECT 'July' AS Month, July FROM airports UNION ALL SELECT 'August' AS Month, August FROM airports UNION ALL SELECT 'September' AS Month, September FROM airports UNION ALL SELECT 'October' AS Month, October FROM airports UNION ALL SELECT 'November' AS Month, November FROM airports UNION ALL SELECT 'December' AS Month, December FROM airports ) AS subquery GROUP BY Month").show()
	}
}
