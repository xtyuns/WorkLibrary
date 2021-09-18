## QA
### 配置 Tomcat 后无法正常启动
在 IDEA 中打开 `Project Structure..` 并在 `Facets` -> `Source Roots` 中勾选 src 和 resources 目录

### 页面乱码
1. 在 `Run/Debug Configurations` 中 Tomcat 的 `VM options` 中填入: `-Dfile.encoding=utf-8`
2. 打开网页, `Ctrl` + `F5` 强制刷新页面

### 无法登录
1. 检查数据库配置是否正确, 且导入了 [表结构 SQL 文件](./resources/book&user.sql)
2. 如果 Tomcat 设置了虚拟目录, 请将 [API_URL](./web/static/config.js#L1) 填写正确