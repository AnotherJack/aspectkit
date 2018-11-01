## developing，基于Aspectj的开发工具，减少机械的重复工作。自用

# Setup
1. in your **root build.gradle**

	```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	```
	and
	
	```
	dependencies {
        ...
        classpath 'com.hujiang.aspectjx:gradle-android-plugin-aspectjx:2.0.4'
       
    }
	```
	
2. in your **module build.gradle**

	```
	dependencies {
		implementation 'com.github.AnotherJack:aspectkit:master'
	}
	```
	and
	
	```
	apply plugin: 'android-aspectjx'
	```
	
	
# Usage

TODO