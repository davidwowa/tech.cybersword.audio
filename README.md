# tech.cybersword.audio  

Tool for media(mp3,wav,ogg,aiff) files generation with injected payloads.  

# Maven build  
`~/java_env/maven/bin/mvn archetype:generate -DgroupId=tech.cybersword -DartifactId=tech.cybersword.audio -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false`  
# build  
`~/java_env/maven/bin/mvn clean package`  
# run  
`~/java_env/jdk/Contents/Home/bin/java -jar target/tech.cybersword.audio-1.0-SNAPSHOT.jar`  

`~/java_env/maven/bin/mvn clean package | ~/java_env/jdk/Contents/Home/bin/java -jar target/tech.cybersword.audio-1.0-SNAPSHOT.jar pentest1234 /Users/David/sandbox/pics/ /Users/David/git/tech.cybersword.audio/ payloads false true false`  

# scp  
`scp /lokaler/pfad/ benutzer@192.168.1.5:/home/benutzer/dokument.txt`  

# show last bytes from files  
`tail -c 40 *`  

# payloads  

- https://github.com/davidwowa/tech.cybersword.payloads

# diff between files  
`diff file1 file2 --text`
