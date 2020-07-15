# 阅读JDK源码项目



2020.07.14创建该项目，目的是想阅读jdk1.8源码提高自己的水平。



## 阅读顺序

> 来源https://zhuanlan.zhihu.com/p/77194152

JDK的项目历经了十几个大版本，算上开源社区的贡献，经手的人可能也达到上千人。对于这种庞大的项目，一次性读完肯定是不可能，必须先找到一个恰当的入口，分模块来一点点啃完。

可能的一种阅读顺序是：

1. 基本类型的包装类（Character放在最后）
2. String、StringBuffer、StringBuilder、StringJoiner、StringTokenizer（补充正则表达式的知识）
3. CharacterIterator、StringCharacterIterator、CharsetProvider、CharsetEncoder、CharsetDecoder（较难）
4. java.util.function下的函数表达式
5. java.nio下的各种Buffer实现
6. java.lang.ref和jdk.internal.ref下的各种引用：软引用/弱引用/虚引用
7. Unsafe的实现（JDK9之后有两个同名类，一个引用了另一个，建议放在一起阅读）
8. java.util.stream下的流式编程的实现（很难）
9. Thread和ThreadLocal
10. Math、Random、BigInteger、BigDecimal
11. java.lang.reflect下反射的实现（先掌握JDK 9之后引入的模块系统）
12. ClassLoader的实现
13. javax.lang.model下Java语言模型的实现（可以参考[Java官方语法文档]([The Java® Language Specification](https://link.zhihu.com/?target=https%3A//docs.oracle.com/javase/specs/jls/se12/html/index.html))）
14. 注解（需要彻底掌握）
15. Timer、ResourceBundle、Properties
16. 时间日期类型（尤其是Java8新增的部分）
17. java.lang.reflect.Proxy， JDK默认的动态代理
18. java.util.concurrent并发包。先读原子类，再读锁的实现类，最后阅读那些并发工具的实现（很难）
19. 集合框架，主要是三大类：List、Set、Map（先读非线程安全的实现，再读线程安全的实现）
20. 网络编程（主要阅读Socket通信部分，后续可以阅读HttpClient的实现）
21. IO，包含BIO/NIO/AIO（很难）
22. Files、Path等文件操作工具类
23. sql、xml处理类/接口
24. ......

注意，这里说的顺序只是一个大致的方向，并不代表需要绝对按照这个名单来。

在阅读某一个代码时，往往会牵涉到很多别的代码，这个时候就会产生很多阅读分支，分支的走向，并不在上述名单之内。



## 阅读进度

| 包                          | 类                         | 进度 |
| --------------------------- | -------------------------- | ---- |
| java.lang                   | Object                     | :o:  |
|                             | String                     |      |
|                             | AbstractStringBuilder      |      |
|                             | StringBuffer               |      |
|                             | StringBuilder              |      |
|                             | Boolean                    |      |
|                             | Byte                       |      |
|                             | Double                     |      |
|                             | Float                      |      |
|                             | Integer                    |      |
|                             | Long                       |      |
|                             | Short                      |      |
|                             | Thread                     |      |
|                             | ThreadLocal                |      |
|                             | Enum                       |      |
|                             | Throwable                  |      |
|                             | Error                      |      |
|                             | Exception                  |      |
|                             | Class                      |      |
|                             | ClassLoader                |      |
|                             | Compiler                   |      |
|                             | System                     |      |
|                             | Package                    |      |
|                             | Void                       |      |
|                             |                            |      |
| java.util                   | AbstractList               |      |
|                             | AbstractMap                |      |
|                             | AbstractSet                |      |
|                             | ArrayList                  |      |
|                             | LinkedList                 |      |
|                             | HashMap                    | :o:  |
|                             | Hashtable                  |      |
|                             | HashSet                    |      |
|                             | LinkedHashMap              |      |
|                             | LinkedHashSet              |      |
|                             | TreeMap                    |      |
|                             | TreeSet                    |      |
|                             | Vector                     |      |
|                             | Queue                      |      |
|                             | Stack                      |      |
|                             | SortedMap                  |      |
|                             | SortedSet                  |      |
|                             | Collections                |      |
|                             | Arrays                     |      |
|                             | Comparator                 |      |
|                             | Iterator                   |      |
|                             | Base64                     |      |
|                             | Date                       |      |
|                             | EventListener              |      |
|                             | Random                     |      |
|                             | SubList                    |      |
|                             | Timer                      |      |
|                             | UUID                       |      |
|                             | WeakHashMap                |      |
|                             |                            |      |
| java.util.concurrent        | ConcurrentHashMap          |      |
|                             | Executor                   |      |
|                             | AbstractExecutorService    |      |
|                             | ExecutorService            |      |
|                             | ThreadPoolExecutor         |      |
|                             | BlockingQueue              |      |
|                             | AbstractQueuedSynchronizer |      |
|                             | CountDownLatch             |      |
|                             | FutureTask                 |      |
|                             | Semaphore                  |      |
|                             | CyclicBarrier              |      |
|                             | CopyOnWriteArrayList       |      |
|                             | SynchronousQueue           |      |
|                             | BlockingDeque              |      |
|                             | Callable                   |      |
|                             |                            |      |
| java.util.concurrent.atomic | AtomicBoolean              |      |
|                             | AtomicInteger              |      |
|                             | AtomicLong                 |      |
|                             | AtomicReference            |      |
|                             |                            |      |
| java.lang.reflect           | Field                      |      |
|                             | Method                     |      |
|                             |                            |      |
| java.lang.annotation        | Annotation                 |      |
|                             | Target                     |      |
|                             | Inherited                  |      |
|                             | Retention                  |      |
|                             | Documented                 |      |
|                             | ElementType                |      |
|                             | Native                     |      |
|                             | Repeatable                 |      |
|                             |                            |      |
| java.util.concurrent.locks  | Lock                       |      |
|                             | Condition                  |      |
|                             | ReentrantLock              |      |
|                             | ReentrantReadWriteLock     |      |
|                             |                            |      |
| java.io                     | File                       |      |
|                             | InputStream                |      |
|                             | OutputStream               |      |
|                             | Reader                     |      |
|                             | Writer                     |      |
|                             |                            |      |
| java.nio                    | Buffer                     |      |
|                             | ByteBuffer                 |      |
|                             | CharBuffer                 |      |
|                             | DoubleBuffer               |      |
|                             | FloatBuffer                |      |
|                             | IntBuffer                  |      |
|                             | LongBuffer                 |      |
|                             | ShortBuffer                |      |
|                             |                            |      |
| java.sql                    | Connection                 |      |
|                             | Driver                     |      |
|                             | DriverManager              |      |
|                             | JDBCType                   |      |
|                             | ResultSet                  |      |
|                             | Statement                  |      |
|                             |                            |      |
| java.net                    | Socket                     |      |
|                             | ServerSocket               |      |
|                             | URI                        |      |
|                             | URL                        |      |
|                             | URLEncoder                 |      |


