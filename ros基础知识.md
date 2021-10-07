#             ros基础知识

### ros通信方式

topic 

service

action

#### 坐标变换

##### 欧拉角 四元素 旋转矩阵之间的转换

##### 给你一个机器人旋转的方向（arfa,beta,sita）



#### map odom base_link之间坐标系的关系

**map**坐标系就是你加载出来的地图。是固定不变的，一般作为fixed_frame。map坐标系方向是 加载后的地图左下角为原点，向右为x轴负方向，向上为y轴负方向。

**odom** 是里程计的坐标系。开机后一般是(0，0)，与机器人base_link是重合的，但是随着时间的推移，由于误差导致base_link不再重合。一般是将odom作为map与base_link坐标系之间纠偏的坐标系进行转换。他们的关系是map->odom->base_link。

**base_link**就是机器人自身的坐标系，一般是以机器人的中心点为远点，向左有y轴正方向，向右为x轴正方向。

要移动机器人，那么对应软件上需要改变base_link的坐标系，同时在地图上体现出来，需要对应map坐标系变化。具体做法是，首先要通知就需要向tf发布，geometry_msgs/TransformStamped 消息通知ros base_linke相对于map的tf转换关系，也就是说告诉ROS运动的base_link相对于不动的odom位置偏移。

##### 获取到基于map到base_link的坐标系

在tf中有个函数，

**lookupTransform**

lookupTransform()是一个更底层的方法用于返回两个坐标系的变换。

这个方法是 tf库的核心方法。大部分transform*的方法都是终端用户使用，而这个方法设计在transform*()方法内使用的。

返回的变换的方向将从target_frame到source_frame。 如果应用于数据，将把source_frame中的数据转换为target_frame。查阅[geometry/CoordinateFrameConventions#Transform_Direction](http://wiki.ros.org/geometry/CoordinateFrameConventions#Transform_Direction)

这个方法会抛出TF的异常

基本API：

```c++
void tf::TransformListener::lookupTransform (const std::string &target_frame, const std::string &source_frame, const ros::Time &time, StampedTransform &transform) const 
```

#### 里程计的计算

里程计的计算主要是用编码器，







