## 项目收获
1. 将 DBUtils 用于实践
2. 通过将架构分层, 使得项目的结构更加清晰明了
3. 明确了各层的责任
   1. DAO 只进行与数据库的交互, 接收参数、执行 SQL 语句, 不进行数据的处理
   2. service 进行参数校验、数据类型转换、业务功能
   3. servlet 负责接收请求、调用 service 处理任务、异常处理、响应结果
4. 完全抛弃 JSP, 采用 json 数据进行请求的响应, 探索前后端分离的最佳实践
5. 体验 lay-table 的异步数据加载, 及其功能的交互

## QA
### 配置 Tomcat 后无法正常启动
在 IDEA 中打开 `Project Structure..` 并在 `Facets` -> `Source Roots` 中勾选 src 和 resources 目录

### 页面乱码
1. 在 `Run/Debug Configurations` 中 Tomcat 的 `VM options` 中填入: `-Dfile.encoding=utf-8`
2. 打开网页, `Ctrl` + `F5` 强制刷新页面

### 控制台乱码
1. 在 IDEA `Settings` -> `Editor` -> `File Encodings` 中统一编码为 `UTF-8`&`with NO BOM`
2. 在 IDEA `Help` -> `Edit Custom VM Options` 中配置 `-Dfile.encoding=utf-8`
3. 重启 IDEA

### 无法登录
1. 检查数据库配置是否正确, 且导入了 [表结构 SQL 文件](./resources/book&user.sql)
2. 如果 Tomcat 设置了虚拟目录, 请将 [API_URL](./web/static/config.js#L1) 填写正确