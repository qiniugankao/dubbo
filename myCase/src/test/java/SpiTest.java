import static java.util.ServiceLoader.load;
import static java.util.stream.StreamSupport.stream;

import com.alibaba.dubbo.common.URL;
import java.util.Arrays;
import java.util.ServiceLoader;
import java.util.concurrent.CopyOnWriteArrayList;
import mycase.spi.adaptive.AdaptiveExt2;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.common.extension.LoadingStrategy;
import org.junit.jupiter.api.Test;

public class SpiTest {

  @org.junit.jupiter.api.Test
  public void test1() {
    ExtensionLoader<AdaptiveExt2> loader = ExtensionLoader.getExtensionLoader(AdaptiveExt2.class);
    AdaptiveExt2 adaptiveExtension = loader.getAdaptiveExtension();
    URL url = URL.valueOf("test://localhost/test");
    System.out.println(adaptiveExtension.echo("d", url));
  }

  @Test
  public void test2() {
    ExtensionLoader<AdaptiveExt2> loader = ExtensionLoader.getExtensionLoader(AdaptiveExt2.class);
    AdaptiveExt2 adaptiveExtension = loader.getAdaptiveExtension();
    URL url = URL.valueOf("test://localhost/test?adaptive.ext2=cloud");
    System.out.println(adaptiveExtension.echo("d", url));
  }
  @Test
  public void test3(){
    ExtensionLoader<AdaptiveExt2> loader = ExtensionLoader.getExtensionLoader(AdaptiveExt2.class);
    AdaptiveExt2 adaptiveExtension = loader.getAdaptiveExtension();
    URL url = URL.valueOf("test://localhost/test?ext2=cloud");
    System.out.println(adaptiveExtension.echo("d", url));
  }


}
