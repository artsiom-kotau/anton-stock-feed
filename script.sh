find src/ -name "*.java" > classes
mkdir -p anton-stock-feed-servlet/WEB-INF/classes
mkdir -p anton-stock-feed-servlet/WEB-INF/lib
javac -d anton-stock-feed-servlet/WEB-INF/classes -cp "C:/Users/Anton/Documents/Java projects/Stock Feed/anton-stock-feed/additional libraries/servlet-api.jar;C:/Users/Anton/Documents/Java projects/Stock Feed/anton-stock-feed/additional libraries/gson-2.8.7.jar;" -sourcepath  "src/" @classes
cp "additional libraries/gson-2.8.7.jar" "anton-stock-feed-servlet/WEB-INF/lib"
cp "additional libraries/servlet-api.jar" "anton-stock-feed-servlet/WEB-INF/lib"
cp "additional libraries/postgresql-42.2.22.jar" "anton-stock-feed-servlet/WEB-INF/lib"
web_xml_path=$(find src/ -name "web.xml")
echo $web_xml_path
cp $web_xml_path anton-stock-feed-servlet/WEB-INF/web.xml
cd anton-stock-feed-servlet/
jar -cvf anton-stock-feed-servlet.war *
war_file_name=$(find . -name "*.war")
echo $war_file_name
cp $war_file_name "C:\Program Files\apache-tomcat-9.0.48-windows-x64\apache-tomcat-9.0.48\webapps"