#!/usr/bin/env bash

if [[ $1 == "-p" ]]; then
  deployPath=/home/admin/wxpusher/wxpusher-demo/
  server=115.28.141.240
  echo "部署生成环境"
else
  deployPath=/data/app/wxpusher-test/wxpusher-demo/
  server=101.37.14.29
  echo "部署测试环境"
fi

cd ..
./gradlew demo:clean demo:assemble
cd demo

jarPath=`find build/libs/demo-*.jar`
echo "输出文件：${jarPath}"
jarName=${jarPath##*/}


ssh admin@${server} "
if [ ! -d ${deployPath} ]; then
    echo  "文件夹不存在，创建文件夹"
    mkdir ${deployPath}
fi
cd ${deployPath}
if [ -f ${jarName} ]; then
  # 存在文件，先杀死进程
  echo 杀死进程...
  /usr/sbin/lsof -t -i:7002|xargs kill
  rm ${jarName}
  echo 删除文件...
fi
"

echo "上传文件:${jarPath}"
scp ${jarPath} admin@${server}:${deployPath}${jarName}
echo "上传完成"

echo "重启服务"
ssh admin@${server} "
cd ${deployPath}
/usr/sbin/lsof -t -i:7002|xargs kill
nohup java -jar ${jarName} -Xmx250m -Xms250m 2>error.log 1>info.log &
#java -jar ${jarName}
"
echo "部署完成"
