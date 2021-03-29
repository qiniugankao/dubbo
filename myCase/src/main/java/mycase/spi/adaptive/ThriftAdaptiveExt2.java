package mycase.spi.adaptive;

import com.alibaba.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;

//@Adaptive
public class ThriftAdaptiveExt2 implements AdaptiveExt2 {

  @Override
  public String echo(String msg, URL url) {
    return "thrift";
  }
}