package controllers


import models.{PopularDiscount, SortedProductInfo}
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.functions.{lower}

object SparkAnalysis {
  val fieldSchema = StructType(Array(
    StructField("URL", StringType, true),
    StructField("Discount", StringType, true),
    StructField("Platform", StringType, true),
    StructField("Title", StringType, true),
    StructField("DiscountedPrice", StringType, true),
    StructField("OriginalPrice", StringType, true),
    StructField("Category", StringType, true),
    StructField("Favorites", IntegerType, true),
    StructField("Shares", IntegerType, true),
    StructField("Comments", IntegerType, true)
  ))


  val conf = new SparkConf()
  conf.setAppName("SparkReadFile")
  conf.setMaster("local")
  val sparkContext = new SparkContext(conf)
  val sqlContext = new SQLContext(sparkContext)
  val discountDF = sqlContext.read.format("com.databricks.spark.csv")
    .option("header", "true")
    .schema(fieldSchema)
    .load("Discounted_Product_Information.csv")
    .distinct()
  discountDF.show()

  def mostPopularDiscount(categoryInput:String, matrix:String): List[PopularDiscount] ={
    var popularDiscountList = List[PopularDiscount]()
    val mostPopular = discountDF.where(discountDF("Category").===(categoryInput))
      .orderBy(discountDF(matrix).desc)
      .select("Discount","Platform")
      .distinct()
      //.dropDuplicates("user","type") according to typical column
      .limit(10)

    for(row <- mostPopular.rdd.collect()){
      var discount = row.mkString(",").split(",")(0)
      var platform = row.mkString(",").split(",")(1)
      val popularDiscount = PopularDiscount.apply(discount,platform)
      popularDiscountList = popularDiscount :: popularDiscountList
    }
    popularDiscountList
  }

  def sortDiscountInfo(keyword:String,categoryInput:String): List[SortedProductInfo] ={
    println("Keyword: " + keyword)
    val newKeyword = keyword.replace(" ", " ")
    // This is a hole my dear TA
    println(" ".equals(" "))
    var sortedProductList = List[SortedProductInfo]()
    val discountInfo = discountDF.filter(discountDF("Title").contains(newKeyword))
      .where(discountDF("Category").===(categoryInput))
      .orderBy(discountDF("DiscountedPrice").asc)
      .select("Title","DiscountedPrice","OriginalPrice","Platform")

    discountInfo.show()

    for(row <- discountInfo.rdd.collect()){
      var title = row.mkString(",").split(",")(0)
      var discountedPrice = row.mkString(",").split(",")(1)
      var originalPrice = row.mkString(",").split(",")(2)
      var platform = row.mkString(",").split(",")(3)
      val sortedProduct = SortedProductInfo.apply(title,discountedPrice,originalPrice,platform)
      sortedProductList = sortedProduct :: sortedProductList
    }
    sortedProductList
  }

  def firstFivePlatformOfCategory(categoryInput:String): List[(Any,Any)] ={
    var firstFivePlatformList = List[(Any,Any)]()
    val firstFivePlatform = discountDF.where(discountDF("Category").===(categoryInput))
      .dropDuplicates("URL")
      .select("Platform","Favorites")
      .groupBy("Platform")
      .sum("Favorites")
      .orderBy("sum(Favorites)")
      .collect().toList
      .reverse.take(5)

    for(row <- firstFivePlatform){
      var platform = row.mkString(",").split(",")(0)
      var favorites = row.mkString(",").split(",")(1)
      firstFivePlatformList = (platform,favorites) :: firstFivePlatformList
      println(firstFivePlatformList)
    }
    firstFivePlatformList
  }

  def platformCount(): List[(Any, Int)] ={
    val platformCount = discountDF.select("URL","Platform")
      .rdd.map(word => (word(1), 1))
      .reduceByKey((x,y) => x + y)
      .map(item => item.swap)
      .sortByKey(false, 1)
      .map(item => item.swap)

    platformCount.collect().toList.take(10)
  }

  def main(args: Array[String]): Unit = {
    //mostPopularDiscount("Beauty", "Favorites")
    //recommendation()
    firstFivePlatformOfCategory("Beauty")
  }
}
