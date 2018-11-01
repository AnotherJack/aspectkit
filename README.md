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

* @RequestPermissions
	
	动态请求权限，在你需要权限的方法上加RequestPermissions注解，把需要的权限传入注解参数，可传入多个权限
	
	```
	@RequestPermissions({Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE})
    private void takePhoto(){
    	//your code
        ...
    }
	```
	
* TODO