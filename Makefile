JAR=build/libs/playground.wire-1.0-SNAPSHOT-all.jar

demo:
	gradle clean test shadowJar
	ls -lh $(JAR)
	java -jar $(JAR) arg1 arg2 arg3 arg4
