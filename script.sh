tomcat_path=$1
find src/ -name "*.java" > classes
mkdir -p anton-stock-feed-servlet/WEB-INF/classes
mkdir -p anton-stock-feed-servlet/WEB-INF/lib
javac -d anton-stock-feed-servlet/WEB-INF/classes -cp "additional libraries/servlet-api.jar;additional libraries/gson-2.8.7.jar;" -sourcepath  "src/" @classes
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
tomcat_webapps_path="$tomcat_path/webapps"
cp $war_file_name "$tomcat_webapps_path"
catalina_properties_path="$tomcat_path/conf"
echo $catalina_properties_path
cd "$catalina_properties_path"
echo "">>catalina.properties
echo "DAO=Database">>catalina.properties
echo "">>catalina.properties
echo "ProfileService=Database">>catalina.properties
echo "">>catalina.properties
echo "JsonSerialize=Gson">>catalina.properties
echo "">>catalina.properties
echo "APIService=StandardHTTP">>catalina.properties