echo '请输入bintrayKey：'
read bintrayKey
./gradlew clean build bintrayUpload  -PbintrayApiKey=$bintrayKey