package mycase.spi.adaptive;

import com.alibaba.dubbo.common.URL;

public class DubboAdaptiveExt2 implements AdaptiveExt2 {

  @Override
  public String echo(String msg, URL url) {
    return "dubbo";
  }
}
