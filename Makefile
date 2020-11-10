JAR=build/libs/playground.wire-1.0-SNAPSHOT-all.jar

demo:
	gradle clean shadowJar
	ls -lh $(JAR)
	java -jar $(JAR) makefileArgument1 makefileArgument2 makefileArgument3
