package com.hayukleung.x.base.di.component;

import com.hayukleung.x.base.di.module.XModuleApp;
import com.hayukleung.x.base.ui.BaseActivity;
import dagger.Component;
import javax.inject.Singleton;

// @Component: Components 从根本上来说就是一个注入器
// 也可以说是 @Inject 和 @Module 的桥梁
// 它的主要作用就是连接这两个部分
// Components 可以提供所有定义了的类型的实例
// 比如：我们必须用@Component注解一个接口然后列出所有的@Modules组成该组件
// 如果缺失了任何一块都会在编译的时候报错
// 所有的组件都可以通过它的 modules 知道依赖的范围
@Singleton @Component(modules = XModuleApp.class) public interface XComponentApp {

  /**
   * 注入
   *
   * @param baseActivity Activity
   */
  void inject(BaseActivity baseActivity);
}
