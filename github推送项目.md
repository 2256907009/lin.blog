# 				github推送项目

##### git init  当创建一个新的文件夹，可以使用git工具

##### git add . 可以添加所有项目文件

##### git add README.md 等可以添加特定的文件

##### git branch 可以查看所有的分支（前面带有*表示当前分支）

##### git checkout -b text 使用-d命令可以新建分支并切换到新建分支

##### git branch 新建分支名  可以新建分支

##### git checkout text 只进行切换分支

##### git commit -m "提交提示" 

##### git push origin main 提交到主分支 origin为仓库名称，mian可更改为其他分支

##### git branch -M main 在本地创建分支

理解：当我们新创建项目时可以使用git init 在新建目录中使用git工具，通过初始化，在使用

git branch -M main 创建本地的分支,再通过git remote add origin https://github.com/xxxxx/xxx.git将绑定远程

仓库，或者直接克隆下载仓库 git clone  https://github.com/xxxxx/xxx.git就不需要git init 初始化了，再通过选择 

你要发送的分支git checkout main ，在进行git commit -m "提交信息" ,最后 git push origin main 提交！