cd target
del *.jar
cd ..
mvn package && java -jar target/wrseg-1.0-SNAPSHOT.jar