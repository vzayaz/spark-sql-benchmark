This sbt project enables benchmarking of Spark APIs on simple tasks locally.

#### Prerequisites:

 - JDK 1.8+
 - Scala 2.11.12
 - SBT 1.2.7
 - Spark 2.4.6 
 
#### Building the project
 
 In pre project folder:
 ```bash
sbt assembly
 ```
 
#### Running with Spark locally
```bash
spark-submit --master "local[1]" --class example.CountWithDatasets target/scala-2.11/medium-spark-datasets-assembly-0.1.0-SNAPSHOT.jar
 ```