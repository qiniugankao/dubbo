package mycase.spi.adaptive;

import com.alibaba.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;


@SPI(value = "dubbo")
public interface AdaptiveExt2 {
  @Adaptive({"ext1","ext2"})
  String echo(String msg, URL url);
}
